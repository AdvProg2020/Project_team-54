package model.Requests;

import ScenesAndControllers.AlertBox;
import model.Good;
import model.GoodStatus;

import java.util.ArrayList;

public class RequestEditProduct extends Request {
    private String requestType = "EditProduct";
    private Good good;
    private String name;
    private String field;
    private String newInformation;
    private String sellerName;
    private static ArrayList<RequestEditProduct> allEditProductRequests = new ArrayList<>();


    public RequestEditProduct(Good good, String sellerName, String field, String newInformation){
        super();
        this.good = good;
        this.sellerName = sellerName;
        this.field = field;
        this.newInformation = newInformation;
        allEditProductRequests.add(this);
        good.setGoodStatus(GoodStatus.editing);
    }

    @Override
    public void acceptRequest(int id) {
        this.status = model.Requests.RequestConfirmation.Accepted;
//        super.acceptRequest(id);
        if(field.equalsIgnoreCase("name"))
            good.setName(newInformation);
        else if(field.equalsIgnoreCase("price"))
            good.setPrice(Double.parseDouble(newInformation));
        else if(field.equalsIgnoreCase("description"))
            good.setDescription(newInformation);
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
                "Editing: " + field + "\n" +
                "With New Information: " + newInformation;
    }
}
