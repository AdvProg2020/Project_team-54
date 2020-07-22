package controller;

import ScenesAndControllers.AlertBox;
import ScenesAndControllers.Manager;
import model.*;
import model.Requests.*;

import java.util.ArrayList;
import java.util.Date;

public class SellerManager extends Manager {

    public Seller seller;

    public SellerManager(Seller account) {
        super(account);
        this.seller = account;
    }

    public void addOff(int id, ArrayList<Good> products, String startTime, String endTime, int discount) {
        RequestOff requestOff = new RequestOff((Seller) Manager.loggedInAccount,id,products,startTime,endTime,discount);
        Request.getAllRequests().add(requestOff);
        seller.getAllRequests().add(requestOff);
    }

    private Off findOffById(int id) {
        for (Off off : this.seller.allOffs) {
            if (off.getId() == id)
                return off;
        }
        AlertBox.display("There is no off with this id");
        return null;
    }

    // in method ha age id eshtebah begiran -1 barmigardoonan age kar anjam beshe 0 barmigardoonan


    //***** OFF EDIT ******
    public int editOffEndTime(int id, String newEndTime) {
        Off off = findOffById(id);
        if (off == null) {
            AlertBox.display("There is no off with this id");
            return -1;
        } else {
            off.endTime = newEndTime;
            return 0;
        }
    }

    public int editOffDiscountAmount(int id, int newDiscount) {
        Off off = findOffById(id);
        if (off == null) {
            return -1;
        } else {
            off.discount = newDiscount;
            return 0;
        }
    }

    public void editOffProductList(int id, ArrayList<Good> newProductList) {
        Off off = findOffById(id);
        if (off == null) {
            AlertBox.display("There is no Off with this id");
        } else {
            off.products = newProductList;
            //requestesh
        }
    }

    public void addProductToSalesList(Off off, Good good) throws Exception {
        off.addGoodToOff(good);
    }

    //***** PRODUCT EDIT ******
    public void editProductPrice(int id, double newPrice) {
        Good product = getProductWithId(id);
        if (product == null) {
            AlertBox.display("There is no product with this id");
        } else {
            RequestEditProduct requestEditProduct = new RequestEditProduct(product,seller.getUsername(),"price",Double.toString(newPrice));
            seller.getAllRequests().add(requestEditProduct);
            Request.getAllRequests().add(requestEditProduct);
            AlertBox.display("Request sent.");
        }
    }

    public void editProductName(int id, String newName) {
        Good product = getProductWithId(id);
        if (product == null) {
            AlertBox.display("There is no product with this id");
        } else {
            RequestEditProduct requestEditProduct = new RequestEditProduct(product, seller.getUsername(), "name", newName);
            seller.getAllRequests().add(requestEditProduct);
            Request.getAllRequests().add(requestEditProduct);
            AlertBox.display("Request sent.");
        }
    }

    public void editProductInventoryStatus(int id, boolean newStatus) {
        Good product = getProductWithId(id);
        if (product == null) {
            AlertBox.display("There is no good with this id");
        } else {
            product.setInventoryStatus(newStatus);
            AlertBox.display("Edited successfully");
        }
    }

    public void editProductDescription(int id, String newDescription) {
        Good product = getProductWithId(id);
        if (product == null) {
            AlertBox.display("There is no product with this id");
        } else {
            RequestEditProduct requestEditProduct = new RequestEditProduct(product, seller.getUsername(), "description", newDescription);
            Request.getAllRequests().add(requestEditProduct);
            seller.getAllRequests().add(requestEditProduct);
            AlertBox.display("Request sent.");
        }
    }

    public void addAuction(int goodID,String endTime){
        Good good = getProductWithId(goodID);
        if(good.isInAuction()){
            AlertBox.display("This good is already on sale");
        }else {
            new Auction(seller.getUsername(),goodID,endTime);
        }
    }

    //***** MISC ******
    private Good getProductWithId (int id) {
        for (Good product : this.seller.getAllProducts()) {
            if (product.getId() == id)
                return product;
        }
        AlertBox.display("There is no product with this id");
        return null;
    }

    public void removeProduct(int productId) {
        Good removingProduct = getProductWithId(productId);
        if(removingProduct == null)
            AlertBox.display("There is no product with this id");
        else {
            Good.getAllProducts().remove(removingProduct);
        }
    }

    public ArrayList<String> showSalesHistories(Account seller) {
        //TODO
        return null;
    }

    public ArrayList<Off> showOffs(String brand) {
        return Off.getAllOffs();
    }

}
