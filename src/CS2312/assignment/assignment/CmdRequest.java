package CS2312.assignment.assignment;

/** Command class to handle equipment request operations */
public class CmdRequest extends RecordedCommand {
    private EquipmentSet requestedSet;  // Equipment set being requested
    private String memberId;            // ID of requesting member
    private String equipmentCode;       // Code of requested equipment
    private Day startDate;              // Request start date
    private int duration;               // Request duration
    private Day endDate;                // Request end date
    private String[] startDay;          // Split components of start date

    @Override
    public void execute(String[] cmdParts) {
        try {
            // Get system instance and basic info
            Club club = Club.getInstance();
            memberId = cmdParts[1];
            equipmentCode = cmdParts[2];

            // Parse and validate start date format
            startDay = cmdParts[3].split("-");
            if (startDay[0].length() < 2) {
                if (!CmdStartNewDay.isProperFormat("0" + cmdParts[3])) {
                    throw new ExInvalidDate("Invalid date.");
                }
            } else {
                if (!CmdStartNewDay.isProperFormat(cmdParts[3])) {
                    throw new ExInvalidDate("Invalid date.");
                }
            }

            // Set request dates and duration
            startDate = new Day(cmdParts[3]);
            duration = Integer.parseInt(cmdParts[4]);

            if (duration <= 0)
                throw new ExInvalidDays("The number of days must be at least 1.");

            endDate = startDate.endDay(duration);

            // Validate member exists
            Member member = club.findMember(memberId);
            if (member == null)
                throw new ExMissingMemberRecord("Member not found.");

            // Validate equipment exists
            Equipment equipment = club.findEquipment(equipmentCode);
            if (equipment == null)
                throw new ExMissingEquipmentRecord("Equipment record not found.");

            // Check for overlapping requests/borrows
            for (EquipmentSet set : equipment.getEquipmentSets()) {
                if (set.hasOverlappingRequestOrBorrow(memberId, startDate, endDate)) {
                    throw new ExPeriodOverlap("The period overlaps with a current period that the member borrows / requests the equipment.");
                }
            }

            // Find available equipment set
            requestedSet = null;
            for (EquipmentSet set : equipment.getEquipmentSets()) {
                if (!set.isRequestConflict(startDate, endDate)) {
                    requestedSet = set;
                    break;
                }
            }

            if (requestedSet == null)
                throw new ExUnavailableEquipment("There is no available set of this equipment for the command.");

                // Process successful request
            else
                requestedSet.addRequested(memberId, duration, startDate);

            member.incrementRequestCount();

            System.out.printf("%s %s requests %s (%s) for %s to %s\n",
                    memberId,
                    member.getName(),
                    requestedSet.getSetCode(),
                    equipment.getName(),
                    startDate.toString(),
                    endDate.toString());
            System.out.println("Done.");

            addUndoCommand(this);
            clearRedoList();

        } catch (ExMissingMemberRecord e) {
            System.out.println(e.getMessage());
        } catch (ExMissingEquipmentRecord e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Please provide an integer for the number of days.");
        } catch (ExInvalidDate e) {
            System.out.println(e.getMessage());
        } catch (ExInvalidDays e) {
            System.out.println(e.getMessage());
        } catch (ExPeriodOverlap e) {
            System.out.println(e.getMessage());
        } catch (ExUnavailableEquipment e) {
            System.out.println(e.getMessage());
        }
    }

    /** Undo request command - remove request and update request count */
    @Override
    public void undoMe() {
        int lastIndex = requestedSet.getRequestMembers().size() - 1;
        if (lastIndex >= 0) {
            requestedSet.getRequestStartDate().remove(lastIndex);
            requestedSet.getRequestEndDate().remove(lastIndex);
            requestedSet.getRequestMembers().remove(lastIndex);
        }
        Club.getInstance().findMember(memberId).decrementRequestCount();
        addRedoCommand(this);
    }

    /** Redo request command - restore request and update request count */
    @Override
    public void redoMe() {
        requestedSet.addRequested(memberId, duration, startDate);
        Club.getInstance().findMember(memberId).incrementRequestCount();
        addUndoCommand(this);
    }
}