package model;
import java.util.ArrayList;

public class Category {
    private String name;
    private Category parentCategory;
    private ArrayList<Category> subCategories = new ArrayList<>();
    private ArrayList<Good> goods = new ArrayList<>();
    private ArrayList<String> specialFeature = new ArrayList<>();
    public static ArrayList<Category> allCategories = new ArrayList<>();

    public Category(String name, Category parentCategory) {
        this.name = name;
        if (parentCategory != null)
            this.parentCategory = parentCategory;
        allCategories.add(this);
    }

    public Category(String name, ArrayList<String> allFeatures, Category parentCategory){
        this.name = name;
        this.parentCategory = parentCategory;
        this.specialFeature = allFeatures;
        allCategories.add(this);
    }

    public void setSpecialFeature(ArrayList<String> specialFeature){
        this.specialFeature = specialFeature;
    }

    public void addFeature(String feature){
        //TODO
    }

    public void addGoodToCategory(Good good){
        goods.add(good);
        if(parentCategory != null){
            parentCategory.addGoodToCategory(good);
        }
    }

    public Category addSubCategory(String name){
        Category subCategory = new Category(name, this);
        for (String feature : specialFeature){
            subCategory.addFeature(feature);
        }
        subCategories.add(subCategory);
        return subCategory;
    }

    public static void setAllCategories(ArrayList<Category> allCategories) {
        Category.allCategories = allCategories;
    }

    public static ArrayList<Category> getAllCategories(){
        return allCategories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public ArrayList<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(ArrayList<Category> subCategories) {
        this.subCategories = subCategories;
    }

    public ArrayList<Good> getGoods() {
        return goods;
    }

    public void setGoods(ArrayList<Good> goods) {
        this.goods = goods;
    }

    public static Category getCategoryWithName(String name){
        for (Category category : allCategories){
            if (category.getName().equals(name))
                return category;
        }
        return null;
    }

    public static void removeCategory(Category category){
        allCategories.remove(category);
    }

    public static boolean isThereCategoryWithName(String name){
        for(Category category:getAllCategories()){
            if(category.getName().equals(name))
                return true;
        }
        return false;
    }

}
