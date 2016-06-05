package ua.goit.andre.ee6.model;

/**
 * Created by Andre on 28.05.2016.
 */
public class OrderDetail {
    private int id;
    private int orderId;
    private int dishId;
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
