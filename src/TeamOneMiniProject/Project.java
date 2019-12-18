package TeamOneMiniProject;
import java.util.HashMap;

public class Project {


    private String projectName;
    private int startWeek;
    private int endWeek;
    private Member[] members;
    private Risk [] risks;
    private Workpackage [] workPackages;

    public Project(String projectName, int startWeek, int endWeek, Member[] members, Risk[] risks, Workpackage[] workPackages) {
        this.projectName = projectName;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.members = members;
        this.risks = risks;
        this.workPackages = workPackages;
    }

    public Project(){

    }

    public String getProjectName() {
        return projectName;
    }

    public int getStartWeek() {
        return startWeek;
    }

    public int getEndWeek() {
        return endWeek;
    }

    public Member[] getMembers() {
        return members;
    }

    public Risk[] getRisks() {
        return risks;
    }

    public Workpackage[] getWorkPackages() {
        return workPackages;
    }

    public int spentHoursOnTheProject(){
        int sum = 0;
        for (int i = 0; i < members.length; i++){
            sum += members[i].getHoursWorked();
        }
        return sum;
    }

    public HashMap<String, Integer> getSingleHours(){
        HashMap<String, Integer> singleHours = new HashMap<String, Integer>();
        for (int i = 0; i < members.length; i++){

            String memberName = members[i].getFullName();
            int memberHours = members[i].getHoursWorked();
            singleHours.put(memberName, memberHours);
        }
        return singleHours;
    }

}






