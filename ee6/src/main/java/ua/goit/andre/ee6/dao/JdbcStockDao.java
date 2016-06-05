package ua.goit.andre.ee6.dao;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee6.model.Stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andre on 04.06.2016.
 */
public class JdbcStockDao extends AbstractDao <Stock, Integer> {

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void add(Stock Stock) {
        /*
            INSERT INTO stock (ingredient_id, qty)
        */
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO Stock VALUES (?, ?)")) {
            statement.setInt (1, Stock.getIngedientId());
            statement.setDouble (2, Stock.getQty());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void delById(Integer id) {
        delBySqlId("DELETE FROM stock WHERE ingredient_id = ?", id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void update(Integer id, Stock entity) {

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Stock getById(Integer id) {
        return getBySqlId("SELECT * FROM stock WHERE ingredient_id = ?", id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List <Stock> getByName(String name) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List <Stock> getAll() {
        return getAllSql("SELECT * FROM stock");
    }

    @Override
    Stock createEntity(ResultSet resultSet) throws SQLException {
        Stock stock = new Stock();
        stock.setIngedientId(resultSet.getInt("ingredient_id"));
        stock.setQty(resultSet.getDouble("qty"));
        return stock;
    }
}
