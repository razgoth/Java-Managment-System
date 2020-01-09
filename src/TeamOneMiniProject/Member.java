package TeamOneMiniProject;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Member {
    private String id;
    private String fullName;
    private double costPerHour;
    private LinkedHashMap<String, Double> work;

    public Member(){
        work = new LinkedHashMap<String, Double>();
    }

    public Member(String id, String fullName, double costPerHour, LinkedHashMap<String, Double> work) {
        this.id = id;
        this.fullName = fullName;
        this.costPerHour = costPerHour;
        this.work = work;
    }

    //getters
    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public double getCostPerHour() {
        return costPerHour;
    }

    public LinkedHashMap<String, Double> getWork() {
        return work;
    }



    public Double getHoursWorked() {
        Double hoursWorked = 0.0;
        for (Double value : work.values()){
            hoursWorked += value;
        }
        return hoursWorked;
    }


}
