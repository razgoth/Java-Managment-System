package test;


import TeamOneMiniProject.Member;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.List;

public class testingWithOutMethod {
    public static void main(String[] args) {


        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream;

        {
            try {
                inputStream = new FileInputStream(new File("/Users/Johann/IdeaProjects/project-group-1/src/JsonFiles/WorkPackages.json"));
                TypeReference<List<Member>> typeReference = new TypeReference<List<Member>>() {
                };

                List<Member> member = mapper.readValue(inputStream, typeReference);
                for (Member r : member) {
                    System.out.println(r);
                }
                System.out.println(member.get(0).getWorkValue("week2"));

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



}
