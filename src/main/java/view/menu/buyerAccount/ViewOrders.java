package view.menu.buyerAccount;

import view.menu.Menu;

import java.util.HashMap;

public class ViewOrders extends Menu {
    public ViewOrders(Menu parentMenu) {
        super("View Orders", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<Integer, Menu>();
        submenus.put(1, showOrder());
        submenus.put(2, rateOrder());
        this.setSubmenus(submenus);
    }

    @Override
    public void execute() {
        viewOrders();
        int chosenMenu = Integer.parseInt(scanner.nextLine());
        if (chosenMenu == 1) {
            showOrder().show();
            showOrder().execute();
        }
        if (chosenMenu == 2) {
            rateOrder().show();
            rateOrder().execute();
        }
    }

    private void viewOrders() {
        //send to controller
        //TODO
    }

    private Menu showOrder() {
        return new Menu("Show Orders", this) {
            @Override
            public void show() {
                System.out.println("Show Orders: ");
                System.out.println("Enter target orderId or back to return: ");
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

    private Menu rateOrder() {
        return new Menu("rate Order", this) {
            @Override
            public void show() {
                System.out.println("rate Order: ");
                System.out.println("Enter target orderId or back to return: ");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                } else {
                    System.out.println("Enter your score from 1 to 5: ");
                    String score = scanner.nextLine();
                    //send to controller
                    //TODO
                }
            }
        };
    }
}
