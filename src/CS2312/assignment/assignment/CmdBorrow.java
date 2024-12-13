package CS2312.assignment.assignment;

/** Command class to handle equipment borrowing operations */
public class CmdBorrow extends RecordedCommand {
    private Member member;          // Member who is borrowing
    private String id;             // Member ID
    private String name;           // Member name
    private Equipment equipment;    // Equipment being borrowed
    private EquipmentSet borrowedSet; // Set being borrowed
    final int DEFAULT_DURATION = 7; // Default loan period
    private int duration;          // Actual loan duration
    private Club club;             // Club instance
    private SystemDate systemDate; // Current system date
    private Day startDate;        // Loan start date
    private Day endDate;          // Loan end date

    @Override
    public void execute(String[] cmdParts) {
        try {
            // Get system instances and basic info
            club = Club.getInstance();
            id = cmdParts[1];

            // Validate member exists
            this.member = club.findMember(id);
            if (this.member == null)
                throw new ExMissingMemberRecord("Member not found.");

            String equipmentCode = cmdParts[2];
            systemDate = SystemDate.getInstance();
            name = member.getName();

            // Parse and validate duration
            if (cmdParts.length == 4) {
                try {
                    duration = Integer.parseInt(cmdParts[3]);
                    if (duration < 1) {
                        throw new ExInvalidDays("The number of days must be at least 1.");
                    }
                } catch (NumberFormatException e) {
                    throw new ExInvalidDays("Please provide an integer for the number of days.");
                }
            } else {
                duration = DEFAULT_DURATION;
            }

            // Calculate borrow period
            startDate = SystemDate.getInstance().clone();
            endDate = startDate.endDay(duration);

            // Validate equipment exists
            equipment = club.findEquipment(equipmentCode);
            if (equipment == null)
                throw new ExMissingEquipmentRecord("Equipment record not found.");

            borrowedSet = null;

            // First check for available equipment set
            for (EquipmentSet set : equipment.getEquipmentSets()) {
                if (set.isAvailableForBorrow(startDate, endDate)) {
                    if (!set.hasOverlappingRequestOrBorrow(id, startDate, endDate)) {
                        borrowedSet = set;
                        break;
                    }
                }
            }

            if (borrowedSet == null) {
                throw new ExUnavailableEquipment("There is no available set of this equipment for the command.");
            }

            // Check for overlapping requests
            for (EquipmentSet set : equipment.getEquipmentSets()) {
                if (set.hasOverlappingRequest(id, systemDate, duration)) {
                    throw new ExPeriodOverlap("The period overlaps with a current period that the member requests the equipment.");
                }
            }

            // Check if member is already borrowing this equipment
            for (EquipmentSet set : equipment.getEquipmentSets()) {
                if (!set.isAvailableForBorrow(startDate, endDate) && set.getCurrentBorrower().equals(id)) {
                    throw new ExCurrentBorrowing("The member is currently borrowing a set of this equipment. He/she cannot borrow one more at the same time.");
                }
            }

            // Final check for available set
            borrowedSet = null;
            for (EquipmentSet set : equipment.getEquipmentSets()) {
                if (set.isAvailableForBorrow(startDate, endDate)) {
                    if (!set.hasOverlappingRequestOrBorrow(id, startDate, endDate)) {
                        borrowedSet = set;
                        break;
                    }
                }
            }

            if (borrowedSet == null) {
                throw new ExUnavailableEquipment("There is no available set of this equipment for the command.");
            }

            // Process successful borrow
            borrowedSet.markAsBorrowed(id, duration);
            System.out.printf("%s %s borrows %s (%s) ", id, name, borrowedSet.getSetCode(), club.findEquipment(equipmentCode).getName());
            System.out.printf("for %s to %s\n", systemDate, systemDate.endDay(duration));
            System.out.println("Done.");

            member.incrementBorrowCount();
            addUndoCommand(this);
            clearRedoList();

        } catch (ExUnavailableEquipment e) {
            System.out.println(e.getMessage());
        } catch (ExMissingMemberRecord e) {
            System.out.println(e.getMessage());
        } catch (ExMissingEquipmentRecord e) {
            System.out.println(e.getMessage());
        } catch (ExCurrentBorrowing e) {
            System.out.println(e.getMessage());
        } catch (ExInvalidDays e) {
            System.out.println(e.getMessage());
        } catch (ExPeriodOverlap e) {
            System.out.println(e.getMessage());
        }
    }

    /** Undo borrow command - mark equipment as available and update borrow count */
    @Override
    public void undoMe() {
        borrowedSet.markAsAvailable();
        member.incrementBorrowCount();
        addRedoCommand(this);
    }

    /** Redo borrow command - re-mark equipment as borrowed and update borrow count */
    @Override
    public void redoMe() {
        borrowedSet.markAsBorrowed(member.getID(), duration);
        member.decrementBorrowCount();
        addUndoCommand(this);
    }
}