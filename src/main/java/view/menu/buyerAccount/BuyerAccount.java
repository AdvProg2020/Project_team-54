package view.menu.buyerAccount;

import model.Account;
import view.menu.Menu;
import view.menu.OffsMenu;
import view.menu.ViewPersonalInfo;
import view.menu.products.ProductsMenu;

import java.util.HashMap;

public class BuyerAccount extends Menu {
    Account thisAccount;
    public BuyerAccount(Menu parentMenu, Account thisAccount) {
        super("Buyer Account", parentMenu);
        this.thisAccount = thisAccount;
        HashMap<Integer, Menu> submenus = new HashMap<Integer, Menu>();
        submenus.put(1, new ViewPersonalInfo(this));
        submenus.put(2, new ViewCart(this));
        submenus.put(3, purchase());
        submenus.put(4, new ViewOrders(this));
        submenus.put(5, viewBalance());
        submenus.put(6, viewDiscountCodes());
        submenus.put(7, new ProductsMenu(this));
        submenus.put(8, new OffsMenu(this));
        this.setSubmenus(submenus);
    }

    @Override
    public void show() {
        System.out.println("Buyer Account:");
        for (Integer menuNum : submenus.keySet()) {
            System.out.println(menuNum + ". " + submenus.get(menuNum).getName());
        }
        if (this.parentMenu != null)
            System.out.println((submenus.size() + 1) + ". Back");
        else
            System.out.println((submenus.size() + 1) + ". Exit");
    }

    @Override
    public void execute() {
        Menu nextMenu = null;
        int chosenMenu = Integer.parseInt(scanner.nextLine());
        if (chosenMenu == submenus.size() + 1) {
            if (this.parentMenu == null)
                System.exit(0);
            else
                nextMenu = this.parentMenu;
        } else
            nextMenu = submenus.get(chosenMenu);
        nextMenu.show();
        nextMenu.execute();
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
                    //send to main.java.controller
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
                //send to main.java.controller
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
                //send to main.java.controller
                //TODO
            }
        };
    }

}
