package controller;

import controller.*;
import model.Account;
import model.Role;

public class Temp {

    public void tempRegister(String userName, String password, String firstName,
                             String lastName, String eMail, String phoneNumber, String role) throws Exception{
//        if(role.equalsIgnoreCase("administrator")){
//
//        }
//            else if (role.equalsIgnoreCase("buyer")) {
//        }
//            else if(role.equalsIgnoreCase("seller")){
//
//        }

        Account tempAccount = new Account("tempUsername","tempName","tempLastName",
                "tempPhoneNumber","tempEmail","tempPassword", Role.buyer);
        Manager manager = new Manager(tempAccount);
        manager.register(userName,password,firstName,lastName,eMail,phoneNumber,role);

    }

    public void tempLogin(String username, String password) throws Exception{
        Account tempAccount = new Account("tempUsername","tempName","tempLastName",
                "tempPhoneNumber","tempEmail","tempPassword", Role.buyer);
        Manager manager = new Manager(tempAccount);
        manager.login(username,password);


    }

}
