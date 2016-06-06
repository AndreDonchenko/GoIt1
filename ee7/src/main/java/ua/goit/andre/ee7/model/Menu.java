package ua.goit.andre.ee7.model;

/**
 * Created by Andre on 28.05.2016.
 */
public class Menu {
    private int id;
    private String menuName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", menuName='" + menuName + '\'' +
                '}';
    }
}
