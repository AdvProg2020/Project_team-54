package view;

import view.menu.MainMenu;
import view.menu.Menu;

import java.util.Scanner;

public class CommandProcessor {
    private Scanner scanner;
    public void runWithMenu() {
        Menu.setScanner(this.scanner);
        Menu currentMenu = new MainMenu();
        currentMenu.show();
        currentMenu.execute();
        //RETURN
    }
}
