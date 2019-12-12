package test;
import TeamOneMiniProject.Member;
import TeamOneMiniProject.Calculations;

import static TeamOneMiniProject.JsonFileHandling.convertJsonToObject;

public class TestJohann {

    public static void main (String [] args) {
        Member[] members = convertJsonToObject("/Users/Johann/IdeaProjects/project-group-1/src/JsonFiles/Members.json", Member[].class);
        for(int i = 0; i < members.length; i ++){
            System.out.println(members[i].getFullName() + ": " + (members[i]).getHoursWorked());
        }
        System.out.println();
        System.out.println("Total: " + Calculations.calculateSumHours(members));

    }

}
