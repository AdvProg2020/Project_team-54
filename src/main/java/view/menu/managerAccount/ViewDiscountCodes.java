package view.menu.managerAccount;

import view.menu.Menu;

import java.util.HashMap;

public class ViewDiscountCodes extends Menu {
    public ViewDiscountCodes(Menu parentMenu) {
        super("View DiscountCodes", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<Integer, Menu>();
        submenus.put(1, viewDiscountCode());
        submenus.put(2, editDiscountCode());
        submenus.put(3, removeDiscountCode());
        this.setSubmenus(submenus);
    }

    @Override
    public void execute() {
        viewDiscountCodes();
        int chosenMenu = Integer.parseInt(scanner.nextLine());
        if (chosenMenu == 1) {
            viewDiscountCode().show();
            viewDiscountCode().execute();
        }
        if (chosenMenu == 2) {
            editDiscountCode().show();
            editDiscountCode().execute();
        }
        if (chosenMenu == 3) {
            removeDiscountCode().show();
            removeDiscountCode().execute();
        }
    }

    private void viewDiscountCodes() {
        //send to main.java.controller
        //TODO
    }

    private Menu viewDiscountCode() {
        return new Menu("View Discount Code", this) {
            @Override
            public void show() {
                System.out.println("View Discount Code: ");
                System.out.println("Enter target code or back to return: ");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                } else {
                    //send to main.java.controller
                    //TODO
                }
            }
        };
    }

    private Menu editDiscountCode() {
        return new Menu("Edit Discount Code", this) {
            @Override
            public void show() {
                System.out.println("Edit Discount Code: ");
                System.out.println("Enter target code or back to return: ");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                } else {
                    //send to main.java.controller
                    //TODO
                }
            }
        };
    }

    private Menu removeDiscountCode() {
        return new Menu("Remove Discount Code", this) {
            @Override
            public void show() {
                System.out.println("Remove Discount Code: ");
                System.out.println("Enter target code or back to return: ");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                } else {
                    //send to main.java.controller
                    //TODO
                }
            }
        };
    }
}
