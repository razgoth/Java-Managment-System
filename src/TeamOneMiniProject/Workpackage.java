package TeamOneMiniProject;

public class Workpackage {
    private String name;
    private String[] id;
    private double estimatedHours;
    private double workedHours;
    private int [] week;



    public Workpackage(String name, String[] id, double estimatedHours, int [] week, double workedHours) {
        this.name = name;
        this.id = id;
        this.estimatedHours = estimatedHours;
        this.workedHours = workedHours;
        this.week = week;
    }

    public double getWorkedHours() {
        return workedHours;
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

    public int[] getWeek() {
        return week;
    }

    public int getWeekValue(int i) {
        return week[i];
    }

    public String getIdValue(int i){
        return id[i];
    }


}
