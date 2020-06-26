package model.Requests;

import ScenesAndControllers.AlertBox;
import model.Good;

public class RequestEditProduct extends Request {
    private String requestType = "EditProduct";
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

    @Override
    public void acceptRequest(int id) {
        super.acceptRequest(id);
        if(field.equalsIgnoreCase("name"))
            good.setName(newInformation);
        else if(field.equalsIgnoreCase("price"))
            good.setPrice(Double.parseDouble(newInformation));

        AlertBox.display("Request accepted");
    }

    @Override
    public void denyRequest() {
        status = RequestConfirmation.Denied;
        Request.getAllRequests().remove(this);
        AlertBox.display("Request denied");
    }

    public String getRequestType() {
        return requestType;
    }

    public Good getGood() {
        return good;
    }

    public String getField() {
        return field;
    }

    public String getNewInformation() {
        return newInformation;
    }

    public String getSellerName() {
        return sellerName;
    }

    @Override
    public String toString() {
        return "Edit Product Request:\n" +
                "Request ID: " + this.getId() + "\n" +
                "Product ID: " + good.getId() + "\n" +
                "Product Name: " + good.getName() + "\n" +
                "Product Brand: " + good.getBrand() + "\n" +
                "Editing: " + field;
    }
}
