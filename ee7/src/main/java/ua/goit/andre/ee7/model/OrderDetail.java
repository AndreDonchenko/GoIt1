package ua.goit.andre.ee7.model;

import javax.persistence.*;

/**
 * Created by Andre on 28.05.2016.
 */

@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @SequenceGenerator(name="order_detail_id_seq",
            sequenceName="order_detail_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="order_detail_id_seq")
    @Column(name = "id", updatable=false)
    private int id;

    @Column(name = "order_id")
    private int orderId;

    @Column(name = "dish_id")
    private int dishId;

    @Column(name="qty")
    private double qty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", dishId=" + dishId +
                ", qty=" + qty +
                '}';
    }
}
