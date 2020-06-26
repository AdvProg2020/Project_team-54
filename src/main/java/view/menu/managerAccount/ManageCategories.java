package view.menu.managerAccount;

import view.menu.Menu;

import java.util.HashMap;

public class ManageCategories extends Menu {
    public ManageCategories(Menu parentMenu) {
        super("Manage Categories", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<Integer, Menu>();
        submenus.put(1, editCategory());
        submenus.put(2, addCategory());
        submenus.put(3, removeCategory());
        this.setSubmenus(submenus);
    }

    @Override
    public void execute() {
        showAllCategories();
        int chosenMenu = Integer.parseInt(scanner.nextLine());

        if (chosenMenu == 1) {
            editCategory().show();
            editCategory().execute();
        }
        if (chosenMenu == 2) {
            addCategory().show();
            addCategory().execute();
        }
        if (chosenMenu == 3) {
            removeCategory().show();
            removeCategory().execute();
        }
    }

    private void showAllCategories() {
        //send to main.java.controller
        //TODO
    }

    private Menu editCategory() {
        return new Menu("Edit Category", this) {
            @Override
            public void show() {
                System.out.println("Edit Category: ");
                System.out.println("Enter target name or back to return: ");
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

    private Menu addCategory() {
        return new Menu("Add Category", this) {
            @Override
            public void show() {
                System.out.println("Add Category: ");
                System.out.println("Enter name or back to return: ");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                } else {
                    System.out.println("Enter feature of this category in a line: ");
                    String categories = scanner.nextLine();
                    String[] allCategories = categories.split("\\s");
                    //send to main.java.controller
                    //TODO
                }
            }
        };
    }

    private Menu removeCategory() {
        return new Menu("Remove Category", this) {
            @Override
            public void show() {
                System.out.println("Remove Category: ");
                System.out.println("Enter target name or back to return: ");
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
}
