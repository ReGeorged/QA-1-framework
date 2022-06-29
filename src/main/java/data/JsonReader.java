package data;

import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import utils.Log4jUtil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class JsonReader {
    public static String returnFromJson(String whatToGet) {
        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            obj = parser.parse(new FileReader("src/main/resources/configData.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        JSONObject jsonObject = (JSONObject) obj;

        return (String) jsonObject.get(whatToGet);
    }

    public static String returnFromTestDataJson(String whatToGet) {
        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            obj = parser.parse(new FileReader("src/main/resources/testData.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        JSONObject jsonObject = (JSONObject) obj;

        return (String) jsonObject.get(whatToGet);

    }


    private static ArrayList<String> getDataFromJson(String whichSet) {
        //Reading JSON from file system
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src/main/resources/testData.json"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String line;
        StringBuilder sbuilderObj = new StringBuilder();
        while (true) {
            try {
                if ((line = br.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            sbuilderObj.append(line);
        }
        //Using JSONObject
        org.json.JSONObject jsonObj = new org.json.JSONObject(sbuilderObj.toString());

        ArrayList<String> set = new ArrayList<>();
        //Fetching nested Json using JSONArray
        JSONArray arrObj = jsonObj.getJSONArray(whichSet);
        for (int i = 0; i < arrObj.length(); i++) {
            set.add(arrObj.getJSONObject(i).getString("name"));
            set.add(arrObj.getJSONObject(i).getString("fname"));
            set.add(arrObj.getJSONObject(i).getString("mail"));
            set.add(arrObj.getJSONObject(i).getString("age"));
            set.add(arrObj.getJSONObject(i).getString("salary"));
            set.add(arrObj.getJSONObject(i).getString("department"));
        }
        return set;
    }

    public static String getName(String whichSet) {
        Log4jUtil.log4J.info("Get name from" + whichSet + " set");
        return getDataFromJson(whichSet).get(0);
    }


    public static String getfName(String whichSet) {
        Log4jUtil.log4J.info("Get Fname from" + whichSet + " set");
        return getDataFromJson(whichSet).get(1);
    }

    public static String getMail(String whichSet) {
        Log4jUtil.log4J.info("Get mail from" + whichSet + " set");
        return getDataFromJson(whichSet).get(2);
    }

    public static String getAge(String whichSet) {
        Log4jUtil.log4J.info("Get age from" + whichSet + " set");
        return getDataFromJson(whichSet).get(3);
    }

    public static String getSalary(String whichSet) {
        Log4jUtil.log4J.info("Get Salary from" + whichSet + " set");
        return getDataFromJson(whichSet).get(4);
    }

    public static String getDepartment(String whichSet) {
        Log4jUtil.log4J.info("Get department from" + whichSet + " set");
        return getDataFromJson(whichSet).get(5);
    }

}
