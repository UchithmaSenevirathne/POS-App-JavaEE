package lk.ijse.posbackend.bo.custom.impl;

import lk.ijse.posbackend.bo.custom.CustomerBO;
import lk.ijse.posbackend.dto.CutomerDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {
    @Override
    public boolean updateCustomer(CutomerDTO dto, Connection connection) throws SQLException {
        return false;
    }

    @Override
    public boolean saveCustomer(CutomerDTO dto, Connection connection) throws SQLException {
        return false;
    }

    @Override
    public List<CutomerDTO> getAllCustomers(Connection connection) throws SQLException {
        return null;
    }

    @Override
    public boolean deleteCustomer(String id, Connection connection) throws SQLException {
        return false;
    }
}
