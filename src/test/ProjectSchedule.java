package test;

import TeamOneMiniProject.Project;

import static TeamOneMiniProject.JsonFileHandling.convertJsonToObject;

public class ProjectSchedule {


        public static void projectSunshine(Project [] project) {

          double startWeek = project[0].getStartWeek();
          double endWeek = project[0].getEndWeek();
          String activity = project[0].getProjectName();

        System.out.println(startWeek);
        System.out.println(endWeek);
        System.out.println(activity);
    }

    public static void main(String[] args) {

        Project[] project = convertJsonToObject("C:\\Users\\ramzi\\Documents\\Minigit\\project-group-1\\src\\JsonFiles\\ProjectSunShine.json", Project[].class);
        System.out.println("------------------------------");
        projectSunshine(project);
    }
}
