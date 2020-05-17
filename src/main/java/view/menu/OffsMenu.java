package view.menu;

import java.util.HashMap;

public class OffsMenu extends Menu{
    public OffsMenu(Menu parentMenu) {
        super("Offs Menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<Integer, Menu>();
        // it must be changed
        submenus.put(1, showProduct());
        submenus.put(2, filtering());
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
    private Menu filtering() {
        //TODO
        Menu menu = null;
        return menu;
    }
}
