package ua.goit.andre.ee10.model;

import com.google.gson.annotations.Expose;

import javax.persistence.*;

/**
 * Created by Andre on 28.05.2016.
 */
@Entity
@Table(name = "category_dish")
public class CategoryDish {

    @Id
    @Column(name = "category_name")
    @Expose
    private String categoryName;

    public CategoryDish() {
    }

    public CategoryDish(String categoryName) {
        this.categoryName=categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return categoryName;
    }
}
