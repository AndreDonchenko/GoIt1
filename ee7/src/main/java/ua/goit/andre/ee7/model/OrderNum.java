package ua.goit.andre.ee7.model;

import javax.persistence.*;
import java.sql.Timestamp;
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
    private int id;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    @ManyToMany()
    @JoinTable (
            name = "order_detail",
            joinColumns = @JoinColumn(name="order_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    private List<Dish> dishes;

    @Override
    public String toString() {
        return "OrderNum{" +
                "id=" + id +
                ", employee=" + employee +
                //", dishes=" + dishes +
                ", tableNum=" + tableNum +
                ", dateOrder=" + dateOrder +
                ", open=" + open +
                '}';
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Column(name = "table_num")
    private int tableNum;

    @Column(name = "date_order")
    private Timestamp dateOrder;

    @Column(name="open")
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
}
