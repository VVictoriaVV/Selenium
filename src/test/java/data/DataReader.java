package data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.json.Json;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import static org.apache.commons.io.FileUtils.readFileToString;

public class DataReader {


    public  List<HashMap<String, String>> getJsonDataToMap() throws IOException {
        //read json to string
        String json = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "\\src\\test\\java\\data\\PurchaseOrder.json"), StandardCharsets.UTF_8);

        System.out.println(json);


        //String to HashMap Jackson Datbind
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(json, new TypeReference<List<HashMap<String, String>>>() {

        });
        System.out.println(data);
        return data;
    }
}
