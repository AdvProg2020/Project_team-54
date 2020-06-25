package controller;

import ScenesAndControllers.Manager;
import model.Account;
import model.Category;
import model.Filter;
import model.Good;
import java.util.ArrayList;

import static model.Products.allProducts;

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
            if (good.getId() == Integer.parseInt(id))
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

    public static ArrayList<Category> viewCategory() {
        return Category.getAllCategories();
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
