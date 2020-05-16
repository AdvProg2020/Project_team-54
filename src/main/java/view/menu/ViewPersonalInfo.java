package view.menu;

import java.util.HashMap;

public class ViewPersonalInfo extends Menu {
    public ViewPersonalInfo(Menu parentMenu) {
        super("View Personal Info", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<Integer, Menu>();
        submenus.put(1, editPersonalInfo());
        this.setSubmenus(submenus);
    }

    @Override
    public void execute() {
        viewPersonalInfo();
        int chosenMenu = Integer.parseInt(scanner.nextLine());
        Menu nextMenu;
        if (chosenMenu == 1)
            editPersonalInfo();
        nextMenu = this.parentMenu;
        nextMenu.show();
        nextMenu.execute();
    }

    private void viewPersonalInfo() {
        //send to controller
        //TODO
    }

    private Menu editPersonalInfo() {
        return new Menu("Edit Personal Info", this) {
            @Override
            public void show() {
                System.out.println("Edit Personal Info: ");
                System.out.println("Enter target field or back to return: ");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                } else {
                    System.out.println("Enter new entry: ");
                    String newEntry = scanner.nextLine();
                    //send to controller
                    //TODO
                }
            }
        };
    }
}
