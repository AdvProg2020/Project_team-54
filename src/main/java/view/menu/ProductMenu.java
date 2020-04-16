package view.menu;

import java.util.HashMap;

public class ProductMenu extends Menu{

    // to save and use ID of the product should change a few this class

    public ProductMenu(Menu parentMenu) {
        super("Product Menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<Integer, Menu>();
        submenus.put(1, digest());
        submenus.put(2, attributes());
        submenus.put(3, compare());
        submenus.put(4, Comments());
        this.setSubmenus(submenus);
    }
    private Menu digest() {
        //return new menu @override
        //TODO
        Menu menu = null;
        return menu;
    }
    private Menu attributes() {
        //return new menu @override
        //TODO
        Menu menu = null;
        return menu;
    }
    private Menu compare() {
        //return new menu @override
        //TODO
        Menu menu = null;
        return menu;
    }
    private Menu Comments() {
        //return new menu @override
        //TODO
        Menu menu = null;
        return menu;
    }


}
