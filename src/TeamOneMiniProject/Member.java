package TeamOneMiniProject;

import java.util.HashMap;

public class Member {
    private String id;
    private String fullName;
    private int costPerHour;
    private HashMap<String, Integer> work;

    public Member(){
        work = new HashMap<String, Integer>();
    }

    //getters
    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getCostPerHour() {
        return costPerHour;
    }

    public HashMap<String, Integer> getWork() {
        return work;
    }

    public Integer getWorkValue(String key){
        return work.get(key);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", costPerHour=" + costPerHour +
                ", work=" + work +
                '}';
    }
}
