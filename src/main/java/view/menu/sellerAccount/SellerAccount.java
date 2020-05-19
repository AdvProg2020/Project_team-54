package view.menu.sellerAccount;

import view.menu.Menu;
import view.menu.OffsMenu;
import view.menu.ViewPersonalInfo;
import view.menu.products.ProductsMenu;

import java.util.HashMap;

public class SellerAccount extends Menu {
    public SellerAccount(Menu parentMenu) {
        super("Seller Account", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<Integer, Menu>();
        submenus.put(1, new ViewPersonalInfo(this));
        submenus.put(2, viewCompanyInformation());
        submenus.put(3, viewSalesHistory());
        submenus.put(4, new ManageProducts(this));
        submenus.put(5, addProduct());
        submenus.put(6, removeProduct());
        submenus.put(7, showCategories());
        submenus.put(8, new ViewOffs(this));
        submenus.put(9, viewBalance());
        submenus.put(10, new ProductsMenu(this));
        submenus.put(11, new OffsMenu(this));
        this.setSubmenus(submenus);
    }

    private Menu viewCompanyInformation() {
        return new Menu("View Company Information", this) {
            @Override
            public void show() {
                System.out.println("View Company Information: ");
            }

            @Override
            public void execute() {
                    //send to controller
                    //TODO
            }
        };
    }

    private Menu viewSalesHistory() {
        return new Menu("View Sales History", this) {
            @Override
            public void show() {
                System.out.println("View Sales History: ");
            }

            @Override
            public void execute() {
                //send to controller
                //TODO
            }
        };
    }

    private Menu addProduct() {
        return new Menu("Add Product", this) {
            @Override
            public void show() {
                System.out.println("Add Product: ");
                System.out.println("Enter productId or back to return: ");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                } else {
                    System.out.println("Enter name of your category: ");
                    String category = scanner.nextLine();
                    System.out.println("Enter price of your product: ");
                    Double price = Double.parseDouble(scanner.nextLine());
                    System.out.println("Enter brand of your product: ");
                    String brand = scanner.nextLine();
                    System.out.println("Enter description of your product: ");
                    String description = scanner.nextLine();
                    //send to controller
                    //TODO
                }
            }
        };
    }

    private Menu removeProduct() {
        return new Menu("Remove Product", this) {
            @Override
            public void show() {
                System.out.println("Remove Product: ");
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
    private Menu showCategories() {
        return new Menu("Show Categories", this) {
            @Override
            public void show() {
                System.out.println("Show Categories: ");
            }

            @Override
            public void execute() {
                //send to controller
                //TODO
            }
        };
    }

    private Menu viewBalance() {
        return new Menu("View Balance", this) {
            @Override
            public void show() {
                System.out.println("View Balance: ");
            }

            @Override
            public void execute() {
                //send to controller
                //TODO
            }
        };
    }

    public static class ViewOffs extends Menu {
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
            if (chosenMenu == 1) {
                viewOffWithId().show();
                viewOffWithId().execute();
            }
            if (chosenMenu == 2) {
                editOff().show();
                editOff().execute();
            }
            if (chosenMenu == 3) {
                addOff().show();
                addOff().execute();
            }
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
}
