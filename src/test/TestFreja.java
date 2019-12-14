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

	public static HashMap<String, Double> hoursWorked(Member member) {
		double totHours = 0;
        
        for(Map.Entry<String, Integer> week : member.getWork().entrySet()) {
    			totHours += (double) week.getValue();
        }
        member.getWork().put("total", totHours);
		
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
        
        
       //System.out.println(hoursWorked(members));
       //System.out.println(packagesWorked(workpackages, members));
    
    }
}
