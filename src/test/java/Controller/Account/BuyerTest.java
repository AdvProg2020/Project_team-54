package Controller.Account;

import model.Buyer;
import model.Role;
import org.junit.Assert;
import org.junit.Test;

public class BuyerTest {
    Buyer buyer = new Buyer("username","name","lastName",
            "email@gmail.com","0987654321","password", Role.buyer);

    @Test
    public void details(){
        String details="";
        details += "Username: " + "username" + "\n";
        details += "Full Name: " + "name" + " " + "lastName" + "\n";
        details += "Email: " + "email@gmail.com" + "\n";
        details += "Telephone Number: " + "0987654321" + "\n";
        details += "Role: " + Role.buyer + "\n";
        details += "Balance: " + 100 + "\n";

        Assert.assertEquals(buyer.details(),details);
    }

    @Test
    public void setBalanceTest(){
        buyer.setBalance(0);
        int value = (int)buyer.getBalance();

        Assert.assertEquals(value,0);
    }

}
