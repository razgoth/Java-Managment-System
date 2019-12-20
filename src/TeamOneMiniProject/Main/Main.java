package TeamOneMiniProject.Main;

    import TeamOneMiniProject.Member;
import TeamOneMiniProject.Project;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

    import static TeamOneMiniProject.JsonFileHandling.convertJsonToObject;

public class Main {
        Scanner scanner = new Scanner((System.in));
        Project projectSunShine = convertJsonToObject("C:\\Users\\ramzi\\Documents\\Minigit\\project-group-1\\src\\JsonFiles\\ProjectSunShine.json", Project.class) ;

        private final int EARNED_VALUE = 1;
        private final int SCHEDULE_VARIANCE = 2;
        private final int COST_VARIANCE = 3;
        private final int RISK_MATRIX = 4;
        private final int PROJECT_SCHEDULE = 5;
        private final int TIME_OF_MEMBERS = 6;
        private final int MEMBER_PARTICIPATION = 7;
        private final int QUIT = 8;

        public void run() {
            int userInputMenu;

            do {
                printMenu();
                userInputMenu = readInputInt("Enter option: ");

                switch (userInputMenu) {
                    case EARNED_VALUE:
                        printEarnedValue();
                        break;

                    case SCHEDULE_VARIANCE:
                        printScheduleVariance();
                        break;

                    case COST_VARIANCE:
                        printCostVariance();
                        break;

                    case RISK_MATRIX:
                        printRiskMatrix();
                        break;

                    case PROJECT_SCHEDULE:
                        printProjectSchedule();
                        break;

                    case TIME_OF_MEMBERS:
                        printTimeOfMembers();
                        break;

                    case MEMBER_PARTICIPATION:
                        printMemberParticipation();
                        break;

                    case QUIT:
                        System.out.println("Thank you for using the project. Hopefully Project Sunshine was successful!");
                        return;

                    default:
                        System.out.println("Please input a valid option!");

                }

            }while (userInputMenu != QUIT);

        }

        private void printMenu() {
            System.out.println("\n***Welcome To Team One ***\n ");
            System.out.println("1: Get the Earned Value (EV)");
            System.out.println("2: Get the Schedule Variance (SV)");
            System.out.println("3: Get the Cost Variance (CV)");
            System.out.println("4: Risk Matrix");
            System.out.println("5: Project Schedule");
            System.out.println("6: Total time spent per team member");
            System.out.println("7: Member specific information");
            System.out.println("8: Exit program\n");

        }

        private String readInputString(String userMessage) {
            String userInput;

            System.out.println(userMessage);
            userInput = scanner.nextLine();
            return userInput;

        }

        private int readInputInt(String userMessage) {
            int userInput;

            System.out.println(userMessage);
            userInput = scanner.nextInt();
            scanner.nextLine();
            return userInput;

        }

        private void printEarnedValue(){
            for(int i = 1 ; i<projectSunShine.getWorkPackages().length ; i += 2) {
                double earnedValue = projectSunShine.getEarnedValue(i);
                System.out.println(earnedValue);
            }

        }

        private void printScheduleVariance(){
            for(int i = 2 ; i<projectSunShine.getWorkPackages().length ; i += 2) {
                double scheduleVariance = projectSunShine.getScheduleVariance(i);
                System.out.println(scheduleVariance);
            }
        }

        private void printCostVariance(){
            for (int  i = 2 ; i <projectSunShine.getWorkPackages().length; i +=2){
            double costVariance = projectSunShine.getCostVariance(i);
            System.out.println(costVariance);}

        }

        private void printRiskMatrix(){
            HashMap<String, Double>  riskMatrix = projectSunShine.getRiskMatrix();
            System.out.println(riskMatrix);

        }

        private void printProjectSchedule(){
            String projectSchedule = projectSunShine.getProjectSchedule();
            System.out.println(projectSchedule);

        }

        private void printTimeOfMembers() {
            double timeOfMembers = projectSunShine.getTimeOfMembers();
            System.out.println(timeOfMembers);

        }


        public static void printHoursHash(Member foundMember){
            double totHours = 0;
            if(foundMember != null) {
                HashMap<String, Double> work = foundMember.getWork();
                System.out.println(foundMember.getFullName()+"'s worked hours:");
                for(Map.Entry<String, Double> week : work.entrySet()) {
                    System.out.println(week.getKey()+": "+week.getValue());
                    totHours += week.getValue();
                }
                System.out.println("Total hours worked: "+totHours);
            } else {
                System.out.println("A member with input ID was not found");
            }
        }

        private final int TIME_BY_MEMBER = 1;
        private final int WORKPACKAGES_BY_MEMBER = 2;
        private final int GO_BACK = 3;

        private void printMemberParticipation() {

            String id;
            int userInputMemberParticipation;

            do {
                printMemberSubMenu1();
                userInputMemberParticipation = readInputInt("Enter option: \n");

                switch (userInputMemberParticipation) {
                    case TIME_BY_MEMBER:
                        printMemberSubMenu2();
                        id = readInputString("Enter valid ID of Team Member: \n");
                        Member timeByMember = projectSunShine.getTimeByMember(id);
                        printHoursHash(timeByMember);
                        break;

                  case WORKPACKAGES_BY_MEMBER:
                        printMemberSubMenu2();
                        id = readInputString("Enter valid ID of Team Member: \n");
                        String memberParticipation = projectSunShine.getMemberParticipation(id);
                        System.out.println(memberParticipation);
                        break;

                    case GO_BACK:
                        System.out.println("You are going home, sailor!");
                        break;

                    default:
                        System.out.println("Please input a valid option!");

                }

            } while (userInputMemberParticipation != 3);

        }

        private void printMemberSubMenu1(){
            System.out.println("\n***Welcome To Team Member Data ***\n ");
            System.out.println("1: Get the time spent by a team member of you choice");
            System.out.println("2: Get the work packages worked on by a team member of you choice");
            System.out.println( "Go back to main menu! ");

        }

        private void printMemberSubMenu2(){
            HashMap<String, String> memberId = projectSunShine.getMemberId();
            for(String key : memberId.keySet()) {
                System.out.println(key+" : "+memberId.get(key));
            }
        }

        public static void main(String[] args) {
            Main projectManagementProgram = new Main();
            projectManagementProgram.run();

        }

    }
