import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.io.FileReader;
import java.io.IOException;

public class JSONexample {


    public static void main(String[] args) throws IOException, ParseException {
        String filepath = "C:\\SCRATCH\\stag_resit-main\\resources\\data\\basic-actions.json";

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(filepath));
        var whatIsIt  = jsonObject.get("actions");
        JSONArray jsonArray = (JSONArray) whatIsIt;
        for (var v : jsonArray){
            JSONArray consumed = (JSONArray)((JSONObject)v).get("consumed");
            JSONArray triggers = (JSONArray)((JSONObject)v).get("triggers");
            JSONArray subjects = (JSONArray)((JSONObject)v).get("subjects");
            JSONArray produced = (JSONArray)((JSONObject)v).get("produced");
            String narration = (String)((JSONObject)v).get("narration");

            for (var w : consumed)
                System.out.println((String) w);
            for (var w : triggers)
                System.out.println((String) w);
            for (var w : subjects)
                System.out.println((String) w);
            for (var w : produced)
                System.out.println((String) w);

            System.out.println(narration);

        }
    }
}
