package lk.ijse.posbackend.dao;

import lk.ijse.posbackend.entity.CustomerEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<T> extends SuperDAO {
    boolean save(Connection connection,T dto) throws SQLException;

    List<T> getAll(Connection connection) throws SQLException;

    T search(Connection connection,String id) throws SQLException;

    boolean update(Connection connection,T dto) throws SQLException;

    boolean delete(Connection connection,String id) throws SQLException;
}
