package TeamOneMiniProject;

public class Projects {


    private String fullName;
    private int startWeek;
    private int endWeek;
    private String milestone;

    public Projects() {}

    public Projects(String fullName, int startWeek, int endWeek, String milestone) {
        super();
        this.fullName = fullName;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.milestone = milestone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getMilestone() {
        return milestone;
    }

    public void setMilestone(String milestone) {
        this.milestone = milestone;
    }



}
