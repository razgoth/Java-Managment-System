package test;

import TeamOneMiniProject.Member;
import TeamOneMiniProject.Workpackage;

import static TeamOneMiniProject.JsonFileHandling.convertJsonToObject;

public class RamziTes {

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


    public static void main(String[] args) {

      //  Project projects = convertJsonToObject("C:\\Users\\ramzi\\Documents\\Minigit\\project-group-1\\src\\JsonFiles\\WorkPackages.json", Project.class);

        Workpackage[] workPackages = convertJsonToObject("C:\\Users\\ramzi\\Documents\\Minigit\\project-group-1\\src\\JsonFiles\\WorkPackages.json", Workpackage[].class);
        Member[] members = convertJsonToObject("C:\\Users\\ramzi\\Documents\\Minigit\\project-group-1\\src\\JsonFiles\\Members.json", Member[].class);
        System.out.println("------------------------------");
        System.out.println(EV(members, workPackages,2));
      //  EV(projects.getStartWeek()=;
    }
}

