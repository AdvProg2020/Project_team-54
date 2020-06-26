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

    public ArrayList showFilters(String type, ArrayList<String> information) {
        if (type.equalsIgnoreCase("brand")) {
            String brand = information.get(0);
            return Good.getProductsWithBrand(brand);
        } else if (type.equalsIgnoreCase("seller")) {
            String sellerUserName = information.get(0);
            return Good.getProductWithSeller(sellerUserName);
        } else if (type.equalsIgnoreCase("inventoryStatus")) {
            return Good.getAllProducts();
        } else if (type.equalsIgnoreCase("price")) {
            String minPrice = information.get(0);
            String maxPrice = information.get(1);
            return Good.getProductWithPrice(Double.parseDouble(minPrice), Double.parseDouble(maxPrice));
        }

//        String filters = "filters: ";
//        for (Filter filter : allFilters) {
//            filters = filters.concat(filter.getField());
//        }
//        return filters;
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
