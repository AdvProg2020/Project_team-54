package controller;

import model.Good;

import java.security.PublicKey;
import java.util.ArrayList;

public class ProductManager extends Manager{
    private Good product;

    public ProductManager(Good product) {
        //super();
        this.product = product;
    }

    public void postComment(String id, String comment) {
        //TODO
    }

    public ArrayList<String> compare(String productId1, String productId2) {
        //TODO
        ArrayList<String> sample = new ArrayList<String>();
        return sample;
    }

    public ArrayList<String> showComments(String id) {
        //TODO
        return null;
    }




}
