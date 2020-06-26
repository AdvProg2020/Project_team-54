package model.Requests;

import model.Good;

public class RequestEditProduct extends Request {
    private Good good;
    private String name;
    private String field;
    private String newInformation;
    private String sellerName;


    public RequestEditProduct(Good good, String sellerName, String field, String newInformation){
        super();
        this.good = good;
        this.sellerName = sellerName;
        if(field.equalsIgnoreCase("name"))
            this.field = field;
        else if(field.equalsIgnoreCase("price"))
            this.field = field;
//        else if(field.equalsIgnoreCase("description"))
//            this.field = field;
        this.newInformation = newInformation;
    }




}
