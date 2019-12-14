package TeamOneMiniProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculations {
	
	public static Member retrieveMember(Member[] members, String id) {
		for(int i = 0; i < members.length; i++) {
			if(members[i].getId().equals(id)) {
				return members[i];
			}
		}
		return null;
	}
	
	// Method for finding hours worked per week with member ID.
	public static String hoursWorked(Member[] members) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter member ID: "); // Getting id input
		String id = scanner.nextLine();
		
		HashMap<String, Integer> work = new HashMap<String, Integer>(); //To catch work-hashmap if id matches member
		String output = "";
		double totHours = 0;
        
		//Checking if member id exists. Catches work-hashmap and name of member
        for (int i = 0; i < members.length; i++) {
        	if(members[i].getId().contentEquals(id)){
        		output += members[i].getFullName()+"'s hours worked:\n";
        		work = (HashMap<String, Integer>) members[i].getWork();
        	}
        }
        
        // IF id not found, prints message, else calculates worked hours.
        if(work.isEmpty()) {
        	output = "A member with ID "+id+" does not exist in the system.";
        } else {
        	for(Map.Entry<String, Integer> week : work.entrySet()) {
    			output += week.getKey()+": "+week.getValue()+" h\n";
    			totHours += (double) week.getValue();
    		}
        	output += "Total hours worked: "+totHours+" h";
        }
		
		
		scanner.close();
		return output;
	}
	
	// Method for finding workpackages worked on with member ID.
	public static String packagesWorked(Workpackage[] workpackages, Member[] members) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter member ID: "); // Getting id input
		String id = scanner.nextLine();
		
		String output = "";
		String wp = "";
		String name = "";
		
		// Checks if id exists in members and catches name.
		for(int i = 0; i < members.length; i++) {
			if(members[i].getId().equals(id)) {
				name = members[i].getFullName();
			}
		}
		
		//Checks if id exists in workpackages and catches workapckages participated in
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
		
		
		scanner.close();
		return output;
	}
	
	
}
