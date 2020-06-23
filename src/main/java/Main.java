//package main.java;

import model.Account;
import model.Role;
import com.google.gson.Gson;
import view.CommandProcessor;

public class Main {
    public static void main(String[] args) {
        CommandProcessor commandProcessor = new CommandProcessor();
        commandProcessor.runWithMenu();
    }


}
