package TeamOneMiniProject;

import java.util.Arrays;

public class Project {


    private String projectName;
    private int startWeek;
    private int endWeek;
    private int[] milestone;

    public Project(String projectName, int startWeek, int endWeek, int[] milestone) {
        this.projectName = projectName;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.milestone = milestone;
    }

    public Project(){

    }

    public String getProjectName() {
        return projectName;
    }

    public int getStartWeek() {
        return startWeek;
    }

    public int getEndWeek() {
        return endWeek;
    }

    public int[] getMilestone() {
        return milestone;
    }

    public int getMilestoneValue(int i){
        return milestone[i];
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                ", startWeek=" + startWeek +
                ", endWeek=" + endWeek +
                ", milestone=" + Arrays.toString(milestone) +
                '}';
    }
}






