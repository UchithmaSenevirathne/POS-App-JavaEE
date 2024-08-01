package lk.ijse.posbackend.bo.custom.impl;

import lk.ijse.posbackend.bo.custom.CustomerBO;
import lk.ijse.posbackend.dto.CutomerDTO;

import java.sql.SQLException;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {
    @Override
    public boolean updateCustomer(CutomerDTO dto) throws SQLException {
        return false;
    }

    @Override
    public boolean saveCustomer(CutomerDTO dto) throws SQLException {
        return false;
    }

    @Override
    public List<CutomerDTO> getAllCustomers() throws SQLException {
        return null;
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException {
        return false;
    }
}
