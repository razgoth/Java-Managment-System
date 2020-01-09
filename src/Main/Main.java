package Main;

import TeamOneMiniProject.Member;
import TeamOneMiniProject.Project;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static TeamOneMiniProject.JsonFileHandling.convertJsonToObject;

public class Main {
    Scanner scanner = new Scanner((System.in));
    Project projectSunShine = convertJsonToObject("/Users/Johann/IdeaProjects/project-group-1/src/JsonFiles/ProjectSunShine.json", Project.class);

    private final String EARNED_VALUE = "1";
    private final String SCHEDULE_VARIANCE = "2";
    private final String COST_VARIANCE = "3";
    private final String RISK_MATRIX = "4";
    private final String PROJECT_SCHEDULE = "5";
    private final String TIME_OF_MEMBERS = "6";
    private final String MEMBER_PARTICIPATION = "7";
    private final String QUIT = "8";


    public void run() {
        String userInputMenu;
        try {
            do {
                printMenu();
                userInputMenu = readInputString("Enter option: ");

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
                        System.out.println("Thank you for using the Project SunShine!");
                        return;

                    default:
                        System.out.println("Please input a valid option!");

                }


            } while (!userInputMenu.equalsIgnoreCase(QUIT));
        } catch (Exception e) {
            System.out.println("Something went wrong");
           // e.printStackTrace();
        }

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


    private void printEarnedValue() {
        System.out.println("Earned Value\n");
        double EVTotal = 0;

        for (int i = 1; i < projectSunShine.getWorkPackages().length; i += 2) {

            double earnedValue = projectSunShine.getEarnedValue(i);
            EVTotal += earnedValue;
            System.out.println("Earned Value for week " + i + " and week " + (i + 1) + "  : " + earnedValue);
        }
        System.out.println("\nTotal Earned Value: " + EVTotal);
    }

    private void printScheduleVariance() {
        for (int i = 2; i < projectSunShine.getWorkPackages().length; i += 2) {
            double scheduleVariance = projectSunShine.getScheduleVariance(i);
            System.out.println("Schedule Variance for week " + (i - 1) + " and week " + i + "  : " + scheduleVariance);
        }
    }

    private void printCostVariance() {
        for (int i = 2; i < projectSunShine.getWorkPackages().length; i += 2) {
            double costVariance = projectSunShine.getCostVariance(i);
            System.out.println("Cost Variance for week " + (i - 1) + " and week " + i + "  : " + costVariance);
        }
    }

    private void printRiskMatrix() {
        HashMap<String, Double> riskMatrix = projectSunShine.getRiskMatrix();
        for (String key : riskMatrix.keySet()) {
            System.out.printf( "%25s  %23s %n",key, riskMatrix.get(key));
            }
    }

    private void printProjectSchedule() {
        System.out.println("Project Schedule\n");
        System.out.println("Project Name: " + projectSunShine.getProjectName());
        System.out.println("Start Week: " + projectSunShine.getStartWeek());
        System.out.println("End Week: " + projectSunShine.getEndWeek());
        System.out.printf("\n%s %17s %4s %12s %4s %n\n", "|", "Work Package", "|", "Week", "|");
        for (int i = 0; i < projectSunShine.getWorkPackages().length; i++) {
            System.out.println(projectSunShine.getActivitySchedule(i));
        }
    }

    private void printTimeOfMembers() {
        HashMap<String, Double> timeOfMembers = projectSunShine.getTimeOfMembers();
        Double totalHours = projectSunShine.getTotalHours();
        System.out.println("\nTime spent per member");

        System.out.printf("\n%4s %s %s %2s %s %n\n", "|", "Name", "|", "Hours", "|");
        for (String key : timeOfMembers.keySet()) {
            System.out.printf("%10s %1s %s %n", key, ":", timeOfMembers.get(key));
        }
        System.out.printf("\n%12s %2s \n", "Total : ", totalHours);
    }


    public static void printHoursHash(Member foundMember) {
        double totalHours = 0;
        if (foundMember != null) {
            LinkedHashMap<String, Double> work =  foundMember.getWork();

            System.out.println(foundMember.getFullName() + "'s worked hours:");
            System.out.printf("\n%s %s %2s %s %s %n\n", "|", "Week", "|", "Hours", "|");

            for (Map.Entry<String, Double> week : work.entrySet()) {
                System.out.println("  " + week.getKey() + ":  " + week.getValue());
                totalHours += week.getValue();
            }
            System.out.println("\nTotal hours worked: " + totalHours);
        } else {
            System.out.println("A member with input ID was not found");
        }
    }

    private final String TIME_BY_MEMBER = "1";
    private final String WORKPACKAGES_BY_MEMBER = "2";
    private final String GO_BACK = "3";

    private void printMemberParticipation() {

        String id;
        String userInputMemberParticipation;

        do {
            printMemberSubMenu1();
            userInputMemberParticipation = readInputString("Enter option: \n");

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
                    System.out.println("Back to the main menu");
                    break;

                default:
                    System.out.println("Please input a valid option!");

            }

        } while (!userInputMemberParticipation.equalsIgnoreCase("3"));

    }

    private void printMemberSubMenu1() {
        System.out.println("\n***Welcome To Team Member Data ***\n ");
        System.out.println("1: Get the time spent by a team member of you choice");
        System.out.println("2: Get the work packages worked on by a team member of you choice");
        System.out.println("3: Go back to main menu! ");

    }

    private void printMemberSubMenu2() {
        System.out.printf("\n%s %s %s %2s %4s %n\n", "|", "ID", "|", "Name", "|");
        HashMap<String, String> memberId = projectSunShine.getMemberId();
        for (String key : memberId.keySet()) {
            System.out.println(" " + memberId.get(key) + " : " + key);
        }
    }

    public static void main(String[] args) {
        Main projectManagementProgram = new Main();
        projectManagementProgram.run();

    }


}
