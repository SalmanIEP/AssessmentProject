package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarDetails {


    public static List<String> getUKCarsRegistrationNumber(String FileName) throws IOException {
        Log.info("opening the input file");

        String filePath = "src/main/java/inputFiles/"+FileName+".txt";
        Path path = Path.of(filePath);
        Log.info("reading file: -> "+filePath);

        List<String> registrationNumbers = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        Pattern pattern = Pattern.compile("([A-Z]{3}\\s?(\\d{3}|\\d{2}|d{1})\\s?[A-Z])|([A-Z]\\s?(\\d{3}|\\d{2}|\\d{1})\\s?[A-Z]{3})|(([A-HK-PRSVWY][A-HJ-PR-Y])\\s?([0][2-9]|[1-9][0-9])\\s?[A-HJ-PR-Z]{3})");
        String line;
        Log.info("reading Registration number from the file "+ FileName);
        while ((line = br.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find())
            {
                registrationNumbers.add(matcher.group());
            }
        }
        Log.info("Registration numbers found");
        Log.info(registrationNumbers.toString());
        return registrationNumbers;
    }

    public static Map<String, String> getExpectedCarDetails(String fileName, String carRegNumber) throws IOException {
        Log.info("opening the Output file");
        String filePath = "src/main/java/outPutFiles/"+fileName+".txt";
        Path path = Path.of(filePath);
        Log.info("reading file: -> "+filePath);
        Map<String, String> carDetails = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;

        Log.info("reading expected records");
        while ((line = br.readLine()) != null) {

             if(line.contains(carRegNumber)){
                 String[] records = line.split(",");
                 carDetails.put("REGISTRATION",records[0]);
                 carDetails.put("MAKE",records[1]);
                 carDetails.put("MODEL",records[2]);
                 carDetails.put("COLOUR",records[3]);
                 carDetails.put("YEAR",records[4]);
                break;
             }
        }
        Log.info("Expected records are"+ carDetails.toString());
        return carDetails;
    }



}




