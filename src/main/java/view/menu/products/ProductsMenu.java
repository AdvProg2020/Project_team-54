package view.menu.products;

import view.menu.Menu;
import view.menu.ProductMenu;

import java.util.HashMap;

public class ProductsMenu extends Menu {
    public ProductsMenu(Menu parentMenu) {
        super("Products Menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<Integer, Menu>();
        submenus.put(1, viewCategories());
        submenus.put(2, new Filtering(this));
        submenus.put(3, new Sorting(this));
        submenus.put(4, showProducts());
        submenus.put(5, showProductWithId());
        this.setSubmenus(submenus);
    }
    private Menu viewCategories() {
        return new Menu("View Categories", this) {
            @Override
            public void show() {
                System.out.println("View Categories: ");
            }

            @Override
            public void execute() {
                //send to controller
                //TODO
            }
        };
    }

    private Menu showProducts() {
        return new Menu("Show Products", this) {
            @Override
            public void show() {
                System.out.println("Show Products: ");
            }

            @Override
            public void execute() {
                //send to controller
                //TODO
            }
        };
    }
    private Menu showProductWithId() {
        return new Menu("Show Product With Id", this) {
            @Override
            public void show() {
                System.out.println("Show Product With Id: ");
                System.out.println("Enter target productId or back to return: ");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                } else {
                    //go to product page woo
                    //send to controller
                    //TODO
                    ProductMenu productMenu = new ProductMenu(this);
                    productMenu.show();
                    productMenu.execute();
                }
            }
        };
    }

}
