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
        if (chosenMenu == 1) {
            editPersonalInfo().show();
            editPersonalInfo().execute();
        }
    }

    private void viewPersonalInfo() {

        //take arraylist send to manager main.java.view information method



        //account
        //account.viewInformation --> ArrayList
        //send to main.java.controller
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

                    //account
                    //account.editField(String field, String newInput);
                    //send to main.java.controller
                    //TODO
                }
            }
        };
    }
}
