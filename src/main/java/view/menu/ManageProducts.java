package view.menu;

import java.util.HashMap;

public class ManageProducts extends Menu {
    public ManageProducts(String name, Menu parentMenu) {
        super(name, parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<Integer, Menu>();
        submenus.put(1, viewWithId());
        submenus.put(2, viewBuyersOfProduct());
        submenus.put(3, editProduct());
        this.setSubmenus(submenus);
    }

    @Override
    public void execute() {
        showAllProducts();
        int chosenMenu = Integer.parseInt(scanner.nextLine());
        Menu nextMenu;
        if (chosenMenu == 1)
            viewWithId();
        if (chosenMenu == 2)
            viewBuyersOfProduct();
        if (chosenMenu == 3)
            editProduct();
        nextMenu = this.parentMenu;
        nextMenu.show();
        nextMenu.execute();
    }

    private void showAllProducts() {
        //send to controller
        //TODO
    }

    private Menu viewWithId() {
        return new Menu("View Product", this) {
            @Override
            public void show() {
                System.out.println("View Product: ");
                System.out.println("Enter ProductId or back to return: ");
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

    private Menu viewBuyersOfProduct() {
        return new Menu("View Buyers Of Product", this) {
            @Override
            public void show() {
                System.out.println("View Buyers Of Product: ");
                System.out.println("Enter ProductId or back to return: ");
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

    private Menu editProduct() {
        return new Menu("Edit Product", this) {
            @Override
            public void show() {
                System.out.println("Edit Product: ");
                System.out.println("Enter fields in a line or back to return: ");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                } else {
                    System.out.println("Enter new entries in order in a line: ");
                    String newEntries = scanner.nextLine();
                    String[] allFields = input.split("\\s");
                    String[] allNewEntry = newEntries.split("\\s");
                    //send to controller
                    //TODO
                }
            }
        };
    }
}
