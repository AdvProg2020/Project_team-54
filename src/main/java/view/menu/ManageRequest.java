package view.menu;

import java.util.HashMap;

public class ManageRequest extends Menu {
    public ManageRequest(Menu parentMenu) {
        super("Manage Request", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<Integer, Menu>();
        submenus.put(1, detailRequest());
        submenus.put(2, acceptRequest());
        submenus.put(3, declineRequest());
        this.setSubmenus(submenus);
    }

    @Override
    public void execute() {
        viewManageRequest();
        int chosenMenu = Integer.parseInt(scanner.nextLine());
        if (chosenMenu == 1) {
            detailRequest().show();
            detailRequest().execute();
        }
        if (chosenMenu == 2) {
            acceptRequest().show();
            acceptRequest().execute();
        }
        if (chosenMenu == 3) {
            declineRequest().show();
            declineRequest().execute();
        }
    }

    private void viewManageRequest() {
        //send to main.java.controller
        //TODO
    }

    private Menu detailRequest() {
        return new Menu("Detail Request", this) {
            @Override
            public void show() {
                System.out.println("Detail Request: ");
                System.out.println("Enter target requestId or back to return: ");
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

    private Menu acceptRequest() {
        return new Menu("Accept Request", this) {
            @Override
            public void show() {
                System.out.println("Accept Request: ");
                System.out.println("Enter target requestId or back to return: ");
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

    private Menu declineRequest() {
        return new Menu("Decline Request", this) {
            @Override
            public void show() {
                System.out.println("Decline Request: ");
                System.out.println("Enter target requestId or back to return: ");
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
