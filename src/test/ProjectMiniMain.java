package test;

import TeamOneMiniProject.Risks;
import TeamOneMiniProject.Workpackage;

import static TeamOneMiniProject.JsonFileHandling.convertJsonToObject;

public class ProjectMiniMain {
    public static void main(String[] args) {


        Risks[] risks = convertJsonToObject("C:\\Users\\heaven\\IdeaProjects\\Team one mini-project\\src\\JsonFiles\\Risks.json", Risks[].class);
        System.out.println(risks[1].getImpact());
        System.out.println("------------------------------");


        Workpackage[] workPackages = convertJsonToObject("C:\\Users\\heaven\\IdeaProjects\\Team one mini-project\\src\\JsonFiles\\WorkPackages.json", Workpackage[].class);
        System.out.println(workPackages[0].getHoursPerTask().getHours());
        System.out.println("------------------------------");
for (Risks r : risks){
    System.out.println(r);

}


//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            InputStream inputStream = new FileInputStream(new File("C:\\Users\\heaven\\Desktop\\Code\\josnss\\risks.json"));
//            TypeReference<List<Risks>> typeReference = new TypeReference<List<Risks>>() {
//            };
//
//            List<Risks> risks1 = mapper.readValue(inputStream, typeReference);
//            for (Risks r : risks) {
//                System.out.println(r.getImpact());
//            }
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }

}
