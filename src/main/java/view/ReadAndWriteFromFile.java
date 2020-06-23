package view;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import model.Account;
import model.Role;

import java.io.*;

public class ReadAndWriteFromFile {
    private static String fileLocation = "/Users/Reza/Desktop/gson.txt";
    private static Gson gson = new Gson();

    /*
    public static void main(String[] args) {
        Account account = new Account("rezasoon", "reza", "soumi", "09213546468", "reza.souni800@gmail.com", "0ytrrrrr", Role.buyer);

        // Save data to file
        //writeToFile(gson.toJson(account));

        // Retrieve data from file
        readFromFile(fileLocation);
    }

     */

    public static String readFromFile(String fileLocation) {
        File file = new File(fileLocation);
        if (!file.exists())
            return ("File doesn't exist");

        InputStreamReader isReader;
        try {
            isReader = new InputStreamReader(new FileInputStream(file), "UTF-8");

            JsonReader myReader = new JsonReader(isReader);
            Account account = gson.fromJson(myReader, Account.class);
            Account account2 = gson.fromJson(myReader, Account.class);
            //while (myReader.hasNext()) {
            //    System.out.println(myReader.toString());
            //}
            //BufferedReader bufferedReader = new BufferedReader(isReader);
            //String line;
            //while ((line = bufferedReader.readLine()) != null) {
            //    System.out.println(line);
            //}

            //log("Company Name: " + account.getUsername());

            //log("second account: " + account2.getUsername());
            //log("second account: " + account2.getPassword());

        } catch (Exception e) {
            return ("error load cache from file " + e.toString());
        }

        return ("\nComapny Data loaded successfully from file " + fileLocation);

    }

    public static String writeToFile(String myData, String fileLocation) {
        File file = new File(fileLocation);
        if (!file.exists()) {
            try {
                File directory = new File(file.getParent());
                if (!directory.exists()) {
                    directory.mkdirs();
                }
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Excepton Occured: " + e.toString());
            }
        }

        try {
            // Convenience class for writing character files
            FileWriter fileWriter;
            fileWriter = new FileWriter(file.getAbsoluteFile(), true);

            // Writes text to a character-output stream
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
            bufferWriter.write(myData);
            bufferWriter.close();

            return  ("Company data saved at file location: " + fileLocation + " Data: " + myData + "\n");
        } catch (IOException e) {
            return  ("Hmm.. Got an error while saving Company data to file " + e.toString());
        }
    }

    private static void log(String string) {
        System.out.println(string);
    }
}
