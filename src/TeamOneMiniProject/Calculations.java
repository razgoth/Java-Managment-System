package TeamOneMiniProject;

public class Calculations {

    public static double EV(Member[] members, Workpackage[] workpackages, int weeks) {
        double EV = 0;
        int week = weeks - 1;
        if (weeks > 0 && weeks < workpackages.length && (weeks % 2 == 0)) {
            double estimated = workpackages[week].getEstimatedHours() + workpackages[week + 1].getEstimatedHours();
            double worked = workpackages[week].getWorkedHours() + workpackages[week + 1].getWorkedHours();
            int workers = workpackages[week].getId().length + workpackages[week + 1].getId().length;
            int salary = members[1].getCostPerHour();
            EV = (estimated / worked) * workers * salary;
        } else {
            System.out.println("The week you entered is invalid ");
        }
        return EV;
    }

    public static void projectSunshine(Project[] project) {

        double startWeek = project[0].getStartWeek();
        double endWeek = project[0].getEndWeek();
        String activity = project[0].getProjectName();

        System.out.println(startWeek);
        System.out.println(endWeek);
        System.out.println(activity);

    }
}