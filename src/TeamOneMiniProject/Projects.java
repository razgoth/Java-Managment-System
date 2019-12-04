package TeamOneMiniProject;

public class Projects {


    private String projectName;
    private int startWeek;
    private int endWeek;
    private Object [] milestone;
    private String id;
    private String name;
    private int estimatedHours;
    private int [] weeks;

    public Projects() {}

    public Projects(String projectName, int startWeek, int endWeek, Object[] milestone, String id, String name, int estimatedHours, int[] weeks) {
        this.projectName = projectName;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.milestone = milestone;
        this.id = id;
        this.name = name;
        this.estimatedHours = estimatedHours;
        this.weeks = weeks;
    }

    public String getFullName() {
        return projectName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getStartWeek() {
        return startWeek;
    }

    public void setStartWeek(int startWeek) {
        this.startWeek = startWeek;
    }

    public int getEndWeek() {
        return endWeek;
    }

    public void setEndWeek(int endWeek) {
        this.endWeek = endWeek;
    }

    public Object[] getMilestone() {
        return milestone;
    }

    public void setMilestone(Object[] milestone) {
        this.milestone = milestone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEstimatedHours() {
        return estimatedHours;
    }

    public void setEstimatedHours(int estimatedHours) {
        this.estimatedHours = estimatedHours;
    }

    public int[] getWeeks() {
        return weeks;
    }

    public void setWeeks(int[] weeks) {
        this.weeks = weeks;
    }
}
