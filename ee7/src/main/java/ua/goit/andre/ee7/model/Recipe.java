package ua.goit.andre.ee7.model;

import javax.persistence.*;

/**
 * Created by Andre on 28.05.2016.
 */
@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @SequenceGenerator(name="recipe_id_seq",
            sequenceName="recipe_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="recipe_id_seq")
    @Column(name = "id", updatable=false)
    private int id;

    @Column(name="dish_id")
    private int dishId;

    @Column(name="ingredient_id")
    private int ingredientId;

    @Column(name="qty")
    private double qty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }
}
