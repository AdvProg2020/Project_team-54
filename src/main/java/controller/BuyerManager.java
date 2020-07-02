package controller;

//import com.sun.org.apache.bcel.internal.generic.RET;

import ScenesAndControllers.AlertBox;
import ScenesAndControllers.Manager;
import javafx.scene.control.Alert;
import model.Account;
import model.Good;
import model.*;
import model.Requests.Request;
import model.Requests.RequestAddComment;
import model.Buyer;
import model.BuyLog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class BuyerManager extends Manager {

    private Buyer buyer;

    public BuyerManager(Buyer account) {
        super(account);
        this.buyer = account;
    }

    //***** CART ******
    public static void addProductToCart(Buyer buyer, Good product) {
        if(!product.isInInventory())
            AlertBox.display("Not in Store");
        else {
            buyer.getProductsInCart().add(product);
            buyer.getCart().put(product, 1);
        }
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

    public ArrayList<Good> showCart() {
        return buyer.getProductsInCart();
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

    public double cartPrice(){
        double price = 0;
        for (Good good:buyer.getCart().keySet()) {
            int number = buyer.getCart().get(good);
            if(good.isInOff){
                Off off = Off.getOffById(good.getOffId());
                price += number * (good.getPrice() * (1-(off.getOffAmount()/100)));
            }else {
                price += number * good.getPrice();
            }
        }
        return price;
    }


    //****** PAY AND STUFF ******
    public void setScore(Good good, double score) {
        for (BuyLog buyLog : buyer.getBuyLog()) {
            if(buyLog.getProductsList().contains(good)){
                good.addScore(score);
            }
        }
    }

    public void buy(Buyer buyer, HashMap<Good,Integer> cart, String discountCode) {
        double price = calculateDiscountPrice(discountCode);
        if (this.canPay(price)) {
            deduceAmountOfCredit(price);
            BuyLog buyLog = new BuyLog(price, cart, buyer.getUsername(), cartPrice() - price);
            buyer.getBuyLog().add(buyLog);
        } else
            AlertBox.display("not enough money in account");
    }

    public double calculateDiscountPrice(String discountCode) {
//        Double sumPrice = 0.00;
//        for (int i = 0; i < productsId.size(); i++) {
//            sumPrice += Good.getProductById(Integer.parseInt(productsId.get(i))).getPrice();
//        }
        double price = cartPrice();
        if (DiscountCode.getDiscountCodeWithCode(discountCode) != null && this.buyer.getAllDiscountCodes().contains(DiscountCode.getDiscountCodeWithCode(discountCode))) {
            if (DiscountCode.getDiscountCodeWithCode(discountCode).getMaxAmount() > (1 - (DiscountCode.getDiscountCodeWithCode(discountCode).getPercentage() / 100)) * price) {
                price -= (DiscountCode.getDiscountCodeWithCode(discountCode).getPercentage() / 100) * price;
            } else {
                price -= DiscountCode.getDiscountCodeWithCode(discountCode).getMaxAmount();
            }
        } else
            AlertBox.display("you dont have this Discount Code");
        return price;
    }

    public boolean canPay(double price) {
        return this.buyer.getBalance() >= price;
    }

    public void deduceAmountOfCredit(double price) {
        this.buyer.setBalance(buyer.getBalance() - price);
    }

    public void commentForGood(Good good, String comment){
        for (BuyLog buyLog : buyer.getBuyLog()) {
            if(buyLog.getProductsList().contains(good)){
                RequestAddComment request = new RequestAddComment(comment,buyer,good);
                Request.getAllRequests().add(request);
            }
        }
    }

    //***** MISC *****
    private ArrayList<DiscountCode> viewDiscountCodes(){
        return buyer.getAllDiscountCodes();
    }

    public BuyLog getBuyLogById(int id){
        for (BuyLog buylog:BuyLog.getAllBuyLogs()) {
            if(buylog.giveId()==id)
                return buylog;

        }
        AlertBox.display("No BuyLog Found!");
        return null;
    }
}
