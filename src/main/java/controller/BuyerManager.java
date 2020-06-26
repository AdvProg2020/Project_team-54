package controller;

//import com.sun.org.apache.bcel.internal.generic.RET;

import ScenesAndControllers.Manager;
import model.Account;
import model.Good;
import model.*;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyerManager extends Manager {

    private Buyer buyer;

    public BuyerManager(Buyer account) {
        super(account);
        this.buyer = account;
    }

    //***** CART ******
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

    //****** PAY AND STUFF ******
    public void setScore(Good product, double score) {
        product.addScore(score);
    }

    public Double buyAndPay(Account buyer, ArrayList<String> productsId, String discountCode) {
        Double sumPrice = 0.00;
        for (int i = 0; i < productsId.size(); i++) {
            sumPrice += Good.getProductById(Integer.parseInt(productsId.get(i))).getPrice();
        }
        if (DiscountCode.getDiscountCodeWithCode(discountCode).getMaxAmount() > DiscountCode.getDiscountCodeWithCode(discountCode).getPercentage() / 100 * sumPrice) {
            sumPrice -= DiscountCode.getDiscountCodeWithCode(discountCode).getPercentage() / 100 * sumPrice;
        } else {
            sumPrice -= DiscountCode.getDiscountCodeWithCode(discountCode).getMaxAmount();
        }
        return sumPrice;
    }

    public boolean canPay(double price) {
        return this.buyer.getBalance() >= price;
    }

    public void deduceAmountOfCredit() {
        //TODO
    }

    //***** MISC *****
    public ArrayList<String> showDiscountCodes() {
        //TODO
        return null;
    }
}
