package ua.goit.andre.ee6.dao;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee6.model.CategoryDish;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andre on 04.06.2016.
 */
public class JdbcCategoryDishDao extends AbstractDao <CategoryDish, Integer> {

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void add(CategoryDish categoryDish) {
        /*
            INSERT INTO category_dish (category_name) VALUES ('Meat');
        */
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO category_dish (category_name) VALUES (?)")) {
            statement.setString (1,categoryDish.getCategoryName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void delById(Integer id) {
        delBySqlId("DELETE FROM dish WHERE id = ?", id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void update(Integer id, CategoryDish entity) {

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public CategoryDish getById(Integer id) {
        return getBySqlId("SELECT * FROM category_dish WHERE id = ?", id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List <CategoryDish> getByName(String name) {
        return getBySqlName("SELECT * FROM category_dish WHERE category_name LIKE ?", name);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List <CategoryDish> getAll() {
        return getAllSql("SELECT * FROM category_dish");
    }

    @Override
    CategoryDish createEntity(ResultSet resultSet) throws SQLException {
        CategoryDish categoryDish = new CategoryDish();
        categoryDish.setId(resultSet.getInt("id"));
        categoryDish.setCategoryName(resultSet.getString("category_name"));
        return categoryDish;
    }
}
