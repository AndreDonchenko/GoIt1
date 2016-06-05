package ua.goit.andre.ee6.dao;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee6.model.Recipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Andre on 04.06.2016.
 */
public class JdbcRecipeDao extends AbstractM2MDao <Recipe, Integer, Integer> {

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void add(Recipe dish) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO recipe (dish_id, ingredient_id, qty) VALUES (?, ?, ?)")) {
            statement.setInt(1, dish.getDishId());
            statement.setInt(2, dish.getIngredientId());
            statement.setDouble(3, dish.getQty());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void delByEntity(Recipe detail) {
        addDelByKeys("DELETE FROM recipe WHERE dish_id = ? AND ingredient_id = ?", detail.getDishId(), detail.getIngredientId());
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Recipe> getById(Integer id) {
        return get("SELECT * FROM recipe WHERE dish_id = ? ", id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Recipe> getByValue(Integer value) {
        return get("SELECT * FROM recipe WHERE ingredient_id = ? ", value);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List <Recipe> getAll() {
        return get("SELECT * FROM recipe", null);
    }

    @Override
    Recipe createEntity(ResultSet resultSet) throws SQLException {
        Recipe recipe = new Recipe();
        recipe.setId(resultSet.getInt("id"));
        recipe.setDishId(resultSet.getInt("dish_id"));
        recipe.setIngredientId(resultSet.getInt("ingredient_id"));
        recipe.setQty(resultSet.getFloat("qty"));
        return recipe;
    }
}
