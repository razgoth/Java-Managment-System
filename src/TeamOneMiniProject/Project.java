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


    //--------------------------------------------------------------------------------------------\\
    //                              New Methods Added By Oscar                                    \\
    //--------------------------------------------------------------------------------------------\\

    //This method will retrieve a member from the member array (Member[] members)
    /*public Member getMember(Member[] members) {
        for(int i = 0; i < members.length; i++) {
            Member[] members += members[i];
        }

        return members;
    }
    */

    public double getEarnedValue(){
        Member[] members = getMembers();
        Workpackage[] workpackages = getWorkPackages();
        int weeks = getEndWeek();

        double EV = Calculations.EV(members, workpackages, weeks);
        return EV;

    }

    public double getScheduleVariance(){
        Member[] members = getMembers();
        Workpackage[] workpackages = getWorkPackages();
        int weeks = getEndWeek();

        double SV = Calculations.SV(members, workpackages, weeks);
        return SV;

    }

    public double getCostVariance(){
        Member[] members = getMembers();
        Workpackage[] workpackages = getWorkPackages();
        int weeks = getEndWeek();

        double CV = Calculations.CV(members, workpackages, weeks);
        return CV;

    }

    public HashMap<String, Double> getRiskMatrix(){
        Risk[] risks = getRisks();

        HashMap<String, Double> riskMatrix = Calculations.riskMatrix(risks);
        return riskMatrix;

    }

    public String getProjectSchedule() {

        String projectSchedule = Calculations.projectSunshine();
        return projectSchedule;

    }

   /* public String timeOfMembers(){

        String timeOfMembers = Calculations.timeOfMembers();
        return timeOfMembers;
    }
*/
    public  Member getTimeByMember(String id){
        Member[] members = getMembers();

        Member timeByMember= Calculations.retrieveMember(members, id);
        return timeByMember;
    }

    /*public  String getMemberParticipation(String id){
        Member[] members = getMembers();
        Workpackage[] workpackages = getWorkPackages();

        String memberParticipation = Calculations.printPackagesWorked(workpackages, members, id);
        return memberParticipation;
    }
    */
}






