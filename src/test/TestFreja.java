package test;
import static TeamOneMiniProject.JsonFileHandling.convertJsonToObject;

import java.lang.reflect.Array;

import TeamOneMiniProject.Member;
import TeamOneMiniProject.Workpackage;
import java.util.HashMap;
import java.util.Map;

public class TestFreja {
     //C:\\Users\\ramzi\\Documents\\Minigit\\project-group-1\\src\\
	
	public static double hoursWorked(Member[] members, String id) {
		double hours = 0;
		HashMap<String, Integer> work = new HashMap<String, Integer>();
		
		for(int i = 0; i < members.length; i++) {
			if (members[i].getId().equals(id)) {
				//Member member =(Member)Array.get(members, i);
				work = (HashMap<String, Integer>) members[i].getWork();
			}
		}
		
		for(Map.Entry<String, Integer> mem : work.entrySet()) {
			hours += (double) mem.getValue();
		}
		
		return hours;
		
	}

    public static void main(String[] args){
         Member[] members = convertJsonToObject("C:\\Users\\freja\\mini-project\\project-group-1\\src\\\\JsonFiles\\Members.json", Member[].class);
         Workpackage[] workpackages = convertJsonToObject("C:\\Users\\freja\\mini-project\\project-group-1\\src\\\\JsonFiles\\WorkPackages.json", Workpackage[].class);
         
         //System.out.println(members[0]);
         
         System.out.println(hoursWorked(members, "456"));
         
    
    }
}
