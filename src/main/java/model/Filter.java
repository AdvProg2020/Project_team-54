package model;

import java.util.ArrayList;

public class Filter {
    private static ArrayList<Filter> allFilters = new ArrayList<>();
    private String field;
    private String value;

    public Filter(String field, String value) {
        allFilters.add(this);
        this.field = field;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public String getValue() {
        return value;
    }
}