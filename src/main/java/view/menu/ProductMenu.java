package view.menu;

import java.util.HashMap;

public class ProductMenu extends Menu{

    public ProductMenu(Menu parentMenu) {
        super("Product Menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<Integer, Menu>();
        submenus.put(1, new Digest(this));
        submenus.put(2, attributes());
        submenus.put(3, compare());
        submenus.put(4, Comments());
        this.setSubmenus(submenus);
    }

    private Menu attributes() {
        return new Menu("Attributes", this) {
            @Override
            public void show() {
                System.out.println("Attributes: ");
            }

            @Override
            public void execute() {
                //send to main.java.controller
                //TODO
            }
        };
    }
    private Menu compare() {
        return new Menu("Compare With Id", this) {
            @Override
            public void show() {
                System.out.println("Compare With Id: ");
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
    private Menu Comments() {
        //return new menu @override
        //TODO
        Menu menu = null;
        return menu;
    }


}
