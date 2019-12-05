package TeamOneMiniProject;

public class Workpackage {
    private String name;
    private String[] id;
    private double estimatedHours;
    private double workedHours;
    private int week;



    public Workpackage(String name, String[] id, double estimatedHours, int week, double workedHours) {
        this.name = name;
        this.id = id;
        this.estimatedHours = estimatedHours;
        this.workedHours = workedHours;
        this.week = week;
    }

    public Workpackage() {

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

    public double getWorkedHours() {
        return workedHours;
    }

    public int getWeek() {
        return week;
    }
}
