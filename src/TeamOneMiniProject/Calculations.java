package TeamOneMiniProject;

import java.util.HashMap;


public class Calculations {


    public static Member retrieveMember(Member[] members, String id) {
        for (int i = 0; i < members.length; i++) {
            if (members[i].getId().equals(id)) {
                return members[i];
            }
        }
        return null;
    }

    public static String printPackagesWorked(Workpackage[] workpackages, Member[] members, String id) {

        String output = "";
        String wp = "";
        String name = "";

        Member foundMember3 = retrieveMember(members, id);

        // Checks if id exists in members and catches name.
        if (foundMember3 != null) {
            name = foundMember3.getFullName();
        }


        //Checks if id exists in workpackages and catches workpackages participated in
        for (int i = 0; i < workpackages.length; i++) {

            // Iterates Id-array within workpackage-array
            for (int j = 0; j < workpackages[i].getId().length; j++) {
                if (workpackages[i].getIdValue(j).equals(id)) {
                    wp += "* " + workpackages[i].getName() + "\n";
                }
            }
        }

        // Checks if data was found and output found data.
        if (name.equals("") && wp.isEmpty()) {
            output = "ID " + id + " does not exist in the system.\n";
        } else if (!(name.equals("")) && wp.isEmpty()) {
            output = name + " has not participated in any workpackages\n";
        } else if (!(wp.isEmpty()) && name.equals("")) {
            output = "No member with ID " + id + " could be found. ID was found in workpackages: \n";
            output += wp;
        } else {
            output = "Workpackages " + name + " participated in: \n";
            output += wp;
        }
        return output;
    }

    // puts the name of a member and how much (s)he worked in a hash map
    public static HashMap<String, Double> getHoursPerMember(Member[] members) {

        HashMap<String, Double> hoursPerMember = new HashMap<>();
        for (int i = 0; i < members.length; i++) {
            String name = members[i].getFullName();
            Double hours = members[i].getHoursWorked();
            hoursPerMember.put(name, hours);
        }
        return hoursPerMember;
    }

    // sums up how many hours were spent on the project in total
    public static Double getTotalHoursOnProject(Member[] members) {
        double sum = 0.0;
        for (int i = 0; i < members.length; i++) {
            Double hours = members[i].getHoursWorked();
            sum += hours;
        }
        return sum;
    }


    // this method gets an array of risk and return a HashMap of Description and risk
    public static HashMap<String, Double> riskMatrix(Risk[] risks) {
        HashMap<String, Double> riskMatrices = new HashMap<>();
        System.out.printf("\n%s %s %12s %s %s %n\n", "|", "Name of Risk", "|", "Risk", "|");

        for (int i = 0; i < risks.length; i++) {

            riskMatrices.put(risks[i].getDescription(), risks[i].getRisk());
        }
        return riskMatrices;
    }

    //  calculate EV
    public static double EV(Member[] members, Workpackage[] workpackages, int weeks) {
        double EV1 = 0;
        double PV = 0;
        int week = weeks - 1;
        int i = 0;
        if (weeks > 0 && weeks < workpackages.length && weeks % 2 != 0) {
            double actualHours = workpackages[week].getWorkedHours() + workpackages[week + 1].getWorkedHours();
            double planedHours = workpackages[week].getEstimatedHours() + workpackages [week + 1].getEstimatedHours();
            double workDoneInPercent = ((planedHours*100)/actualHours);
            PV = planedHours * members[i].getCostPerHour();
            EV1 = ((PV * workDoneInPercent) / 100) ;
        } else {
            System.out.println("The week you entered is invalid ");
        }
        return Math.round(EV1);
    }



    public static String ActivitySchedule(Workpackage[] workpackages, int weeks) {
        int weekName = 0;

        String activityName = workpackages[weeks].getName();
        System.out.printf("%20s ", activityName);

        for (int i = 0; i < workpackages[weeks].getWeek().length; i++) {
            weekName = (workpackages[weeks].getWeekValue(i));

            if (workpackages[weeks].getWeek().length == 1) {
                System.out.printf(" %15d ", weekName);

            } else {
                System.out.printf(" %15d ", weekName);
            }
        }
        String result = "";
        return result;
    }

    public static double CV(Member[] members, Workpackage[] workPackages, int week) {
        int weekIndex = week - 1;
        double cv = 0;
        if (weekIndex >= workPackages.length || weekIndex == 0) {
            System.out.println("You have entered invalid week number. Please enter a valid week number");
        } else if (weekIndex % 2 == 0) {
            System.out.println("You have entered invalid week number. The Cost variance can only be calculated in the end of each sprint i.e: week 2, 4, 6, ect.");
        } else {
            double AC = (workPackages[weekIndex].getWorkedHours() + workPackages[weekIndex - 1].getWorkedHours()) * members[0].getCostPerHour();
            cv = (EV(members, workPackages, weekIndex) - AC);
        }
        return Math.round(cv);
    }

    public static double SV(Member[] members, Workpackage[] workPackages, int week) {

        int weekIndex = week - 1;
        double SV = 0;
        if (weekIndex >= workPackages.length || weekIndex == 0) {
            System.out.println("You have entered invalid week number. Please enter a valid week number");
        } else if (weekIndex % 2 == 0) {
            System.out.println("You have entered invalid week number. The Schedule variance can only be calculated in the end of each sprint i.e: week 2, 4, 6, ect.");
        } else {
            double PV = (workPackages[weekIndex].getEstimatedHours() + workPackages[weekIndex - 1].getEstimatedHours()) * members[0].getCostPerHour();
            SV = (EV(members, workPackages, weekIndex) - (PV));
        }
        return SV;
    }

}