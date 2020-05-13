package view.menu;

import java.util.HashMap;

public class ViewDiscountCodes extends Menu {
    public ViewDiscountCodes(Menu parentMenu) {
        super("ViewDiscountCodes", parentMenu);
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
        Menu nextMenu;
        if (chosenMenu == 1)
            viewDiscountCode();
        if (chosenMenu == 2)
            editDiscountCode();
        if (chosenMenu == 3)
            removeDiscountCode();
        nextMenu = this.parentMenu;
        nextMenu.show();
        nextMenu.execute();
    }

    private void viewDiscountCodes() {
        //send to controller
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
                    //send to controller
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
                    //send to controller
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
                    //send to controller
                    //TODO
                }
            }
        };
    }
}
