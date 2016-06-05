package ua.goit.andre.ee6.dao;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee6.model.PreparedDish;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Andre on 04.06.2016.
 */
public class JdbcPreparedDishDao extends AbstractDao <PreparedDish, Integer> {

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void add(PreparedDish preparedDish) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO prepared_dish VALUES (?, ?, ?, ?)")) {
            statement.setInt(1, preparedDish.getDishId());
            statement.setInt (2, preparedDish.getEmployeeId());
            statement.setInt(3, preparedDish.getOrderId());
            statement.setTimestamp(4, preparedDish.getPrepareDate());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void delById(Integer id) {
        delBySqlId("DELETE FROM prepared_dish WHERE id = ?", id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void update(Integer id, PreparedDish entity) {

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public PreparedDish getById(Integer id) {
        return getBySqlId("SELECT * FROM prepared_dish WHERE id = ?", id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List <PreparedDish> getByName(String name) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List <PreparedDish> getAll() {
        return getAllSql("SELECT * FROM prepared_dish");
    }

    @Override
    PreparedDish createEntity(ResultSet resultSet) throws SQLException {
        PreparedDish preparedDish = new PreparedDish();
        preparedDish.setId(resultSet.getInt("id"));
        preparedDish.setDishId(resultSet.getInt("dish_id"));
        preparedDish.setEmployeeId(resultSet.getInt("employee_id"));
        preparedDish.setOrderId(resultSet.getInt("order_id"));
        preparedDish.setPrepareDate(resultSet.getTimestamp("prepare_date"));
        return preparedDish;
    }
}
