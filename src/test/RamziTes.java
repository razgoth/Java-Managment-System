package test;

import TeamOneMiniProject.Workpackage;

import static TeamOneMiniProject.JsonFileHandling.convertJsonToObject;

public class RamziTes {


        public static final double SALARY = 500;

        public static double EV(Workpackage[] workpackages, int sprint) {
            double EV = 0;
            int javaSprint = sprint - 1;
            if (sprint > 0 && sprint < workpackages.length) {
                double estimated = workpackages[javaSprint].getEstimatedHours() + workpackages[javaSprint + 1].getEstimatedHours();
                double worked = workpackages[javaSprint].getWorkedHours() + workpackages[javaSprint + 1].getWorkedHours();
                int workers = workpackages[javaSprint].getId().length + workpackages[javaSprint + 1].getId().length;
                EV = (estimated / worked) * SALARY * workers;
            } else {
                System.out.println("The sprint you entered does not exist ");
            }
            return EV;
        }


        public static void main(String[] args) {


            Workpackage[] workPackages = convertJsonToObject("C:\\Users\\ramzi\\Documents\\Minigit\\project-group-1\\src\\JsonFiles\\WorkPackages.json", Workpackage[].class);
            System.out.println("------------------------------");
            System.out.println(EV(workPackages, 1));

        }

}
