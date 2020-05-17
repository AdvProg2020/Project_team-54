package controller;

//import com.sun.org.apache.bcel.internal.generic.RET;
import model.Account;
import model.Good;

import java.security.PublicKey;
import java.util.ArrayList;

public class BuyerManager extends Manager {

    public BuyerManager(Account account) {
        super(account);
    }

    public void addToCart(Account buyer, Good product) {
        //TODO
    }

    public void showCart(Account buyer) {
        //TODO
    }

    public void removeProductInCart(Account buyer, String productId) {
        //TODO
    }

    public Good getProductWithId(String id) {
        return null;
        //TODO
    }

    public void setScore(String id, double score) {
        //TODO
    }

    public void buyAndPay(Account buyer, ArrayList<String> productsId, String discountCode) {
        //TODO
    }

    public boolean canPay(Account buyer, double price) {
        //TODO
        return true;
    }
    public void deduceAmountOfCredit() {
        //TODO
    }

    public ArrayList<String> showDiscountCodes() {
        //TODO
        return null;
    }
}
