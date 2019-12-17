package test;
import TeamOneMiniProject.Member;
import TeamOneMiniProject.Project;
import TeamOneMiniProject.Risk;
import TeamOneMiniProject.Workpackage;
import org.jfree.ui.RefineryUtilities;
import visualization.BarCharRisk1;
import visualization.BarChartRisk;

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
        Project sunShine = convertJsonToObject("C:\\Users\\heaven\\IdeaProjects\\project-group-1\\src\\JsonFiles\\ProjectSunShine.json", Project.class);
        Member[] members = convertJsonToObject("C:\\Users\\heaven\\IdeaProjects\\project-group-1\\src\\JsonFiles\\Members.json", Member[].class);
        System.out.println("------------------------------------------------");
        Risk[] risks = convertJsonToObject("C:\\Users\\heaven\\IdeaProjects\\project-group-1\\src\\JsonFiles\\Risks.json", Risk[].class);
        RiskMatrices(risks);
        System.out.println("------------------------------------------------");
        Workpackage[] workPackages = convertJsonToObject("C:\\Users\\heaven\\IdeaProjects\\project-group-1\\src\\JsonFiles\\WorkPackages.json", Workpackage[].class);
        SV( workPackages, 2);
        System.out.println("------------------------------------------------");
        System.out.println("check");
        AllSV(workPackages, members);
        System.out.println("------------------------------------------------");

        CV( workPackages, 4);
        System.out.println("------------------------------------------------");
        AllCV(workPackages,members);

        System.out.println("------------------------------------------------");

//        BarChartRisk chart = new BarChartRisk("Risk Matrix",
//                sunShine.getProjectName());
//        chart.pack();
//        RefineryUtilities.centerFrameOnScreen(chart);
//        chart.setVisible(true);



        BarCharRisk1 chart01 = new BarCharRisk1("Risk Matrix",
                "Project Sun Shine");
        chart01.pack( );
        RefineryUtilities.centerFrameOnScreen( chart01 );
        chart01.setVisible( true );


    }


}

