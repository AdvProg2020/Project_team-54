package view.menu;

import java.util.HashMap;

public class BuyerAccount extends Menu {
    public BuyerAccount(Menu parentMenu) {
        super("Buyer Account", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<Integer, Menu>();
        submenus.put(1, new ViewPersonalInfo(this));
        submenus.put(2, new ViewCart(this));
        submenus.put(3, purchase());
        submenus.put(4, new ViewOrders(this));
        submenus.put(5, viewBalance());
        submenus.put(6, viewDiscountCodes());
        this.setSubmenus(submenus);
    }

    private Menu purchase() {
        return new Menu("Edit Personal Info", this) {
            @Override
            public void show() {
                System.out.println("Edit Personal Info: ");
                System.out.println("Enter name or back to return: ");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                } else {
                    System.out.println("Enter your address: ");
                    String address = scanner.nextLine();
                    System.out.println("Enter your postcode: ");
                    String postcode = scanner.nextLine();
                    System.out.println("Enter your telephone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.println("Enter your discount code: ");
                    String discountCode = scanner.nextLine();
                    //go to payment page
                    //send to controller
                    //TODO
                }
            }
        };

    }


    private Menu viewBalance() {
        return new Menu("View Balance", this) {
            @Override
            public void show() {
                System.out.println("View Balance: ");
            }

            @Override
            public void execute() {
                //send to controller
                //TODO
            }
        };
    }

    private Menu viewDiscountCodes() {
        return new Menu("View Discount Codes", this) {
            @Override
            public void show() {
                System.out.println("View Discount Codes: ");
            }

            @Override
            public void execute() {
                //send to controller
                //TODO
            }
        };
    }

}
