package view.menu;

import java.util.HashMap;

public class RegisterMenu extends Menu {
    public RegisterMenu (Menu parentMenu) {
        super("Register Menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<Integer, Menu>();
        submenus.put(1, register());
    }
    public Menu register() {
        //TODO
        return null;
    }
}
