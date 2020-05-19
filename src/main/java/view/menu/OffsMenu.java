package view.menu;

import view.menu.products.Filtering;
import view.menu.products.Sorting;

import java.util.HashMap;

public class OffsMenu extends Menu{
    public OffsMenu(Menu parentMenu) {
        super("Offs Menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<Integer, Menu>();
        submenus.put(1, showProduct());
        submenus.put(2, new Filtering(this));
        submenus.put(3, new Sorting(this));
    }
    private Menu showProduct() {
        return new Menu("Show Product", this) {
            @Override
            public void show() {
                System.out.println("Show Product: ");
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
}
