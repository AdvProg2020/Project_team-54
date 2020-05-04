package view.menu;

import java.util.HashMap;

public class LoginAndRegisterMenu extends Menu {
    public LoginAndRegisterMenu(Menu parentMenu) {
        super("Login And Register Menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<Integer, Menu>();
        submenus.put(1, register());
        submenus.put(2, login());
        this.setSubmenus(submenus);
    }
    public Menu register() {
        return new Menu("Create Account", this) {
            public void show() {
                System.out.println("Create Account");
                System.out.println("Enter type and username and password or back to return: ");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                } else {
                    String[] splitInput = input.split("\\s");
                    // TODO
                    this.show();
                    this.execute();
                }
            }
        };
    }
    public Menu login() {
        return new Menu("Login", this) {
            public void show() {
                System.out.println("Login :");
                System.out.println("Enter UserName and password or back to return: ");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                } else {
                    String[] splitInput = input.split("\\s");
                    // TODO
                    this.show();
                    this.execute();
                }
            }
        };
    }
}
