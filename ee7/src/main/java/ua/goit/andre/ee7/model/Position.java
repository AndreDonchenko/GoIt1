package ua.goit.andre.ee7.model;

import javax.persistence.*;

/**
 * Created by Andre on 28.05.2016.
 */
@Entity
@Table(name = "position")
public class Position {

    @Id
    @SequenceGenerator(name="position_id_seq",
            sequenceName="position_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="position_id_seq")
    @Column(name = "id", updatable=false)
    private int id;

    @Column(name = "position_name")
    private String positionName;

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", positionName='" + positionName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
