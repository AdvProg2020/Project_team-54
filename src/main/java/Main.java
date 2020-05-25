package main.java;

import main.java.model.Account;
import main.java.model.Role;
import com.google.gson.Gson;
import view.CommandProcessor;

public class Main {
    public static void main(String[] args) {
        CommandProcessor commandProcessor = new CommandProcessor();
        commandProcessor.runWithMenu();
    }


}
