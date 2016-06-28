package ua.goit.andre.ee7.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Andre on 28.05.2016.
 */

@Entity
@Table(name = "stock")
public class Stock implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingedient;

    @Column(name = "qty")
    private double qty;

    public Ingredient getIngedient() {
        return ingedient;
    }

    public void setIngedient(Ingredient ingedient) {
        this.ingedient = ingedient;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

}
