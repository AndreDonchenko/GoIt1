package ua.goit.andre.ee10.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

/**
 * Created by Andre on 28.05.2016.
 */
@Entity
@Table(name = "dish")
public class Dish {

    @Id
    @SequenceGenerator(name="dish_id_seq",
            sequenceName="dish_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="dish_id_seq")
    @Column(name = "id", updatable=false)
    private int id;

    @Column(name = "dish_name")
    @Expose
    private String dishName;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @Fetch(FetchMode.JOIN)
    @Expose
    private CategoryDish categoryDish;

    @Column(name="price")
    @Expose
    private double price;

    @Column(name="weight")
    @Expose
    private double weight;

    /*
    @OneToMany(mappedBy = "dish")
    private List<OrderDetail> orderDetails = new ArrayList<>();
    */

    @Override
    public String toString() {
        return "Dish{" +
                ", dishName='" + dishName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*
    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
    */

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public CategoryDish getCategoryDish() {
        return categoryDish;
    }

    public void setCategoryDish(CategoryDish categoryDish) {
        this.categoryDish = categoryDish;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
