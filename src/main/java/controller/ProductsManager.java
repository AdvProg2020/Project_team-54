package main.java.controller;

import main.java.model.Account;
import main.java.model.Category;
import main.java.model.Filter;
import main.java.model.Good;
import java.util.ArrayList;

import static main.java.model.Products.allProducts;

public class ProductsManager extends Manager {
    private Category thisCategory;
    private ArrayList<Filter> allFilters;
    public ProductsManager(Account account, Category category) {
        super(account);
        this.allFilters = new ArrayList<>();
        this.thisCategory = category;
    }

    public Good viewProductsWithId(String id) {
        for (Good good:
             allProducts) {
            if (good.getId().equals(id))
                return good;
        }
        return null;
    }

    public void addFilter(Filter filter) {
        this.allFilters.add(filter);
    }

    public void removeFilter(Filter filter) {
        this.allFilters.remove(filter);
    }

    public ArrayList<Filter> getAllFilter() {
        return allFilters;
    }

    public String showFilters() {
        String filters = "filters: ";
        for (Filter filter : allFilters) {
            filters = filters.concat(filter.getField());
        }
        return filters;
    }

    public void viewCategory() {
        System.out.println(thisCategory.name);
    }

    public ArrayList<String> curFilter() {
        ArrayList<String> filterNames = new ArrayList<>();
        for (Filter filter :
                allFilters) {
            filterNames.add(filter.getField());
        }
        return filterNames;
    }



}
