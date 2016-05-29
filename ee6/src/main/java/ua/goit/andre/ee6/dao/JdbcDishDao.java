package ua.goit.andre.ee6.dao;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee6.model.Dish;
import ua.goit.andre.ee6.model.Employee;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andre on 29.05.2016.
 */
public class JdbcDishDao extends AbstractDao<Dish, Integer> {

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void add(Dish dish) {
        /*
            INSERT INTO dish (dish_name, category_id, price, weight) VALUES ('Steak', (SELECT id FROM category_dish WHERE category_name = 'Meat'), 100, 0.400);
        */
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement statement = connection.prepareStatement("INSERT INTO dish (dish_name, category_id, price, weight) VALUES (?, ?, ?, ?)")) {
                statement.setString (1,dish.getDishName());
                statement.setInt(2,dish.getCategoryId());
                statement.setDouble(3,dish.getPrice());
                statement.setDouble(4,dish.getWeight());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void delById(Integer id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM dish WHERE id = ?")) {
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Dish entity) {

    }

    @Override
    public Dish getById(Integer id) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Dish> getByName(String dishName) {
        List<Dish> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM dish WHERE dish_name LIKE ?")) {
            statement.setString(1,dishName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Dish dish = new Dish();
                dish.setId(resultSet.getInt("id"));
                dish.setDishName(resultSet.getString("dish_name"));
                dish.setPrice(resultSet.getDouble("price"));
                dish.setCategoryId(resultSet.getInt("category_id"));
                dish.setWeight(resultSet.getDouble("weight"));
                result.add(dish);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Dish> getAll() {
        return getByName("%");
    }
}
