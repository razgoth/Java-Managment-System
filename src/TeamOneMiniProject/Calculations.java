package TeamOneMiniProject;

public class Calculations {

    public static int calculateSumHours (Member[] members){
        int sum = 0;
        for (int i = 0; i < members.length; i++){
            sum += members[i].getHoursWorked();
        }
        return sum;
    }
}
