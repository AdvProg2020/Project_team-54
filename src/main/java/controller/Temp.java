package controller;

import controller.*;
import model.Account;
import model.Role;

public class Temp {

    public void tempRegister(String userName, String password, String firstName,
                             String lastName, String eMail, String phoneNumber, String companyName, String role) throws Exception{
        Account tempAccount = null;
        if (role.equalsIgnoreCase("manager")) {
            tempAccount = new Account(userName, firstName, lastName, phoneNumber, eMail, password, Role.administrator);
        } else if (role.equalsIgnoreCase("buyer")) {
            tempAccount = new Account(userName, firstName, lastName, phoneNumber, eMail, password, Role.buyer);
        } else if (role.equalsIgnoreCase("seller")) {
            tempAccount = new Account(userName, firstName, lastName, phoneNumber, eMail, password, Role.seller);
        }

        Manager manager = new Manager(tempAccount);
        manager.register(userName,password,firstName,lastName,eMail,phoneNumber, companyName, role);

    }

    public Account tempLogin(String username, String password) throws Exception{

        Manager manager = new Manager();
        Account account;
        account = manager.login(username,password);
        return account;

    }

}
