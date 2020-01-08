package TeamOneMiniProject;

public class Workpackage {
    private String name;
    private String[] id;
    private double estimatedHours;
    private double workedHours;
    private int[] week;


    public Workpackage() {
    }


    public double getWorkedHours() {
        return workedHours;
    }


    public String getName() {
        return name;
    }

    public String[] getId() {
        return id;
    }

    public double getEstimatedHours() {
        return estimatedHours;
    }

    public int[] getWeek() {
        return week;
    }

    public int getWeekValue(int i) {
        return week[i];
    }

    public String getIdValue(int i) {
        return id[i];
    }


}
