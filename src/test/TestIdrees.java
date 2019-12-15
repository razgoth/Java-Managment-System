package test;
import TeamOneMiniProject.Risk;
import TeamOneMiniProject.Workpackage;

import static TeamOneMiniProject.Calculations.*;
import static TeamOneMiniProject.JsonFileHandling.convertJsonToObject;
public class TestIdrees {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String BOLD_TEXT = "\033[0;1m";

    public static void main(String[] args) {
        System.out.println("------------------------------------------------");
        Risk[] risks = convertJsonToObject("C:\\Users\\heaven\\IdeaProjects\\project-group-1\\src\\JsonFiles\\Risks.json", Risk[].class);
        RiskMatrices(risks);
        System.out.println("------------------------------------------------");
        Workpackage[] workPackages = convertJsonToObject("C:\\Users\\heaven\\IdeaProjects\\project-group-1\\src\\JsonFiles\\WorkPackages.json", Workpackage[].class);
        SV( workPackages, 2);
        System.out.println("------------------------------------------------");
        AllSV(workPackages);
        System.out.println("------------------------------------------------");

        CV( workPackages, 4);
        System.out.println("------------------------------------------------");
        AllCV(workPackages);



    }




}

