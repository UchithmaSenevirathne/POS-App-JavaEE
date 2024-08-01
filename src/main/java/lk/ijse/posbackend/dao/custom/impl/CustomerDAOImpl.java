package lk.ijse.posbackend.dao.custom.impl;

import lk.ijse.posbackend.dao.SQLUtil;
import lk.ijse.posbackend.dao.custom.CustomerDAO;
import lk.ijse.posbackend.entity.CustomerEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean save(Connection connection, CustomerEntity entity) throws SQLException {
        return SQLUtil.execute(connection,
                "INSERT INTO customer VALUES(?, ?, ?, ?, ?)",
                entity.getId(),
                entity.getName(),
                entity.getAddress(),
                entity.getEmail(),
                entity.getContact()
        );
    }

    @Override
    public List<CustomerEntity> getAll(Connection connection) throws SQLException {
        return null;
    }

    @Override
    public CustomerEntity search(Connection connection,String id) throws SQLException {
        return null;
    }

    @Override
    public boolean update(Connection connection,CustomerEntity entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Connection connection,String id) throws SQLException {
        return false;
    }
}
