package ua.goit.andre.ee10.model;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Andre on 28.05.2016.
 */
@Entity
@Table(name = "order_num")
public class OrderNum {

    @Id
    @SequenceGenerator(name="order_detail_id_seq",
            sequenceName="order_detail_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="order_detail_id_seq")
    @Column(name = "id", updatable=false)
    @Expose
    private int id;

    @ManyToOne
    @JoinColumn(name="employee_id")
    @Expose
    private Employee employee;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "orderNum")
    //@JoinColumn(name = "order_id")
    @Expose
    private List<OrderDetail> orderDetails = new ArrayList<>();

    @Column(name = "table_num")
    @Expose
    private int tableNum;

    @Column(name = "date_order")
    @Expose
    private Timestamp dateOrder;

    @Column(name="open")
    @Expose
    private boolean open;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public int getTableNum() {
        return tableNum;
    }

    public void setTableNum(int tableNum) {
        this.tableNum = tableNum;
    }

    public Timestamp getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Timestamp dateOrder) {
        this.dateOrder = dateOrder;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    @Override
    public String toString() {
        return "OrderNum{" +
                "id=" + id +
                ", employee=" + employee +
                ", orderDetails=" + orderDetails +
                ", tableNum=" + tableNum +
                ", dateOrder=" + dateOrder +
                ", open=" + open +
                '}';
    }
}
