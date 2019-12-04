package test;

import TeamOneMiniProject.Risks;
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
                inputStream = new FileInputStream(new File("C:\\Users\\heaven\\Desktop\\Code\\josnss\\risks.json"));
                TypeReference<List<Risks>> typeReference = new TypeReference<List<Risks>>() {
                };

                List<Risks> risks = mapper.readValue(inputStream, typeReference);
                for (Risks r : risks) {
                    System.out.println(r.getImpact());
                }

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
