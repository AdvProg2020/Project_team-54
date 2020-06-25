package controller;
import ScenesAndControllers.Manager;
import model.Account;
import model.Role;

public class Temp {

    public void tempRegister(String userName, String password, String firstName,
                             String lastName, String eMail, String phoneNumber, String companyName, String role) throws Exception{
//        Account tempAccount;
        Manager manager = new Manager();

        if (role.equalsIgnoreCase("manager")) {
            Account tempAccount = tempAccount = new Account(userName, firstName, lastName, phoneNumber, eMail, password, Role.administrator);
        } else if (role.equalsIgnoreCase("buyer")) {
            manager.register(userName,password,firstName,lastName,eMail,phoneNumber, companyName, role);
//            Account tempAccount = tempAccount = new Account(userName, firstName, lastName, phoneNumber, eMail, password, Role.buyer);
        } else if (role.equalsIgnoreCase("seller")) {
            Account tempAccount = tempAccount = new Account(userName, firstName, lastName, phoneNumber, eMail, password, Role.seller);
        } else {
            return;
        }


//        manager.register(userName,password,firstName,lastName,eMail,phoneNumber, companyName, role);

    }

    public Account tempLogin(String username, String password) throws Exception{

        Manager manager = new Manager();
        Account account;
        account = manager.login(username,password);
        return account;

    }

}
//********************************THIS CLASS IS USELESS************************************
