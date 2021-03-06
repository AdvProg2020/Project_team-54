package view.menu;

import view.menu.products.ProductsMenu;

import java.util.HashMap;

public class MainMenu extends Menu {

    public MainMenu() {
        super("main.java.Main Menu", null);
        HashMap<Integer, Menu> submenus = new HashMap<Integer, Menu>();
        submenus.put(1, new LoginAndRegisterMenu(this));
        submenus.put(2, new ProductsMenu(this));
        submenus.put(3, new OffsMenu(this));
        this.setSubmenus(submenus);
    }
}
