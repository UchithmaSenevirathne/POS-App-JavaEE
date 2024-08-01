package lk.ijse.posbackend.dao.custom.impl;

import lk.ijse.posbackend.dao.custom.CustomerDAO;
import lk.ijse.posbackend.entity.CustomerEntity;

import java.sql.SQLException;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean save(CustomerEntity dto) throws SQLException {
        return false;
    }

    @Override
    public List<CustomerEntity> getAll() throws SQLException {
        return null;
    }

    @Override
    public CustomerEntity search(String id) throws SQLException {
        return null;
    }

    @Override
    public boolean update(CustomerEntity dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }
}
