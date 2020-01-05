package test;
import TeamOneMiniProject.Member;
import TeamOneMiniProject.Calculations;

import java.util.HashMap;

import static TeamOneMiniProject.JsonFileHandling.convertJsonToObject;

public class TestJohann {

    public static void main (String [] args) {

        Member[] members = convertJsonToObject("/Users/Johann/IdeaProjects/project-group-1/src/JsonFiles/Members.json", Member[].class);

       // System.out.println(Calculations.getHoursPerMember(members));
        System.out.println();

      //  HashMap<String,Double> hoursPerMember = Calculations.getHoursPerMember(members);
      //  for (String name : hoursPerMember.keySet()){
     //       System.out.println(name + ": " + hoursPerMember.get(name));
     //   }



        System.out.println();
       // System.out.println("Total: " + Calculations.getHoursOnProject(members));

    }

}
