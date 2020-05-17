package view.menu;

import com.sun.media.sound.SF2InstrumentRegion;
import controller.*;
import controller.Manager;
import java.util.HashMap;

public class LoginAndRegisterMenu extends Menu {

    public LoginAndRegisterMenu(Menu parentMenu) {
        super("Login And Register Menu", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<Integer, Menu>();
        submenus.put(1, register());
        submenus.put(2, login());
        this.setSubmenus(submenus);
    }

    public Menu register() {
        return new Menu("Create Account", this) {
            public void show() {
                System.out.println("Create Account");
                System.out.println("Enter type of your account(Buyer|Seller|Manager) or back to return: ");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                } else {
                    System.out.print("Enter userName: ");
                    String userName = scanner.nextLine();
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
//                    String role = "role";
                    if (input.equalsIgnoreCase("seller")) {
                        System.out.print("Enter name of company: ");
                        String companyName = scanner.nextLine();
                    }

                    Temp temp = new Temp();
                    try {
                        temp.tempRegister(userName, password, name,
                                 familyName,eMail, phoneNumber, input);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
//                    Temp temp = new Temp(userName,password,name, familyName, eMail, phoneNumber,role);
//                    manager.register(userName,password,name,familyName,eMail,phoneNumber,role);

                    //send to controller
                    // TODO
                    this.show();
                    this.execute();
                }
            }
        };
    }
    public Menu login() {
        return new Menu("Login", this) {
            public void show() {
                System.out.println("Login: ");
                System.out.println("Enter submit information or back to return: ");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                } else {
                    System.out.print("Enter userName: ");
                    String userName = scanner.nextLine();
                    System.out.println("Enter password: ");
                    String password = scanner.nextLine();

                    //send information
                    // TODO
                    this.show();
                    this.execute();
                }
            }
        };
    }
}
