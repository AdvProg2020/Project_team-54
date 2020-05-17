package view.menu;

public class Sorting extends Menu {
    public Sorting(Menu parentMenu) {
        super("Sorting", parentMenu);
        submenus.put(1, showAvailableSorts());
        submenus.put(2, sort());
        submenus.put(3, currentSort());
        submenus.put(4, disableSort());
        this.setSubmenus(submenus);
    }

    @Override
    public void execute() {
        int chosenMenu = Integer.parseInt(scanner.nextLine());
        Menu nextMenu;
        if (chosenMenu == 1)
            showAvailableSorts();
        if (chosenMenu == 2)
            sort();
        if (chosenMenu == 3)
            currentSort();
        if (chosenMenu == 4)
            disableSort();
        nextMenu = this.parentMenu;
        nextMenu.show();
        nextMenu.execute();
    }

    private Menu showAvailableSorts() {
        return new Menu("Show Available Sorts", this) {
            @Override
            public void show() {
                System.out.println("Show Available Sorts: ");
            }

            @Override
            public void execute() {
                //send to controller
                //TODO
            }
        };
    }

    private Menu sort() {
        return new Menu("Sort", this) {
            @Override
            public void show() {
                System.out.println("Sort An Available Sort: ");
                System.out.println("Enter target filter or back to return: ");
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

    private Menu currentSort() {
        return new Menu("Current Sort", this) {
            @Override
            public void show() {
                System.out.println("Current Sort: ");
            }

            @Override
            public void execute() {
                //send to controller
                //TODO
            }
        };
    }

    private Menu disableSort() {
        return new Menu("Disable Sort", this) {
            @Override
            public void show() {
                System.out.println("Disable Sort: ");
            }

            @Override
            public void execute() {
                //send to controller
                //TODO
            }
        };
    }
}
