package test;


import TeamOneMiniProject.Member;

import java.util.Scanner;

import static TeamOneMiniProject.JsonFileHandling.convertJsonToObject;

class mainMethod {


    public static void main(String[] args) {
        Member[] member = convertJsonToObject("C:\\Users\\ramzi\\Documents\\Minigit\\project-group-1\\src\\JsonFiles\\members.json", Member[].class);

        String ID;
        String Answer;


        System.out.println("\n***Welcome To Team One ***\n ");

        do {
            Scanner scanner = new Scanner((System.in));

            System.out.println("\nChoose the type of information from the list:\n");
            System.out.println("1: Get the Earned Value (EV)");
            System.out.println("2: Get the Schedule Variance (SV)");
            System.out.println("3: Get the Cost Variance (CV)");
            System.out.println("4: Risk Matrix");
            System.out.println("5: Project Schedule");
            System.out.println("6: Time spent by the member");
            System.out.println("7: Work products where the member participated");
            System.out.println("8: Exit program");

            Answer = scanner.nextLine();

            if (Answer.equals("")) {
                System.out.println("The answer cannot be empty! \n");
            }
            if (!Answer.equals("1") && !Answer.equals("2") && !Answer.equals("3") && !Answer.equals("4") && !Answer.equals("5") && !Answer.equals("6") && !Answer.equals("7") && !Answer.equals("8")) {
                System.out.println("You didn't enter a valid answer. Try again!");
            }

            if (Answer.equals("1")) {
                //CALL THE METHOD retreive the calculation done in the EV class
            }
            if (Answer.equals("2")) {
                //CALL THE METHOD retreive the calculation done in the SV class
            }
            if (Answer.equals("3")) {
                //CALL THE METHOD retreive the calculation done in the CV class
            }
            if (Answer.equals("4")) {
                //CALL THE METHOD retreive the calculation done in the Risk Matrix class
            }
            if (Answer.equals("5")) {
                //CALL THE METHOD retreive the calculation done in the Project Schedule class
            }
            if (Answer.equals("6")) {
                System.out.println("-----------------------------------------------");
                System.out.println("\nTeam Member Name:                       ID # ");
                System.out.println("----------------------------------------------- \n");
                System.out.println(member[1].getFullName() + "                               " + member[1].getId());
                System.out.println(member[2].getFullName() + "                               " + member[2].getId());
                System.out.println(member[3].getFullName() + "                               " + member[3].getId());
                System.out.println(member[4].getFullName() + "                               " + member[4].getId());
                System.out.println(member[5].getFullName() + "                               " + member[5].getId());



                System.out.println("Enter the ID of the member: ");


                do {
                    ID = scanner.nextLine();
                    if (ID.equals("")) {
                        System.out.println("The ID of the member cannot be empty! \n");
                    }
                    if (!ID.equals(member[1].getId()) && !ID.equals(member[2].getId()) && !ID.equals(member[3].getId()) && !ID.equals(member[4].getId()) && !ID.equals(member[5].getId()) ) {
                        System.out.println("You didn't enter a valid ID number. Try again!");
                    }
                } while (!ID.equals(member[1].getId()) && !ID.equals(member[2].getId()) && !ID.equals(member[3].getId()) && !ID.equals(member[4].getId()) && !ID.equals(member[5].getId()) );

                // CALL CALCULATION FOR 6 WITH with memberID AS argument for the method
            }
            if (Answer.equals("7")) {
                System.out.println("-----------------------------------------------");
                System.out.println("\nTeam Member Name:                       ID # ");
                System.out.println("----------------------------------------------- \n");
                System.out.println(member[1].getFullName() + "                               " + member[1].getId());
                System.out.println(member[2].getFullName() + "                               " + member[2].getId());
                System.out.println(member[3].getFullName() + "                               " + member[3].getId());
                System.out.println(member[4].getFullName() + "                               " + member[4].getId());
                System.out.println(member[5].getFullName() + "                               " + member[5].getId());



                System.out.println("Enter the ID of the member: ");


                do {
                    ID = scanner.nextLine();
                    if (ID.equals("")) {
                        System.out.println("The ID of the member cannot be empty! \n");
                    }
                    if (!ID.equals(member[1].getId()) && !ID.equals(member[2].getId()) && !ID.equals(member[3].getId()) && !ID.equals(member[4].getId()) && !ID.equals(member[5].getId()) ) {
                        System.out.println("You didn't enter a valid ID number. Try again!");
                    }
                } while (!ID.equals(member[1].getId()) && !ID.equals(member[2].getId()) && !ID.equals(member[3].getId()) && !ID.equals(member[4].getId()) && !ID.equals(member[5].getId()) );

                // CALL CALCULATION FOR 7WITH with memberID AS argument for the method

            }


        } while (!Answer.equals("8"));

        System.out.println("Thank you for using the program!");


    }
}
