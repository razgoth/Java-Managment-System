package TeamOneMiniProject;

public class HoursPerTask {
    private int week;
    private double hours;

    public HoursPerTask(int week, double hours) {
        this.week = week;
        this.hours = hours;
    }

    public HoursPerTask() {

    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

}
