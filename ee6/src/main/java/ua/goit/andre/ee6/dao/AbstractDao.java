package ua.goit.andre.ee6.dao;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.andre.ee6.model.Employee;
import ua.goit.andre.ee6.model.Stock;

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
public abstract class AbstractDao<E,K> {
    DataSource dataSource;

    public abstract void add (E entity);
    public abstract void delById (K id);
    public abstract void update(K id, E entity);
    public abstract E getById(K id);
    public abstract List<E> getByName (String name);
    public abstract List<E> getAll();

    @Transactional(propagation = Propagation.MANDATORY)


    List<E> getAllSql(String sql) {
        List<E> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.add(createEntity(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void delBySqlId(String sql, Integer id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public List getBySqlName(String sql, String name) {
        List <E> result = new ArrayList();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1,name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                E entity = createEntity(resultSet);
                result.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public E getBySqlId(String sql, Integer id) {
        E result = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = createEntity(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    abstract E createEntity(ResultSet resultSet) throws SQLException ;
}
