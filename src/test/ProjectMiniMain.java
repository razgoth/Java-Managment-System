package test;

import TeamOneMiniProject.Risk;

import static TeamOneMiniProject.JsonFileHandling.convertJsonToObject;

public class ProjectMiniMain {
    public static void main(String[] args) {


        Risk[] risks = convertJsonToObject("C:\\Users\\ramzi\\Documents\\Minigit\\project-group-1\\src\\JsonFiles\\Risks.json", Risk[].class);
        System.out.println(risks[1].getImpact());
        System.out.println("------------------------------");
    }

}
/*
        Workpackage[] workPackages = convertJsonToObject("C:\\Users\\heaven\\IdeaProjects\\Team one mini-project\\src\\JsonFiles\\WorkPackages.json", Workpackage[].class);
        System.out.println(workPackages[0].getHoursPerTask().getHours())
        System.out.println("------------------------------");
for (Risk r : risks){
    System.out.println(r);

}


        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("C:\\Users\\heaven\\Desktop\\Code\\josnss\\risks.json"));
            TypeReference<List<Risk>> typeReference = new TypeReference<List<Risk>>() {
            };

           List<Risk> risks1 = mapper.readValue(inputStream, typeReference);
            for (Risk r : risks) {
                System.out.println(r.getImpact());
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
       }


    }



}

*/