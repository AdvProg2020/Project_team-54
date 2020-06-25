package controller;

import ScenesAndControllers.Manager;
import model.*;
import model.Requests.RequestAddProduct;
import java.util.ArrayList;
import java.util.Date;

public class SellerManager extends Manager {

    public Seller seller;

    public SellerManager(Seller account) {
        super(account);
        this.seller = account;
    }

    public void addOff(int id, ArrayList<Good> products, Date startTime, Date endTime, int discount) {
        this.seller.allOffs.add(new Off(id, products, startTime, endTime, discount));
    }

    private Off findOffById(int id) {
        for (Off off : this.seller.allOffs) {
            if (off.getId() == id)
                return off;
        }
        return null;
    }

    // in method ha age id eshtebah begiran -1 barmigardoonan age kar anjam beshe 0 barmigardoonan

    public int editOffEndTime(int id, Date newEndTime) {
        Off off = findOffById(id);
        if (off == null) {
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

    public int editOffProductList(int id, ArrayList<Good> newProductList) {
        Off off = findOffById(id);
        if (off == null) {
            return -1;
        } else {
            off.products = newProductList;
            return 0;
        }
    }

    public void addProductToSalesList(String name, String brand, Account seller, Category category, String description, double price) {
        this.seller.allRequests.add(new RequestAddProduct(this.seller, category, name, price, description));
    }

    public int editProductPrice(int id, double newPrice) {
        Good product = getProductWithId(id);
        if (product == null) {
            return -1;
        } else {
            product.setPrice(newPrice);
            return 0;
        }
    }

    public int editProductName(int id, String newName) {
        Good product = getProductWithId(id);
        if (product == null) {
            return -1;
        } else {
            product.setName(newName);
            return 0;
        }
    }

    public int editProductInventoryStatus(int id, boolean newStatus) {
        Good product = getProductWithId(id);
        if (product == null) {
            return -1;
        } else {
            product.setInventoryStatus(newStatus);
            return 0;
        }
    }

    public int editProductDescription(int id, String newDescription) {
        Good product = getProductWithId(id);
        if (product == null) {
            return -1;
        } else {
            product.setDescription(newDescription);
            return 0;
        }
    }

    private Good getProductWithId (int id) {
        for (Good product : this.seller.getAllProducts()) {
            if (product.getId() == id)
                return product;
        }
        return null;
    }

    public void removeProduct(int productId) {
        this.seller.removeProduct(productId);
    }

    public ArrayList<String> showSalesHistories(Account seller) {
        //TODO
        return null;
    }

    public void showOffs(String brand) {
        //TODO
    }

}
