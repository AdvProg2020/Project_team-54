package view.menu;

import java.util.HashMap;

public class LoginMenu extends Menu {
    public LoginMenu(Menu parentMenu) {
        super("Login Menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<Integer, Menu>();
        submenus.put(1, new ManagerAccount(this));
        submenus.put(2, new SellerAccount(this));
        submenus.put(3, new BuyerAccount(this));
        this.setSubmenus(submenus);
    }
}
