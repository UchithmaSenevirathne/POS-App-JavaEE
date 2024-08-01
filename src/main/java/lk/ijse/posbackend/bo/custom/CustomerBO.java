package lk.ijse.posbackend.bo.custom;

import lk.ijse.posbackend.bo.SuperBO;
import lk.ijse.posbackend.dto.CutomerDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CustomerBO extends SuperBO {
    boolean updateCustomer(CutomerDTO dto, Connection connection) throws SQLException;
    boolean saveCustomer(CutomerDTO dto, Connection connection) throws SQLException;
    List<CutomerDTO> getAllCustomers(Connection connection) throws SQLException;
    boolean deleteCustomer(String id, Connection connection) throws SQLException;
}
