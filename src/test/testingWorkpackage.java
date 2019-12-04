package test;

import TeamOneMiniProject.Workpackage;

import java.util.List;

import static TeamOneMiniProject.JsonFileHandling.convertJsonToObject;

public class testingWorkpackage {
    public static void main(String[] args) {

        List<Workpackage> workpackagesList = convertJsonToObject("C:\\Users\\heaven\\IdeaProjects\\Team one mini-project\\src\\JsonFiles\\WorkPackages.json", List.class);
        System.out.println(workpackagesList.get(1).getID());

        System.out.println("------------------------------");

    }
}
