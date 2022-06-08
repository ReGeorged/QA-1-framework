package data;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileReader;
import java.io.IOException;


public class JsonReader {

    public String returnFromJson(String whatToGet) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("src/main/java/data/configdata.json"));
        JSONObject jsonObject = (JSONObject) obj;

        return (String) jsonObject.get(whatToGet);

    }

}
