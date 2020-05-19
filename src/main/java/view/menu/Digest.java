package view.menu;

public class Digest extends Menu {
    public Digest(Menu parentMenu) {
        super("Digest", parentMenu);
        submenus.put(1, addToCart());
        submenus.put(2, selectSeller());
        this.setSubmenus(submenus);
    }

    @Override
    public void execute() {
        digest();
        int chosenMenu = Integer.parseInt(scanner.nextLine());
        if (chosenMenu == 1) {
            addToCart().show();
            addToCart().execute();
        }
        if (chosenMenu == 2) {
            selectSeller().show();
            selectSeller().execute();
        }
    }

    private void digest() {
        //send to controller
        //TODO
    }

    private Menu addToCart() {
        return new Menu("Add To Cart", this) {
            @Override
            public void show() {
                System.out.println("Add To Cart: ");
            }

            @Override
            public void execute() {
                //send to controller
                //TODO
            }
        };
    }

    private Menu selectSeller() {
        return new Menu("Select Seller", this) {
            @Override
            public void show() {
                System.out.println("Select Seller: ");
                System.out.println("Enter seller username or back to return: ");
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
