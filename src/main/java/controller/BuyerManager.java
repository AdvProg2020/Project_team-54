package controller;

//import com.sun.org.apache.bcel.internal.generic.RET;

import model.Account;
import model.Good;
import model.*;

import java.security.PublicKey;
import java.util.ArrayList;

public class BuyerManager extends Manager {

    private Buyer buyer;

    public BuyerManager(Buyer account) {
        super(account);
        this.buyer = account;
    }

    public void addToCart(Good product) {
        this.buyer.addProductToCart(product);
    }

    public ArrayList<Good> showCart() {
        return this.buyer.viewCart();
    }

    public void removeProductInCart(Good product) {
        this.buyer.removeProductFromCart(product);
    }

    public void setScore(Good product, double score) {
        product.addScore(score);
    }

    public void buyAndPay(Account buyer, ArrayList<String> productsId, String discountCode) {
        //TODO
    }

    public boolean canPay(double price) {
        return this.buyer.getBalance() >= price;
    }

    public void deduceAmountOfCredit() {
        //TODO
    }

    public ArrayList<String> showDiscountCodes() {
        //TODO
        return null;
    }
}
