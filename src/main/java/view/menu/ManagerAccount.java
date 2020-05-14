package view.menu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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
        submenus.put(9, new ViewDiscountCodes(this));
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
        Menu menu = null;
        return menu;
        //TODO
    }
    private Menu createDiscountCode() {
        return new Menu("Manage All Products", this) {
            @Override
            public void show() {
                System.out.println("Manage All Products: ");
                System.out.println("Enter create discount code or back to return: ");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                } else {
                    String code = input;
                    System.out.print("Enter password: ");
                    String startDate = scanner.nextLine();
                    System.out.print("Enter StartTime: ");
                    String startTime = scanner.nextLine();
                    System.out.print("Enter endTime: ");
                    String endTime = scanner.nextLine();
                    System.out.println("Enter discountPercent: ");
                    int discountPercent = scanner.nextInt();
                    System.out.print("Enter high of discount: ");
                    Double highDiscount = scanner.nextDouble();
                    System.out.println("Enter total use for each account: ");
                    int totalUseForEachAccount = scanner.nextInt();
                    ArrayList<String> allValidUsers = new ArrayList<>();
                    String allUsers = scanner.nextLine();
                    String[] userNameOfUsers = input.split("\\s");
                    //send to controller
                    // TODO
                    this.show();
                    this.execute();
                }
            }
        };
        //TODO

    }

    private Menu manageRequests() {
        return new Menu("Manage Request", this) {
            @Override
            public void show() {
                System.out.println("Manage Request: ");
            }

            @Override
            public void execute() {
                //Send information to controller
                //TODO
            }
        };
    }
    private Menu manageCategories() {
        //TODO
        Menu menu = null;
        return menu;
    }

}
