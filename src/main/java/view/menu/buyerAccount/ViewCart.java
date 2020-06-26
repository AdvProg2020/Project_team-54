package view.menu.buyerAccount;

import view.menu.Menu;
import view.menu.ProductMenu;

import java.util.HashMap;

public class ViewCart extends Menu {
    public ViewCart(Menu parentMenu) {
        super("View Cart", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<Integer, Menu>();
        submenus.put(1, showProducts());
        submenus.put(2, viewProduct());
        submenus.put(3, increaseProduct());
        submenus.put(4, decreaseProduct());
        submenus.put(5, showTotalPrice());
        submenus.put(6, purchase());
        this.setSubmenus(submenus);
    }

    @Override
    public void execute() {
        viewCart();
        int chosenMenu = Integer.parseInt(scanner.nextLine());
        if (chosenMenu == 1) {
            showProducts().show();
            showProducts().execute();
        }
        if (chosenMenu == 2) {
            viewProduct().show();
            viewProduct().execute();
        }
        if (chosenMenu == 3) {
            increaseProduct().show();
            increaseProduct().execute();
        }
        if (chosenMenu == 4) {
            decreaseProduct().show();
            decreaseProduct().execute();
        }
        if (chosenMenu == 5) {
            showTotalPrice().show();
            showTotalPrice().execute();
        }
        if (chosenMenu == 6) {
            purchase().show();
            purchase().execute();
        }
    }

    private void viewCart() {
        //send to main.java.controller
        //TODO
    }

    private Menu showProducts() {
        return new Menu("Show Product", this) {
            @Override
            public void show() {
                System.out.println("Show Product: ");
            }

            @Override
            public void execute() {
                //send to main.java.controller
                //TODO
            }
        };
    }

    private Menu viewProduct() {
        return new Menu("View Product", this) {
            @Override
            public void show() {
                System.out.println("View Product: ");
                System.out.println("Enter target productId or back to return: ");
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
                    ProductMenu productMenu = new ProductMenu(this);
                    productMenu.show();
                    productMenu.execute();
                }
            }
        };
    }

    private Menu increaseProduct() {
        return new Menu("Increase Product", this) {
            @Override
            public void show() {
                System.out.println("Increase Product: ");
                System.out.println("Enter target productId or back to return: ");
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

    private Menu decreaseProduct() {
        return new Menu("Decrease Product", this) {
            @Override
            public void show() {
                System.out.println("Decrease Product: ");
                System.out.println("Enter target productId or back to return: ");
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

    private Menu showTotalPrice() {
        return new Menu("Show Total Price", this) {
            @Override
            public void show() {
                System.out.println("Show Total Price: ");
            }

            @Override
            public void execute() {
                //send to main.java.controller
                //TODO
            }
        };
    }

    private Menu purchase() {
        return new Menu("Purchase", this) {
            @Override
            public void show() {
                System.out.println("Purchase: ");
            }

            @Override
            public void execute() {
                //send to main.java.controller
                //TODO
            }
        };
    }
}
