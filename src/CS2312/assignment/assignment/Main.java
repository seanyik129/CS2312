package CS2312.assignment.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    /** Main program entry point */
    public static void main(String[] args) throws FileNotFoundException {
        // Get input file path from user
        Scanner in = new Scanner(System.in);
        System.out.print("Please input the file pathname: ");
        final String filePathName = in.nextLine();
        Scanner inFile = new Scanner(new File(filePathName));

        // Process first line to initialize system date
        String cmdLine1 = inFile.nextLine();
        String[] cmdLine1Parts = cmdLine1.split(" ");
        System.out.println("\n> " + cmdLine1);
        SystemDate.createTheInstance(cmdLine1Parts[1]);

        // Process remaining commands
        while (inFile.hasNext()) {
            String cmdLine = inFile.nextLine().trim();

            // Skip empty lines
            if (cmdLine.isEmpty()) {
                continue;
            }

            System.out.println("\n> " + cmdLine);
            String[] cmdParts = cmdLine.split(" ");

            try {
                // Route command to appropriate handler
                switch (cmdParts[0]) {
                    case "register": {
                        if (cmdParts.length != 3) {
                            throw new ExInsufficientArguments();
                        }
                        (new CmdRegister()).execute(cmdParts);
                        break;
                    }

                    case "listMembers": {
                        (new CmdListMembers()).execute(cmdParts);
                        break;
                    }

                    case "startNewDay": {
                        if (cmdParts.length != 2) {
                            throw new ExInsufficientArguments();
                        }
                        (new CmdStartNewDay()).execute(cmdParts);
                        break;
                    }

                    case "create": {
                        if (cmdParts.length != 3) {
                            throw new ExInsufficientArguments();
                        }
                        (new CmdCreate()).execute(cmdParts);
                        break;
                    }

                    case "arrive": {
                        if (cmdParts.length < 2) {
                            throw new ExInsufficientArguments();
                        }
                        (new CmdArrive()).execute(cmdParts);
                        break;
                    }

                    case "request": {
                        if (cmdParts.length < 5) {
                            throw new ExInsufficientArguments();
                        }
                        (new CmdRequest()).execute(cmdParts);
                        break;
                    }

                    case "listEquipment": {
                        (new CmdListEquipment()).execute(cmdParts);
                        break;
                    }

                    case "listMemberStatus": {
                        (new CmdListMemberStatus()).execute(cmdParts);
                        break;
                    }

                    case "listEquipmentStatus": {
                        (new CmdListEquipmentStatus()).execute(cmdParts);
                        break;
                    }

                    case "borrow": {
                        if (cmdParts.length < 3) {
                            throw new ExInsufficientArguments();
                        }
                        (new CmdBorrow()).execute(cmdParts);
                        break;
                    }

                    case "undo": {
                        RecordedCommand.undoOneCommand();
                        break;
                    }

                    case "redo": {
                        RecordedCommand.redoOneCommand();
                        break;
                    }

                    default: {
                        throw new ExUnknownCommand("Unknown command - ignored.");
                    }
                }
            } catch (ExInsufficientArguments e) {
                System.out.println("Insufficient command arguments.");
            } catch (ExUnknownCommand e) {
                System.out.println(e.getMessage());
                break;
            }
        }

        // Close resources
        inFile.close();
        in.close();
    }
}