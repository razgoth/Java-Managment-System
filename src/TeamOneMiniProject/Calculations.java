package TeamOneMiniProject;

import java.util.HashMap;


public class Calculations {

    public static Double getHoursOnProject (Member[] members){
        Double  sum = 0.0;
        for (int i = 0; i < members.length; i++){
            sum += members[i].getHoursWorked();
        }
        return sum;
    }

    public static HashMap<String, Double> getHoursPerMember (Member [] members){
        HashMap<String, Double> hoursPerMember = new HashMap<>();

        for (int i = 0; i < members.length; i++){
            String name = members[i].getFullName();
            Double hours = members[i].getHoursWorked();
            hoursPerMember.put(name, hours);
        }
        return hoursPerMember;

    }

    // this method gets an array of risk and return a HashMap of Description and risk
    public static HashMap<String, Double> riskMatrix(Risk[] risks) {
        HashMap<String, Double> riskMatrices = new HashMap<>();
        for (int i = 0; i < risks.length; i++) {
            riskMatrices.put(risks[i].getDescription(), risks[i].getRisk());
        }
        return riskMatrices;
    }
    // this is ramzi method for EV
    public static double EV(Member[] members, Workpackage[] workpackages, int weeks) {
        double EV = 0;
        int week = weeks - 1;
        if (weeks > 0 && weeks < workpackages.length&& (weeks%2==0)) {
            double estimated = workpackages[week].getEstimatedHours() + workpackages[week + 1].getEstimatedHours();
            double worked = workpackages[week].getWorkedHours() + workpackages[week + 1].getWorkedHours();
            int workers = workpackages[week].getId().length + workpackages[week + 1].getId().length;
            double salary = members[1].getCostPerHour();
            EV = (estimated / worked) * workers * salary;
        } else {
            System.out.println("The week you entered is invalid ");
        }
        return EV;
    }


    public static double CV(Member[] members, Workpackage[] workPackages, int week) {
        int weekIndex = week - 1;
        double cv = 0;
        if (weekIndex >= workPackages.length || weekIndex == 0) {
            System.out.println("You have entered invalid week number. Please enter a valid week number");
        }else if (weekIndex % 2 == 0){
            System.out.println("You have entered invalid week number. The Cost variance can only be calculated in the end of each sprint i.e: week 2, 4, 6, ect.");
        }
        else {
            double AC = (workPackages[weekIndex].getWorkedHours()+ workPackages[weekIndex - 1].getWorkedHours())* members[0].getCostPerHour();
            cv = (EV(members, workPackages, week) - AC);
        }
        return cv;
    }

    public static double SV(Member[] members,Workpackage[] workPackages, int week) {

        int weekIndex = week - 1;
        double SV = 0;
        if (weekIndex >= workPackages.length || weekIndex == 0) {
            System.out.println("You have entered invalid week number. Please enter a valid week number");
        }else if (weekIndex % 2 == 0) {
            System.out.println("You have entered invalid week number. The Schedule variance can only be calculated in the end of each sprint i.e: week 2, 4, 6, ect.");
        }else {
            double PV = workPackages[weekIndex].getEstimatedHours() + workPackages[weekIndex - 1].getEstimatedHours();
            SV = (EV(members, workPackages, week) - ( PV * members[0].getCostPerHour()));
        }
        return SV;
    }
}
