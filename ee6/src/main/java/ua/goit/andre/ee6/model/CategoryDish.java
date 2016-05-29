package ua.goit.andre.ee6.model;

/**
 * Created by Andre on 28.05.2016.
 */
public class CategoryDish {
    private static int id;
    private static String categoryName;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        CategoryDish.id = id;
    }

    public static String getCategoryName() {
        return categoryName;
    }

    public static void setCategoryName(String categoryName) {
        CategoryDish.categoryName = categoryName;
    }
}
