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

    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock = (Stock) o;

        if (Double.compare(stock.qty, qty) != 0) return false;
        return ingedient != null ? ingedient.equals(stock.ingedient) : stock.ingedient == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = ingedient != null ? ingedient.hashCode() : 0;
        temp = Double.doubleToLongBits(qty);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
    */
}
