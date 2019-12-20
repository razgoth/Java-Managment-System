package TeamOneMiniProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Calculations {


	public static Member retrieveMember(Member[] members, String id) {
		for(int i = 0; i < members.length; i++) {
			if(members[i].getId().equals(id)) {
				return members[i];
			}
		}
		return null;
	}

	public static void printPackagesWorked(Workpackage[] workpackages, Member foundMember3, String id) {

		String output = "";
		String wp = "";
		String name = "";

		// Checks if id exists in members and catches name.
		if (foundMember3 != null) {
			name = foundMember3.getFullName();
		}


		//Checks if id exists in workpackages and catches workpackages participated in
		for(int i = 0; i < workpackages.length; i++) {

			// Iterates Id-array within workpackage-array
			for(int j = 0; j < workpackages[i].getId().length; j++) {
				if(workpackages[i].getIdValue(j).equals(id)) {
					wp += workpackages[i].getName() + "\n";
				}
			}
		}

		// Checks if data was found and output found data.
		if(name.equals("") && wp.isEmpty()) {
			output = "ID "+id+" does not exist in the system.\n";
		} else if(!(name.equals("")) && wp.isEmpty()){
			output = name+" has not participated in any workpackages\n";
		} else if(!(wp.isEmpty()) && name.equals("")){
			output = "No member with ID "+id+" could be found. ID was found in workpackages: \n";
			output += wp;
		} else {
			output = "Workpackages "+name+" participated in: \n";
			output += wp;
		}


		System.out.println(output);
	}

	public static ArrayList<String> packagesWorkedGold(Workpackage[] workpackages, Member foundMember3, String id) {
		ArrayList<String> wp = new ArrayList<String>();
		String name = "";

		// Checks if id exists in members and catches name.
		if (foundMember3 != null) {
			name = foundMember3.getFullName();
		}


		//Checks if id exists in workpackages and catches workpackages participated in
		for(int i = 0; i < workpackages.length; i++) {

			// Iterates Id-array within workpackage-array
			for(int j = 0; j < workpackages[i].getId().length; j++) {
				if(workpackages[i].getIdValue(j).equals(id)) {
					wp.add(workpackages[i].getName());
				}
			}
		}


		// Checks if data was found and output found data.
		if(name.equals("") && wp.isEmpty()) {
			System.out.println("ID "+id+" does not exist in the system");
		} else if(!(name.equals("")) && wp.isEmpty()){
			System.out.println(name+" has not participated in any workpackages");
		} else if(!(wp.isEmpty()) && name.equals("")){
			System.out.println("No member with ID "+id+" could be found.The ID was found in workpackages:");
		}

		return wp;
	}


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

    // this method gets an array of risk and return a HashMap of Description and risk
    public static HashMap<String, Double> riskMatrix(Risk[] risks) {
        HashMap<String, Double> riskMatrices = new HashMap<>();
        for (int i = 0; i < risks.length; i++) {
            riskMatrices.put(risks[i].getDescription(), risks[i].getRisk());
        }
        return riskMatrices;
    }
    // this is ramzi method for EV
    public static double EV(Member[] members, Workpackage[] workpackages, int weeks) {
        double EV = 0;
        int week = weeks - 1;
        if (weeks > 0 && weeks < workpackages.length && (weeks % 2 == 0)) {
            double estimated = workpackages[week].getEstimatedHours() + workpackages[week + 1].getEstimatedHours();
            double worked = workpackages[week].getWorkedHours() + workpackages[week + 1].getWorkedHours();
            int workers = workpackages[week].getId().length + workpackages[week + 1].getId().length;
            double salary = members[1].getCostPerHour();
            EV = (estimated / worked) * workers * salary;
        } else {
            System.out.println("The week you entered is invalid ");
        }
        return EV;
    }


    public static double CV(Member[] members, Workpackage[] workPackages, int week) {
        int weekIndex = week - 1;
        double cv = 0;
        if (weekIndex >= workPackages.length || weekIndex == 0) {
            System.out.println("You have entered invalid week number. Please enter a valid week number");
        }else if (weekIndex % 2 == 0){
            System.out.println("You have entered invalid week number. The Cost variance can only be calculated in the end of each sprint i.e: week 2, 4, 6, ect.");
        }
        else {
            double AC = (workPackages[weekIndex].getWorkedHours()+ workPackages[weekIndex - 1].getWorkedHours())* members[0].getCostPerHour();
            cv = (EV(members, workPackages, week) - AC);
        }
        return cv;
    }

    public static double SV(Member[] members,Workpackage[] workPackages, int week) {

        int weekIndex = week - 1;
        double SV = 0;
        if (weekIndex >= workPackages.length || weekIndex == 0) {
            System.out.println("You have entered invalid week number. Please enter a valid week number");
        }else if (weekIndex % 2 == 0) {
            System.out.println("You have entered invalid week number. The Schedule variance can only be calculated in the end of each sprint i.e: week 2, 4, 6, ect.");
        }else {
            double PV = workPackages[weekIndex].getEstimatedHours() + workPackages[weekIndex - 1].getEstimatedHours();
            SV = (EV(members, workPackages, week) - ( PV * members[0].getCostPerHour()));
        }
        return SV;
    }

    public static void projectSunshine(Project[] project) {

        double startWeek = project[0].getStartWeek();
        double endWeek = project[0].getEndWeek();
        String activity = project[0].getProjectName();

        System.out.println(startWeek);
        System.out.println(endWeek);
        System.out.println(activity);

    }
}