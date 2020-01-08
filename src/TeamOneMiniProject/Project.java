package TeamOneMiniProject;

import java.util.HashMap;

public class Project {


    private String projectName;
    private int startWeek;
    private int endWeek;
    private Member[] members;
    private Risk[] risks;
    private Workpackage[] workPackages;

    public Project() {
    }

    public Project(String projectName, int startWeek, int endWeek, Member[] members, Risk[] risks, Workpackage[] workPackages) {
        this.projectName = projectName;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.members = members;
        this.risks = risks;
        this.workPackages = workPackages;
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

    public double getEarnedValue(int weeks) {
        return Calculations.EV(members, workPackages, weeks);
    }

    public double getScheduleVariance(int weeks) {
        return Calculations.SV(members, workPackages, weeks);
    }

    public double getCostVariance(int weeks) {
        return Calculations.CV(getMembers(), getWorkPackages(), weeks);
    }

    public HashMap<String, Double> getRiskMatrix() {
        return Calculations.riskMatrix(risks);
    }

    public String getActivitySchedule(int weeks) {
        return Calculations.ActivitySchedule(workPackages, weeks);
    }

    public HashMap<String, Double> getTimeOfMembers() {
        return Calculations.getHoursPerMember(members);
    }

    public Double getTotalHours() {
        return Calculations.getTotalHoursOnProject(members);
    }

    public Member getTimeByMember(String id) {
        return Calculations.retrieveMember(members, id);
    }

    public String getMemberParticipation(String id) {
        return Calculations.printPackagesWorked(workPackages, members, id);
    }

    public HashMap<String, String> getMemberId() {

        HashMap<String, String> memberId = new HashMap<String, String>();
        for (int i = 0; i < members.length; i++) {
            memberId.put(members[i].getFullName(), members[i].getId());
        }
        return memberId;
    }
}






