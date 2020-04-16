package view.menu;

import java.util.Scanner;

public class CommandProcessor {
    private Scanner scanner;
    public void runWithMenu() {
        Menu.setScanner(this.scanner);
        Menu currentMenu = new MainMenu();
        currentMenu.show();
        currentMenu.execute();
    }
}
