package model;

import java.util.ArrayList;
import java.util.Date;

public class CodedDiscount {
    private String discountCode;
    private Date startTime;
    private Date endTime;
    private double discountPercent;
    private double maxDiscount;
    private int repeatedTime;
    private ArrayList<Account> validAccounts;
}
