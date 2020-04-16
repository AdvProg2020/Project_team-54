package view.menu;

import java.util.HashMap;

public class OffsMenu extends Menu{
    public OffsMenu(Menu parentMenu) {
        super("Offs Menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<Integer, Menu>();
        // it must be changed
        submenus.put(1, new ProductMenu(this));
        submenus.put(2, filtering());
    }
    private Menu showProduct() {
        //return new menu @override
        //TODO
        Menu menu = null;
        return menu;
    }
    private Menu filtering() {
        //TODO
        Menu menu = null;
        return menu;
    }
}
