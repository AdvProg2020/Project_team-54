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
        return new Menu("View Personal Info", this) {
            @Override
            public void show() {
                System.out.println("View Personal Info:");
            }

            @Override
            public void execute() {
                    // TODO
                    this.show();
                    this.execute();

            }
        };
    }
    private Menu editField() {
        return new Menu("Edit Field", this) {
            @Override
            public void show() {
                System.out.println("Edit field :");
                System.out.println("Enter field and new entry: ");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                } else {
                    String[] splitInput = input.split("\\s");
                    // TODO
                    this.show();
                    this.execute();
                }
            }
        };
    }
    private Menu manageUsers() {
        return new Menu("Manage Users", this) {
            @Override
            public void show() {
                System.out.println("Manage Users:");
            }

            @Override
            public void execute() {
                    // TODO
                    this.show();
                    this.execute();

            }
        };
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
