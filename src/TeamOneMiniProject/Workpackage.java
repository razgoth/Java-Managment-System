package TeamOneMiniProject;

import java.util.Arrays;
import java.util.Objects;

public class Workpackage {
    private String id;
    private String name;
    private double estimatedHours;
    private int[] weeks;




    public Workpackage(String id, String name, double estimatedHours, int[] weeks) {
        this.id = id;
        this.name = name;
        this.estimatedHours = estimatedHours;
        this.weeks = weeks;

    }

    public Workpackage() {

    }

    public String getID() {
        return id;
    }



    public String getName() {
        return name;
    }



    public double getEstimatedHours() {
        return estimatedHours;
    }



    public int[] getWeeks() {
        return weeks;
    }







}
