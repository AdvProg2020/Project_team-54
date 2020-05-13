package view.menu;

import java.util.HashMap;


public class ManagerAccount extends Menu {
    public ManagerAccount(Menu parentMenu) {
        super("Manager Account", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<Integer, Menu>();
        submenus.put(1, viewPersonalInfo());
        submenus.put(2, editField());
        submenus.put(3, manageUsers());
        submenus.put(4, view());
        submenus.put(5, deleteUser());
        submenus.put(6, createManagerProfile());
        submenus.put(7, manageAllProducts());
        submenus.put(8, createDiscountCode());
        submenus.put(9, viewDiscountCodes());
        submenus.put(10, manageRequests());
        submenus.put(11, manageCategories());
        this.setSubmenus(submenus);
    }

    private Menu viewPersonalInfo() {
        return new Menu("View Personal Info", this) {
            @Override
            public void show() {
                System.out.println("View Personal Info:");
            }

            @Override
            public void execute() {
                //send to controller
                // TODO
                    this.show();
                    this.execute();

            }
        };
    }
    private Menu editField() {
        return new Menu("Edit Field", this) {
            @Override
            public void show() {
                System.out.println("Edit field :");
                System.out.println("Enter edit field or back to return: ");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                } else {
                    System.out.print("Enter field: ");
                    String field = scanner.nextLine();
                    System.out.print("Enter new entry: ");
                    String newEntry = scanner.nextLine();
                    //send to controller
                    // TODO
                    this.show();
                    this.execute();
                }
            }
        };
    }
    private Menu manageUsers() {
        return new Menu("Manage Users", this) {
            @Override
            public void show() {
                System.out.println("Manage Users:");
            }

            @Override
            public void execute() {
                //send to controller
                // TODO
                    this.show();
                    this.execute();

            }
        };
    }

    private Menu view() {
        return new Menu("View userName", this) {
            @Override
            public void show() {
                System.out.println("View UserName");
                System.out.println("Enter userName: ");
            }

            @Override
            public void execute() {
                String userName = scanner.nextLine();
                //send to controller
                //TODO
                this.show();
                this.execute();
            }
        };
    }

    private Menu deleteUser() {
        return new Menu("Delete Users", this) {
            @Override
            public void show() {
                System.out.println("Delete User: ");
                System.out.println("Enter userName: ");
            }

            @Override
            public void execute() {
                String userName = scanner.nextLine();
                //send to controller
                //TODO
                this.show();
                this.execute();
            }
        };
    }

    private Menu createManagerProfile() {
        return new Menu("Create Manager Profile", this) {
            @Override
            public void show() {
                System.out.println("Create Account");
                System.out.println("Enter userName or back to return: ");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                } else {
                    String userName = input;
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter familyName: ");
                    String familyName = scanner.nextLine();
                    System.out.print("Enter eMail: ");
                    String eMail = scanner.nextLine();
                    System.out.print("Enter phoneNumber: ");
                    String phoneNumber = scanner.nextLine();
                    if (input.equalsIgnoreCase("seller")) {
                        System.out.print("Enter name of company: ");
                        String companyName = scanner.nextLine();
                    }
                    //send to controller
                    // TODO
                    this.show();
                    this.execute();
                }
            }
        };
    }
    private Menu manageAllProducts() {
        //TODO
        Menu menu = null;
        return menu;
    }
    private Menu createDiscountCode() {
        //TODO
        Menu menu = null;
        return menu;
    }
    private Menu viewDiscountCodes() {
        //TODO
        Menu menu = null;
        return menu;
    }
    private Menu manageRequests() {
        //TODO
        Menu menu = null;
        return menu;
    }
    private Menu manageCategories() {
        //TODO
        Menu menu = null;
        return menu;
    }

}
