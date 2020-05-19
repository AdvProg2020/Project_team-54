package view.menu.products;

import jdk.swing.interop.SwingInterOpUtils;
import view.menu.Menu;

import java.util.HashMap;

public class Filtering extends Menu {
    public Filtering(Menu parentMenu) {
        super("Filtering", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<Integer, Menu>();
        submenus.put(1, showAvailableFilter());
        submenus.put(2, filter());
        submenus.put(3, currentFilter());
        submenus.put(4, disableFilter());
        this.setSubmenus(submenus);
    }

    @Override
    public void execute() {
        int chosenMenu = Integer.parseInt(scanner.nextLine());
        if (chosenMenu == 1) {
            showAvailableFilter().show();
            showAvailableFilter().execute();
        }
        if (chosenMenu == 2) {
            currentFilter().show();
            currentFilter().execute();
        }
        if (chosenMenu == 3) {
            currentFilter().show();
            currentFilter().execute();

        }
        if (chosenMenu == 4) {
            disableFilter().show();
            disableFilter().execute();
        }
    }

    private Menu showAvailableFilter() {
        return new Menu("Show Available Filters", this) {
            @Override
            public void show() {
                System.out.println("Show Available Filter: ");
            }

            @Override
            public void execute() {
                //send to controller
                //TODO
            }
        };
    }

    private Menu filter() {
        return new Menu("Filter An Available Filter", this) {
            @Override
            public void show() {
                System.out.println("Filter An Available Filter: ");
                System.out.println("Enter target filter or back to return: ");
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

    private Menu currentFilter() {
        return new Menu("Current Filters", this) {
            @Override
            public void show() {
                System.out.println("Current Filters: ");
            }

            @Override
            public void execute() {
                //send to controller
                //TODO
            }
        };
    }

    private Menu disableFilter() {
        return new Menu("Disable Filter", this) {
            @Override
            public void show() {
                System.out.println("Disable Filter: ");
                System.out.println("Enter target filter or back to return: ");
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
