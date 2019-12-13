package TeamOneMiniProject;

public class Calculations {

    public static Double calculateSumHours (Member[] members){
        Double  sum = 0.0;
        for (int i = 0; i < members.length; i++){
            sum += members[i].getHoursWorked();
        }
        return sum;
    }
}
