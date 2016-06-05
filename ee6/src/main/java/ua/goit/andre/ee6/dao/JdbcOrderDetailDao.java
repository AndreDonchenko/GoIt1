package ua.goit.andre.ee6.dao;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee6.model.OrderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Andre on 04.06.2016.
 */
public class JdbcOrderDetailDao extends AbstractM2MDao <OrderDetail, Integer, Integer> {

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void add(OrderDetail detail) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO order_detail (order_id, dish_id, qty) VALUES (?, ?, ?)")) {
            statement.setInt(1, detail.getOrderId());
            statement.setInt(2, detail.getDishId());
            statement.setDouble(3, detail.getQty());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void delByEntity(OrderDetail detail) {
        addDelByKeys("DELETE FROM menu_detail WHERE menu_id = ? AND dish_id = ?", detail.getOrderId(), detail.getDishId() );
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<OrderDetail> getById(Integer id) {
        return get("SELECT * FROM order_detail WHERE order_id = ? ", id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<OrderDetail> getByValue(Integer value) {
        return get("SELECT * FROM order_detail WHERE dish_id = ? ", value);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List <OrderDetail> getAll() {
        return get("SELECT * FROM order_detail", null);
    }

    @Override
    OrderDetail createEntity(ResultSet resultSet) throws SQLException {
        OrderDetail OrderDetail = new OrderDetail();
        OrderDetail.setId(resultSet.getInt("id"));
        OrderDetail.setOrderId(resultSet.getInt("order_id"));
        OrderDetail.setDishId(resultSet.getInt("dish_id"));
        return OrderDetail;
    }
}
