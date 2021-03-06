package test;

import static TeamOneMiniProject.JsonFileHandling.convertJsonToObject;
import TeamOneMiniProject.Member;
import TeamOneMiniProject.Workpackage;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

public class TestFreja {
	
	public static Member retrieveMember(Member[] members, String id) {
		for(int i = 0; i < members.length; i++) {
			if(members[i].getId().equals(id)) {
				return members[i];
			}
		}
		return null;
	}
	
	public static void printHoursHash(Member foundMember){
		double totHours = 0;
   		if(foundMember != null) {
   			HashMap<String, Double> work = foundMember.getWork();
   			System.out.println(foundMember.getFullName()+"'s worked hours:");
   			for(Map.Entry<String, Double> week : work.entrySet()) {
  				System.out.println(week.getKey()+": "+week.getValue());
    			totHours += week.getValue();
   			}
   			System.out.println("Total hours worked: "+totHours);
   		} else {
   			System.out.println("A member with input ID was not found");
   		}
		
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
	
    public static void main(String[] args){
        Member[] members = convertJsonToObject("C:\\Users\\freja\\mini-project\\project-group-1\\src\\\\JsonFiles\\Members.json", Member[].class);
        Workpackage[] workpackages = convertJsonToObject("C:\\Users\\freja\\mini-project\\project-group-1\\src\\\\JsonFiles\\WorkPackages.json", Workpackage[].class);
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.println("Enter member ID: "); // Getting id input
    	String id = scanner.nextLine();
        
        
        //////////////////////////  HOURS WORKED   /////////////////////////////////////////////////
    	
    	
    	
    	// ALTERNATIVE BRONZE
   		/*Member foundMember = retrieveMember(members, id);
   		printHoursHash(foundMember);
        */
   		
   		
   		
   		// ALTERNATIVE MABYE GOLD
   		/*Member foundMember2 = retrieveMember(members, id);
   		if (foundMember2 != null) {
   			//Do something with FOUNDMEMBER2.GETWORK() to print a table??... EX printHourTable(foundMember.getWork())
   			System.out.println("MERRY XMAS");
   		} else {
   			System.out.println("A member with input ID was not found");
   		}
   		*/
   		
   		
   		
   		
   		//////////////////////////////  WORKPACKAGES WORKED    /////////////////////////////////////////////////////
   		
   		// ALTERNATIVE BRONZE
   		/*Member foundMember3 = retrieveMember(members, id);
   		printPackagesWorked(workpackages, foundMember3, id);
   		*/
   		
   		
   		// ALTERNATIVE MABYE GOLD
        /*Member foundMember4 = retrieveMember(members, id);
        ArrayList<String> packagesWorked = packagesWorkedGold(workpackages, foundMember4, id);
   		if(!(packagesWorked.isEmpty())) {
   			// Do something with list packgesWorked to print a table??
   			System.out.println("MERRY XMAS");
   		}
   		
   		*/
        scanner.close();
    }
}
