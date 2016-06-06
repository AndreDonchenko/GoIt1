package ua.goit.andre.ee7.model;


import java.sql.Timestamp;

/**
 * Created by Andre on 28.05.2016.
 */
public class PreparedDish {
    private int id;
    private int dishId;
    private int employeeId;
    private int orderId;
    private Timestamp prepareDate;

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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Timestamp getPrepareDate() {
        return prepareDate;
    }

    public void setPrepareDate(Timestamp prepareDate) {
        this.prepareDate = prepareDate;
    }
}
