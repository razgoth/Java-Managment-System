package TeamOneMiniProject;

import static test.TestIdrees.*;

public class Calculations {
    public static final double SALARY_PER_HOUR = 500.00;
    //incomplete method that should return EV
    public static double EV(Workpackage[] workPackages, int weeks){
        return 10000;
    }

    // this method prints out All risk matrices
    public static void RiskMatrices(Risk[] risks) {
        for (int i = 0; i < risks.length; i++) {
            System.out.println(BOLD_TEXT + BLUE + "Risk Description: " + RESET +
                    RED + risks[i].getDescription() + RESET +
                    "\nRisk Matrix: " + RED + risks[i].getRisk() + RESET);
        }
    }
    //this method calculates SV in intervals of two weeks
    public static void SV(Workpackage[] workPackages, int week) {
        int weekIndex = week - 1;
        if (weekIndex >= workPackages.length || weekIndex == 0) {
            System.out.println("You have entered invalid week number. Please enter a valid week number");
        }else if (weekIndex % 2 == 0) {
            System.out.println("You have entered invalid week number. The Schedule variance can only be calculated in the end of each sprint i.e: week 2, 4, 6, ect.");
        }else
        {
            double PV = workPackages[weekIndex].getEstimatedHours() + workPackages[weekIndex - 1].getEstimatedHours();
            double SV = EV(workPackages, weekIndex) - ( PV * SALARY_PER_HOUR);
            System.out.println("Schedule variance in the end of week "+ RED + week + RESET + " equals: "+ RED + SV + " SEK"+ RESET);
        }
    }
    // this method prints out all SV
    public static void AllSV(Workpackage[] workPackages, Member[] members) {
        double TotalSV = 0;
        for(int i = 0 ; i<workPackages.length; i+=2){
            double PV = workPackages[i].getEstimatedHours()+workPackages[i+1].getEstimatedHours();
            double SV =  EV(workPackages, 4) - ( PV * members[i].getCostPerHour());
            TotalSV +=SV;
            System.out.println("Schedule variance in the end of "+ RED + "week "+ (i+2) + RESET + " equals: "+ RED + SV + " SEK"+ RESET);
        }
        System.out.println("Schedule variance in the end of the Project equals: "+ RED + (TotalSV)+ " SEK"+ RESET);
    }
    //==============================================================================================================================================================================
    // this method calculates CV in intervals of two weeks
    public static void CV(Workpackage[] workPackages, int week) {
        int weekIndex = week - 1;
        if (weekIndex >= workPackages.length || weekIndex == 0) {
            System.out.println("You have entered invalid week number. The Cost Variance can only be calculated in intervals of two weeks. please enter a valid week number");
        } else if (weekIndex % 2 == 0){
            System.out.println("You have entered invalid week number. The Cost variance can only be calculated in the end of each sprint i.e: week 2, 4, 6, ect.");
        }else {
            double AC = (workPackages[weekIndex].getWorkedHours()+ workPackages[weekIndex - 1].getWorkedHours())* SALARY_PER_HOUR;
            double cv = (EV(workPackages,weekIndex) - AC);
            System.out.println("Cost variance in the end of week "+ RED + week + RESET + " equals: "+ RED + cv + " SEK"+ RESET);
        }
    }

    public static void AllCV(Workpackage[] workPackages, Member[] members) {
        double TotalCV = 0;
        for(int i = 0 ; i<workPackages.length; i+=2){
            double AC = workPackages[i].getWorkedHours()+workPackages[i+1].getWorkedHours();
            double CV =  EV(workPackages, 4) - ( AC * members[i].getCostPerHour());
            TotalCV +=CV;
            System.out.println("Schedule variance in the end of "+ RED + "week "+ (i+2) + RESET + " equals: "+ RED + CV + " SEK"+ RESET);
        }
        System.out.println("Schedule variance in the end of the Project equals: "+ RED + (TotalCV)+ " SEK"+ RESET);
    }





}
