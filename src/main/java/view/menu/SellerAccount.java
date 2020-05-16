package view.menu;

import java.util.HashMap;

public class SellerAccount extends Menu{
    public SellerAccount(Menu parentMenu) {
        super("Seller Account", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<Integer, Menu>();
        submenus.put(1, new ViewPersonalInfo(this));
        submenus.put(2, viewCompanyInformation());
        submenus.put(3, viewSalesHistory());
        submenus.put(4, new ManageProducts());
        submenus.put(5, addProduct());
        submenus.put(6, removeProduct());
        submenus.put(7, showCategories());
        submenus.put(8, viewOffs());
        submenus.put(9, viewBalance());
        this.setSubmenus(submenus);
    }

    private Menu viewCompanyInformation() {
        return new Menu("View Company Information", this) {
            @Override
            public void show() {
                System.out.println("View Company Information: ");
            }

            @Override
            public void execute() {
                    //send to controller
                    //TODO
            }
        };
    }

    private Menu viewSalesHistory() {
        return new Menu("View Sales History", this) {
            @Override
            public void show() {
                System.out.println("View Sales History: ");
            }

            @Override
            public void execute() {
                //send to controller
                //TODO
            }
        };
    }

    private Menu addProduct() {
        return new Menu("Add Product", this) {
            @Override
            public void show() {
                System.out.println("Add Product: ");
                System.out.println("Enter productId or back to return: ");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                } else {
                    System.out.println("Enter name of your category: ");
                    String category = scanner.nextLine();
                    System.out.println("Enter price of your product: ");
                    Double price = Double.parseDouble(scanner.nextLine());
                    System.out.println("Enter brand of your product: ");
                    String brand = scanner.nextLine();
                    System.out.println("Enter description of your product: ");
                    String description = scanner.nextLine();
                    //send to controller
                    //TODO
                }
            }
        };
    }

    private Menu removeProduct() {
        return new Menu("Remove Product", this) {
            @Override
            public void show() {
                System.out.println("Remove Product: ");
                System.out.println("Enter target productId or back to return: ");
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
    private Menu showCategories() {
        return new Menu("Show Categories", this) {
            @Override
            public void show() {
                System.out.println("Show Categories: ");
            }

            @Override
            public void execute() {
                //send to controller
                //TODO
            }
        };
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
