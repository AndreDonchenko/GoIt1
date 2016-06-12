package ua.goit.andre.ee7.model;


import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Andre on 28.05.2016.
 */
@Entity
@Table(name = "prepared_dish")
public class PreparedDish {

    @Id
    @SequenceGenerator(name="prepared_dish_id_seq",
            sequenceName="prepared_dish_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="prepared_dish_id_seq")
    @Column(name = "id", updatable=false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderNum order;

    @Column(name = "prepare_date")
    private Timestamp prepareDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Timestamp getPrepareDate() {
        return prepareDate;
    }

    public void setPrepareDate(Timestamp prepareDate) {
        this.prepareDate = prepareDate;
    }
}
