package model.Sort;

import model.Good;

import java.util.ArrayList;
import java.util.Comparator;

public enum ProductSort {
    ALPHABETICALLY, PRICE, SCORE;

    public static void sort(String sortBy, ArrayList<Good> products){
        if(sortBy.equalsIgnoreCase(ProductSort.ALPHABETICALLY.name()))
            products.sort(Comparator.comparing(Good::getName));
        if(sortBy.equalsIgnoreCase(ProductSort.PRICE.name()))
              products.sort(Comparator.comparingDouble(Good::getPrice));
        if(sortBy.equalsIgnoreCase(ProductSort.SCORE.name()))
            products.sort(Comparator.comparingDouble(Good::getAverageScore));
    }

}
