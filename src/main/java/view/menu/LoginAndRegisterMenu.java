package view.menu;

import com.google.gson.Gson;
import controller.Temp;
import model.Account;
import model.Role;
import view.ReadAndWriteFromFile;
import view.menu.buyerAccount.BuyerAccount;
import view.menu.managerAccount.ManagerAccount;
import view.menu.sellerAccount.SellerAccount;


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
                    Temp temp = new Temp();
                    if (input.equalsIgnoreCase("seller")) {
                        System.out.print("Enter name of company: ");
                        String companyName = scanner.nextLine();
                        try {
                            temp.tempRegister(userName, password, name, familyName, eMail, phoneNumber, companyName, input);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (input.equalsIgnoreCase("manager") || input.equalsIgnoreCase("buyer")){
                        try {
                            temp.tempRegister(userName, password, name, familyName, eMail, phoneNumber, null, input);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("role is incorrect !!! try it again please");
                    }

                    this.parentMenu.show();
                    this.parentMenu.execute();
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
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    Temp temp = new Temp();
                    Account thisAccount = null;
                    try {
                        thisAccount = temp.tempLogin(userName, password);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (thisAccount == null) {
                        System.out.println("user with this userName has not registered!!");
                        this.parentMenu.show();
                        this.parentMenu.execute();
                    }
                    //RECEIVE THIS ACCOUNT
                    else if (thisAccount.getRole().equals(Role.buyer)) {
                        BuyerAccount buyerAccount = new BuyerAccount(this, thisAccount);
                        buyerAccount.show();
                        buyerAccount.execute();
                    } else if (thisAccount.getRole().equals(Role.seller)) {
                        SellerAccount sellerAccount = new SellerAccount(this);
                        sellerAccount.show();
                        sellerAccount.execute();
                    } else if (thisAccount.getRole().equals(Role.administrator)) {
                        ManagerAccount managerAccount = new ManagerAccount(this);
                        managerAccount.show();
                        managerAccount.execute();
                    }

                }
            }
        };
    }
}
