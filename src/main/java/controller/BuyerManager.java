package controller;

//import com.sun.org.apache.bcel.internal.generic.RET;

import model.Account;
import model.Good;
import model.*;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;

public class BuyerManager extends Manager {

    private Buyer buyer;

    public BuyerManager(Buyer account) {
        super(account);
        this.buyer = account;
    }

    public void addProductToCart(Good product) {
        buyer.getCart().put(product,0);
    }

    public HashMap<Good, Integer> showProductsOfCart() {
        return buyer.getCart();
    }

    public void removeProductFromCart(Good product) {
        buyer.getCart().remove(product);
    }

    public HashMap<Good,Integer> viewCart() {
        //vaghti ke show products vared mishe
        return buyer.viewCart();
    }

    public void increaseProductInCart(int productId){
        Good good = Good.getProductById(productId);
        int number = buyer.getCart().get(good);
        number++;
        buyer.getCart().put(good,number);
    }

    public void decreaseProductInCart(int productId){
        Good good = Good.getProductById(productId);
        int number = buyer.getCart().get(good);
        number--;
        if(number>0)
            buyer.getCart().put(good,number);
        else
            buyer.getCart().remove(good);
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
