package TeamOneMiniProject;

import java.util.HashMap;


public class Calculations {

    public static Double getHoursOnProject (Member[] members){
        Double  sum = 0.0;
        for (int i = 0; i < members.length; i++){
            sum += members[i].getHoursWorked();
        }
        return sum;
    }

    public static HashMap<String, Double> getHoursPerMember (Member [] members){
        HashMap<String, Double> hoursPerMember = new HashMap<>();

        for (int i = 0; i < members.length; i++){
            String name = members[i].getFullName();
            Double hours = members[i].getHoursWorked();
            hoursPerMember.put(name, hours);
        }
        return hoursPerMember;

    }
}
