package controller;

import ScenesAndControllers.AlertBox;
import ScenesAndControllers.Manager;
import model.*;
import model.Requests.Request;
import model.Requests.RequestAddProduct;
import model.Requests.RequestEditProduct;
import model.Requests.RequestOff;

import java.util.ArrayList;
import java.util.Date;

public class SellerManager extends Manager {

    public Seller seller;

    public SellerManager(Seller account) {
        super(account);
        this.seller = account;
    }

    public void addOff(int id, ArrayList<Good> products, Date startTime, Date endTime, int discount) {
        RequestOff requestOff = new RequestOff(id,products,startTime,endTime,discount);

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

    public int editOffEndTime(int id, Date newEndTime) {
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
            //dige Request nemire, na?
        }
    }

    public void addProductToSalesList(String name, String brand, Account seller, Category category, String description, double price) {
        this.seller.allRequests.add(new RequestAddProduct(this.seller, category, name, price, description));
    }

    public void editProductPrice(int id, double newPrice) {
        Good product = getProductWithId(id);
        if (product == null) {
            AlertBox.display("There is no product with this id");
//            return -1;
        } else {
            RequestEditProduct requestEditProduct = new RequestEditProduct(product,seller.getUsername(),"price",Double.toString(newPrice));
//            product.setPrice(newPrice);
            AlertBox.display("Request sent.");
//            return 0;
        }
    }

    public void editProductName(int id, String newName) {
        Good product = getProductWithId(id);
        if (product == null) {
            AlertBox.display("There is no product with this id");
//            return -1;
        } else {
            RequestEditProduct requestEditProduct = new RequestEditProduct(product, seller.getUsername(), "name", newName);
//            product.setName(newName);
            AlertBox.display("Request sent.");
//            return 0;
        }
    }

    public void editProductInventoryStatus(int id, boolean newStatus) {
        Good product = getProductWithId(id);
        if (product == null) {
            AlertBox.display("There is no good with this id");
//            return -1;
        } else {
            product.setInventoryStatus(newStatus);
            AlertBox.display("Edited successfully");
//            return 0;
        }
    }

    public void editProductDescription(int id, String newDescription) {
        Good product = getProductWithId(id);
        if (product == null) {
            AlertBox.display("There is no product with this id");
        } else {
//            RequestEditProduct requestEditProduct = new RequestEditProduct(product, seller.getUsername(), "description", newDescription);
            product.setDescription(newDescription);
            AlertBox.display("Edited successfully");
//            AlertBox.display("Request sent.");
        }
    }

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
//        this.seller.removeProduct(productId);
    }

    public ArrayList<String> showSalesHistories(Account seller) {
        //TODO
        return null;
    }

    public ArrayList<Off> showOffs(String brand) {
        return Off.getAllOffs();
    }

}
