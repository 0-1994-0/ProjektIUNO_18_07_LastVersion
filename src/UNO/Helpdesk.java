package UNO;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Helpdesk {

/*
        // GameMethods gameMethods = new GameMethods();
       // public void menu () throws IOException {
            String choice = null;
            System.out.println("For help tip 'h'");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextLine();
            while (!choice.toUpperCase().equals("h")) {
           /* System.out.println("\nMenu:");
            System.out.println("1. I need help");
            System.out.println("2. I want to challenge you");
            System.out.println("3. I want to play a card");
            System.out.println("4. I cannot play a card");
            System.out.println("5. Let me say UNO!");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");*/


        // Handle the user's choice
        //   switch (choice) {
        //     case "h":
        //  createHelpFile();
        //       break;
               /* case 2:
                    System.out.println("I will challenge you!");
                    break;
                case 3:
                    gameMethods.printTopCardOfDiscardPile();
                    gameMethods.playerPlaysCard();
                    gameMethods.isChosenCardValid();
                    gameMethods.acceptPlayersInput();
                    gameMethods.printTopCardOfDiscardPile();
                    gameMethods.nextTurn();
                    break;
                case 4:
                    System.out.println("I dont believe that you did not have another card to play!");
                    break;
                case 5:
                    System.out.println("I cannot play a card");
                    break;
                case 6:
                    System.out.println("Goodbye");
                    break;
                default:
                    // Handle invalid input
                    System.out.println("Invalid choice");
                    break;
            }
                }
                scanner.close();
            }

        }*/


    public void helpFile() {


        /*

        System.out.println("For help tip 'h', for no Help tip 'enter'");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        if (choice.equals("H") || choice.equals("h")) {
            //  String filename = "filename.txt";
            File file = new File("help.txt");

            // System.out.println(file.getAbsolutePath());
            BufferedReader bufferedReader1 = null;
            try {
                //InputStreamReader inputStreamReader = new InputStreamReader(file);
                FileReader fileReader = new FileReader(file);
                bufferedReader1 = new BufferedReader(fileReader);
                // Scanner input = new Scanner(System.in);

                //System.out.println(file.getAbsolutePath());
                String line;
                while ((line = bufferedReader1.readLine()) != null) {

                    System.out.println(line);

                    // bufferedWriter.write(line);
                    //bufferedWriter.newLine();
                }
                bufferedReader1.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
                // bufferedWriter.flush();
                //bufferedWriter.close();

            }
        }
    }
}*/


        String choice = "ok";
        boolean condition = false;


        while (!(choice.equals("H") || choice.equals("h")||choice.isEmpty())) {
            //Die Enter-Taste wird als falsche Eingabe erkannt...

       File file = new File("help.txt");
            System.out.println("For help tip 'h', for no help tip 'Enter'");
            Scanner scanner = new Scanner(System.in);

            try {
                choice = scanner.nextLine();
                System.out.println(choice);

                if (choice.equals("H") || choice.equals("h")) {
                    //  String filename = "filename.txt";


                    // System.out.println(file.getAbsolutePath());
                    BufferedReader bufferedReader1 = null;
                    try {
                        //InputStreamReader inputStreamReader = new InputStreamReader(file);
                        FileReader fileReader = new FileReader(file);
                        bufferedReader1 = new BufferedReader(fileReader);
                        // Scanner input = new Scanner(System.in);

                        //System.out.println(file.getAbsolutePath());
                        String line;
                        while ((line = bufferedReader1.readLine()) != null) {

                            System.out.println(line);

                            // bufferedWriter.write(line);
                            //bufferedWriter.newLine();
                        }
                        bufferedReader1.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                        // bufferedWriter.flush();
                        //bufferedWriter.close();
                    }
                }
            } catch (InputMismatchException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }
}