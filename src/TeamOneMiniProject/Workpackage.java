package TeamOneMiniProject;

import java.util.Arrays;
import java.util.Objects;

public class Workpackage {
    private String id;
    private String name;
    private double estimatedHours;
    private int[] weeks;
    private HoursPerTask hoursPerTask;

    public Workpackage(String id, String name, double estimatedHours, int[] weeks, HoursPerTask hoursPerTask) {
        this.id = id;
        this.name = name;
        this.estimatedHours = estimatedHours;
        this.weeks = weeks;
        this.hoursPerTask = hoursPerTask;
    }

    public Workpackage() {

    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getEstimatedHours() {
        return estimatedHours;
    }

    public void setEstimatedHours(double estimatedHours) {
        this.estimatedHours = estimatedHours;
    }

    public int[] getWeeks() {
        return weeks;
    }

    public void setWeeks(int[] weeks) {
        this.weeks = weeks;
    }

    public HoursPerTask getHoursPerTask() {
        return hoursPerTask;
    }

    public void setHoursPerTask(HoursPerTask hoursPerTask) {
        this.hoursPerTask = hoursPerTask;
    }

}
