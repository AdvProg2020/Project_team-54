package main.java.controller;

import main.java.model.Account;
import main.java.model.Category;
import main.java.model.Filter;

import java.util.ArrayList;

public class ProductsManager extends Manager {
    private Category thisCategory;

    public ProductsManager(Account account, Category category) {
        super(account);
        this.thisCategory = category;
    }

    public ArrayList<String> viewProductsWithId(String id) {
        //TODO
        ArrayList<String> sample = new ArrayList<String>();
        return sample;
    }

    public void addFilter(Filter filter) {
        //TODO
    }

    public void removeFilter(Filter filter) {
        //TODO
    }

    public ArrayList<Filter> allFilter() {
        //TODO
        return null;
    }

    public String showFilters() {
        //TODO
        String sample = null;
        return sample;
    }

    public void viewCategory() {
        //TODO
    }

    public ArrayList<String> curFilter() {
        //TODO
        ArrayList<String> sample = new ArrayList<String>();
        return sample;
    }



}
