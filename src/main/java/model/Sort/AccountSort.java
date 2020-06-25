package model.Sort;

import model.Account;

import java.util.ArrayList;
import java.util.Comparator;

public enum AccountSort {
    ALPHABETICALLY;

    public static void sort(String sortBy, ArrayList<Account> accounts){
        if(sortBy.equalsIgnoreCase(AccountSort.ALPHABETICALLY.name()))
            accounts.sort(Comparator.comparing(Account::getUsername));
    }
}
