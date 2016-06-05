package ua.goit.andre.ee6.dao;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee6.model.OrderNum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Andre on 04.06.2016.
 */
public class JdbcOrderNumDao extends AbstractDao <OrderNum, Integer> {

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void add(OrderNum orderNum) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO order_num VALUES (?, ?, ?, ?)")) {
            statement.setInt (1, orderNum.getEmployeeId());
            statement.setInt(2, orderNum.getTableNum());
            statement.setTimestamp(3, orderNum.getDateOrder());
            statement.setBoolean (4, orderNum.isOpen());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void delById(Integer id) {
        delBySqlId("DELETE FROM order_num WHERE id = ?", id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void update(Integer id, OrderNum entity) {

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public OrderNum getById(Integer id) {
        return getBySqlId("SELECT * FROM order_num WHERE id = ?", id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List <OrderNum> getByName(String name) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List <OrderNum> getAll() {
        return getAllSql("SELECT * FROM order_num");
    }

    @Override
    OrderNum createEntity(ResultSet resultSet) throws SQLException {
        OrderNum orderNum = new OrderNum();
        orderNum.setId(resultSet.getInt("id"));
        orderNum.setEmployeeId(resultSet.getInt("employee_id"));
        orderNum.setTableNum(resultSet.getInt("table_num"));
        orderNum.setDateOrder(resultSet.getTimestamp("date_order"));
        orderNum.setOpen(resultSet.getBoolean("open"));
        return orderNum;
    }
}
