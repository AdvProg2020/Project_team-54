package view.menu;

import java.util.HashMap;

public class BuyerAccount extends Menu {
    public BuyerAccount(Menu parentMenu) {
        super("Buyer Account", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<Integer, Menu>();
        submenus.put(1, viewPersonalInfo());
        submenus.put(2, viewCart());
        submenus.put(3, purchase());
        submenus.put(4, viewOrders());
        submenus.put(5, viewBalance());
        submenus.put(6, viewDiscountCodes());
        this.setSubmenus(submenus);
    }
    private Menu viewPersonalInfo() {
        //return new menu @override
        //TODO
        Menu menu = null;
        return menu;
    }
    private Menu viewCart() {
        //TODO
        Menu menu = null;
        return menu;
    }
    private Menu purchase() {
        //TODO
        Menu menu = null;
        return menu;
    }
    private Menu viewOrders() {
        //TODO
        Menu menu = null;
        return menu;
    }
    private Menu viewBalance() {
        //TODO
        Menu menu = null;
        return menu;
    }
    private Menu viewDiscountCodes() {
        //TODO
        Menu menu = null;
        return menu;
    }

}
