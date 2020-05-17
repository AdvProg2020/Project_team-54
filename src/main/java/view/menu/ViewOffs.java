package view.menu;

import java.util.HashMap;

public class ViewOffs extends Menu {
    public ViewOffs(Menu parentMenu) {
        super("View Offs", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<Integer, Menu>();
        submenus.put(1, viewOffWithId());
        submenus.put(2, editOff());
        submenus.put(3, addOff());
        this.setSubmenus(submenus);
    }

    @Override
    public void execute() {
        viewOffs();
        int chosenMenu = Integer.parseInt(scanner.nextLine());
        Menu nextMenu;
        if (chosenMenu == 1)
            viewOffWithId();
        if (chosenMenu == 2)
            editOff();
        if (chosenMenu == 3)
            addOff();
        nextMenu = this.parentMenu;
        nextMenu.show();
        nextMenu.execute();
    }

    private void viewOffs() {
        //send controller
        //TODO
    }

    private Menu viewOffWithId() {
        return new Menu("View Off", this) {
            @Override
            public void show() {
                System.out.println("View Off: ");
                System.out.println("Enter target offId or back to return: ");
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

    private Menu editOff() {
        return new Menu("Edit Off", this) {
            @Override
            public void show() {
                System.out.println("Edit Off: ");
                System.out.println("Enter target offId or back to return: ");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                } else {
                    System.out.println("Enter target field: ");
                    String field = scanner.nextLine();
                    System.out.println("Enter new entry: ");
                    String newEntry = scanner.nextLine();
                    //send to controller
                    //TODO
                }
            }
        };
    }

    private Menu addOff() {
        return new Menu("Add Off", this) {
            @Override
            public void show() {
                System.out.println("Add Off: ");
                System.out.println("Enter target offId or back to return: ");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                } else {
                    System.out.println("Enter start time of your off: ");
                    String field = scanner.nextLine();
                    System.out.println("Enter end time of your off: ");
                    String newEntry = scanner.nextLine();
                    System.out.println("Enter amount of your off: ");
                    int amount = scanner.nextInt();
                    //send to controller
                    //TODO
                }
            }
        };
    }
}
