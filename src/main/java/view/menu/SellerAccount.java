package view.menu;

import java.util.HashMap;

public class SellerAccount extends Menu{
    public SellerAccount(Menu parentMenu) {
        super("Seller Account", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<Integer, Menu>();
        submenus.put(1, viewPersonalInfo());
        submenus.put(2, viewCompanyInformation());
        submenus.put(3, viewSalesHistory());
        submenus.put(4, manageProducts());
        submenus.put(5, addProduct());
        submenus.put(6, removeProduct());
        submenus.put(7, showCategories());
        submenus.put(8, viewOffs());
        submenus.put(9, viewBalance());
        this.setSubmenus(submenus);
    }
    private Menu viewPersonalInfo() {
        //return new menu @override
        //TODO
        Menu menu = null;
        return menu;
    }
    private Menu viewCompanyInformation() {
        //TODO
        Menu menu = null;
        return menu;
    }
    private Menu viewSalesHistory() {
        //TODO
        Menu menu = null;
        return menu;
    }
    private Menu manageProducts() {
        //TODO
        Menu menu = null;
        return menu;
    }
    private Menu addProduct() {
        //TODO
        Menu menu = null;
        return menu;
    }
    private Menu removeProduct() {
        //TODO
        Menu menu = null;
        return menu;
    }
    private Menu showCategories() {
        //TODO
        Menu menu = null;
        return menu;
    }
    private Menu viewOffs() {
        //TODO
        Menu menu = null;
        return menu;
    }
    private Menu viewBalance() {
        //TODO
        Menu menu = null;
        return menu;
    }

}
