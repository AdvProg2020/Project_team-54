package view.menu;

import java.util.HashMap;


public class ManagerAccount extends Menu {
    public ManagerAccount(Menu parentMenu) {
        super("Manager Account", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<Integer, Menu>();
        submenus.put(1, viewPersonalInfo());
        submenus.put(2, editField());
        submenus.put(3, manageUsers());
        submenus.put(4, manageAllProducts());
        submenus.put(5, createDiscountCode());
        submenus.put(6, viewDiscountCodes());
        submenus.put(7, manageRequests());
        submenus.put(8, manageCategories());
        this.setSubmenus(submenus);
    }

    private Menu viewPersonalInfo() {
        //return new menu @override
        //TODO
        Menu menu = null;
        return menu;
    }
    private Menu editField() {
        //TODO
        Menu menu = null;
        return menu;
    }
    private Menu manageUsers() {
        //TODO
        Menu menu = null;
        return menu;
    }
    private Menu manageAllProducts() {
        //TODO
        Menu menu = null;
        return menu;
    }
    private Menu createDiscountCode() {
        //TODO
        Menu menu = null;
        return menu;
    }
    private Menu viewDiscountCodes() {
        //TODO
        Menu menu = null;
        return menu;
    }
    private Menu manageRequests() {
        //TODO
        Menu menu = null;
        return menu;
    }
    private Menu manageCategories() {
        //TODO
        Menu menu = null;
        return menu;
    }

}
