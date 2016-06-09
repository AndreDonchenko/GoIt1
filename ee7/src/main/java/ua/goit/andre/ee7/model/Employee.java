package ua.goit.andre.ee7.model;

import java.sql.Timestamp;
import javax.persistence.*;


/**
 * Created by Andre on 28.05.2016.
 */
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @SequenceGenerator(name="employee_id_seq",
            sequenceName="employee_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="employee_id_seq")
    @Column(name = "id", updatable=false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birth_date")
    private Timestamp birthDay;

    @Column(name = "phone")
    private String phone;

    @Column(name = "salary")
    private double salary;

    @ManyToOne
    @JoinColumn (name = "position_id")
    private Position position;

    public Position getPositionId() {
        return position;
    }

    public void setPositionId(Position positionId) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDay=" + birthDay +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", position=" + position +
                '}';
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Timestamp getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Timestamp birthDay) {
        this.birthDay = birthDay;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
