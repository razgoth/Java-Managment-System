package TestRamzi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class JsonFileHandling {

    public static ObjectMapper mapper = new ObjectMapper();
    public static InputStream inputStream;
    // this method convert Json file to java object
    public static <Object> Object convertJsonToObject(String JsonFilePath, Class<Object> objectClass) {
        Object result = null;
        try {
            result = mapper.readValue(new File(JsonFilePath), objectClass);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


}
