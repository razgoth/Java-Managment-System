/*package test;


import TeamOneMiniProject.Member;
import TeamOneMiniProject.Workpackage;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.sql.SQLOutput;
import java.util.List;

import static TeamOneMiniProject.JsonFileHandling.convertJsonToObject;

public class testingWorkpackgae {
    public static void main(String[] args) {


        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream;

        {
            try {
                inputStream = new FileInputStream(new File("/Users/Johann/IdeaProjects/project-group-1/src/JsonFiles/WorkPackages.json"));
                TypeReference<List<Workpackage>> typeReference = new TypeReference<List<Workpackage>>() {
                };

                List<Workpackage> member = mapper.readValue(inputStream, typeReference);
                for (Workpackage r : member) {
                    System.out.println(r);
                }

                System.out.println(member.get(0).getIdValue(0));


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (JsonParseException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    List<Workpackage> member = convertJsonToObject("/Users/Johann/IdeaProjects/project-group-1/src/JsonFiles/WorkPackages.json", List<Workpackage.class>);



}
*/