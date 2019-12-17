package test;

import TeamOneMiniProject.Member;
import TeamOneMiniProject.Workpackage;

import static TeamOneMiniProject.JsonFileHandling.convertJsonToObject;

public class RamziTes {

    public static double sprintEV(Member[] members, Workpackage[] workpackages, int weeks) {
        double EV = 0;
        int javaSprint = weeks - 1;
        if (weeks > 0 && weeks < workpackages.length) {
            double estimated = workpackages[javaSprint].getEstimatedHours() + workpackages[javaSprint + 1].getEstimatedHours();
            double worked = workpackages[javaSprint].getWorkedHours() + workpackages[javaSprint + 1].getWorkedHours();
            int workers = workpackages[javaSprint].getId().length + workpackages[javaSprint + 1].getId().length;
            int salary = members[javaSprint].getCostPerHour();
            EV = (estimated / worked) * workers * salary;
        } else {
            System.out.println("The weeks you entered does not exist ");
        }
        return EV;
    }


    public static void main(String[] args) {


        Workpackage[] workPackages = convertJsonToObject("C:\\Users\\ramzi\\Documents\\Minigit\\project-group-1\\src\\JsonFiles\\WorkPackages.json", Workpackage[].class);
        Member[] members = convertJsonToObject("C:\\Users\\ramzi\\Documents\\Minigit\\project-group-1\\src\\JsonFiles\\Members.json", Member[].class);
        System.out.println("------------------------------");
        System.out.println(sprintEV(members, workPackages,1));

    }
}

