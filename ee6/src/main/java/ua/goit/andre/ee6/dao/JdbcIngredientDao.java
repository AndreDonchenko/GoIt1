package ua.goit.andre.ee6.dao;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee6.model.Ingredient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andre on 04.06.2016.
 */
public class JdbcIngredientDao extends AbstractDao <Ingredient, Integer> {

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void add(Ingredient Ingredient) {
        // INSERT INTO ingredient (ingredient_name) VALUES ('Pork'), ('Beef'), ('Mutton'), ('Potatoes');
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO ingredient (ingredient_name) VALUES (?)")) {
            statement.setString (1,Ingredient.getIngredientName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void delById(Integer id) {
        delBySqlId("DELETE FROM ingredient WHERE id = ?", id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void update(Integer id, Ingredient entity) {

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Ingredient getById(Integer id) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List <Ingredient> getByName(String name) {
        return getBySqlName("SELECT * FROM ingredient WHERE ingredient_name LIKE ?", name);
    }

    @Override
    public List<Ingredient> getAll() {
        return getAllSql("SELECT * FROM ingredient");
    }

    @Override
    Ingredient createEntity(ResultSet resultSet) throws SQLException {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(resultSet.getInt("id"));
        ingredient.setIngredientName(resultSet.getString("ingredient_name"));
        return ingredient;
    }

}
