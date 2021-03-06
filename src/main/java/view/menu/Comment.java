package view.menu;

public class Comment extends Menu {
    public Comment(Menu parentMenu) {
        super("Comment", parentMenu);
        submenus.put(1, addComment());
        this.setSubmenus(submenus);
    }

    @Override
    public void execute() {
        comment();
        int chosenMenu = Integer.parseInt(scanner.nextLine());
        if (chosenMenu == 1) {
            addComment().show();
            addComment().execute();
        }
    }

    private void comment() {
        //send to main.java.controller
    }

    private Menu addComment() {
        return new Menu("Add Comment", this) {
            @Override
            public void show() {
                System.out.println("Add Comment: ");
                System.out.println("Enter title or back to return: ");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                } else {
                    System.out.println("Enter content: ");
                    String content = scanner.nextLine();
                    //send to main.java.controller
                    //TODO
                }
            }
        };
    }
}
