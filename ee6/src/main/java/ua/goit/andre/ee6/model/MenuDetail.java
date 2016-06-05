package ua.goit.andre.ee6.model;

/**
 * Created by Andre on 28.05.2016.
 */
public class MenuDetail {
    private int id;
    private int menuId;
    private int dishId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    @Override
    public String toString() {
        return "MenuDetail{" +
                "id=" + id +
                ", menuId=" + menuId +
                ", dishId=" + dishId +
                '}';
    }
}
