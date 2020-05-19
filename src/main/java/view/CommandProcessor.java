package view;

import view.menu.MainMenu;
import view.menu.Menu;

import java.util.Scanner;

public class CommandProcessor {
    // testing push
    private Scanner scanner;

    public CommandProcessor() {
        scanner = new Scanner(System.in);
    }

    public void runWithMenu() {
        Menu.setScanner(this.scanner);
        Menu currentMenu = new MainMenu();
        currentMenu.show();
        currentMenu.execute();
        //RETURN
    }
}
