package lk.ijse.posbackend.bo.custom;

import lk.ijse.posbackend.bo.SuperBO;
import lk.ijse.posbackend.dto.CutomerDTO;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBO extends SuperBO {
    boolean updateCustomer(CutomerDTO dto) throws SQLException;
    boolean saveCustomer(CutomerDTO dto) throws SQLException;
    List<CutomerDTO> getAllCustomers() throws SQLException;
    boolean deleteCustomer(String id) throws SQLException;
}
