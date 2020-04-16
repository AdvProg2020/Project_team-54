package view.menu;

import java.util.HashMap;

public class ProductsMenu extends Menu {
    public ProductsMenu(Menu parentMenu) {
        super("Products Menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<Integer, Menu>();
        submenus.put(1, viewCategories());
        submenus.put(2, filtering());
        submenus.put(3, sorting());
        submenus.put(4, showProducts());
        // must be changed ProductMenu
        submenus.put(5, new ProductMenu(this));
        this.setSubmenus(submenus);
    }
    private Menu viewCategories() {
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
    private Menu sorting() {
        //TODO
        Menu menu = null;
        return menu;
    }
    private Menu showProducts() {
        //TODO
        Menu menu = null;
        return menu;
    }
    private Menu showproductWithId() {
        //TODO
        Menu menu = null;
        return menu;
    }

}
