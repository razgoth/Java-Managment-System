package test;
import static TeamOneMiniProject.JsonFileHandling.convertJsonToObject;

import java.lang.reflect.Array;

import TeamOneMiniProject.Member;
import TeamOneMiniProject.Workpackage;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestFreja {
	
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
		System.out.println(wp);
		scanner.close();
		return output;
	}
	
    public static void main(String[] args){
    	Scanner scanner = new Scanner(System.in);
        Member[] members = convertJsonToObject("C:\\Users\\freja\\mini-project\\project-group-1\\src\\\\JsonFiles\\Members.json", Member[].class);
        Workpackage[] workpackages = convertJsonToObject("C:\\Users\\freja\\mini-project\\project-group-1\\src\\\\JsonFiles\\WorkPackages.json", Workpackage[].class);
         
       
        //System.out.println(hoursWorked(members));
        packagesWorked(workpackages, members);
    
    }
}
