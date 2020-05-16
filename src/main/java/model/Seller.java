package model;
import java.util.ArrayList;

public class Seller extends Account {
    private String companyName;
    private ArrayList<Seller> allSellers = new ArrayList<>();
    private ArrayList<SellLog> sellLog;
    private ArrayList<Products> allProducts = new ArrayList<>();
    private ArrayList<Request> allSellersRequests = new ArrayList<>();
    private double credit;

    public Seller(String username, String name, String lastName, String email, String telephonNumber, String password,Role role,String companyName) {
        super(username,name,lastName,telephonNumber,email,password,role);
        this.companyName = companyName;
        allSellers.add(this);
    }

    public ArrayList<Seller> getAllSellers() {
        return allSellers;
    }

    public ArrayList<SellLog> getSellLog() {
        return sellLog;
    }

    public ArrayList<Products> getAllProducts() {
        return allProducts;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    private void viewSalesHistory(){

    }
    private void manageProducts(){

    }

    private void addProduct(Good newProduct){

    }

    private void removeProduct(int productId){

    }

    private void showCategories(){

    }

    private void viewOffs(){

    }

    private void viewBalance(){

    }

    @Override
    public String toString() {
        return "Seller{" +
                "companyName='" + companyName + '\'' +
                ", allSellers=" + allSellers +
                ", sellLog=" + sellLog +
                ", allProducts=" + allProducts +
                ", credit=" + credit +
                '}';
    }
}
