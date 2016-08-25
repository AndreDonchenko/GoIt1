package ua.goit.andre.ee10.model;

import javax.persistence.*;

/**
 * Created by Andre on 28.05.2016.
 */
@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @SequenceGenerator(name="ingredient_id_seq",
            sequenceName="ingredient_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="ingredient_id_seq")
    @Column(name = "id", updatable=false)
    private int id;

    @Column(name="ingredient_name")
    private String ingredientName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}
