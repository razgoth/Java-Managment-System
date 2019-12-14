package test;

import static TeamOneMiniProject.JsonFileHandling.convertJsonToObject;
import TeamOneMiniProject.Member;
import TeamOneMiniProject.Workpackage;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestFreja {
	
	public static Member retrieveMember(Member[] members, String id) {
		for(int i = 0; i < members.length; i++) {
			if(members[i].getId().equals(id)) {
				return members[i];
			}
		}
		return null;
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
	
    public static void main(String[] args){
        Member[] members = convertJsonToObject("C:\\Users\\freja\\mini-project\\project-group-1\\src\\\\JsonFiles\\Members.json", Member[].class);
        Workpackage[] workpackages = convertJsonToObject("C:\\Users\\freja\\mini-project\\project-group-1\\src\\\\JsonFiles\\WorkPackages.json", Workpackage[].class);
        Scanner scanner = new Scanner(System.in);
		
		
        System.out.println("Enter member ID: "); // Getting id input
		String id = scanner.nextLine();
		
		double totHours = 0;
		Member foundMember = retrieveMember(members, id);
		if(foundMember != null) {
			HashMap<String, Double> work = foundMember.getWork();
			System.out.println(foundMember.getFullName()+"'s worked hours:");
			for(Map.Entry<String, Double> week : work.entrySet()) {
				System.out.println(week.getKey()+": "+week.getValue());
				totHours += week.getValue();
			}
			System.out.println("Total hours worked: "+totHours);
		} else {
			System.out.println("A member with id "+id+" was not found");
		}
        
        
       
		scanner.close();
    }
}
