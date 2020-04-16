package view.menu;

import java.util.HashMap;

public class MainMenu extends Menu {

    public MainMenu() {
        super("Main Menu", null);
        HashMap<Integer, Menu> submenus = new HashMap<Integer, Menu>();
        submenus.put(1, new RegisterMenu(this));
        submenus.put(2, new LoginMenu(this));
        submenus.put(3, new ProductsMenu(this));
        submenus.put(4, new OffsMenu(this));
        this.setSubmenus(submenus);
    }
}
