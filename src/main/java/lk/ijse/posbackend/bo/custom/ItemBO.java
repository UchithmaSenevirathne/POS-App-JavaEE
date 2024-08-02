package lk.ijse.posbackend.bo.custom;

import lk.ijse.posbackend.bo.SuperBO;
import lk.ijse.posbackend.dto.ItemDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ItemBO extends SuperBO {
    boolean updateItem(ItemDTO dto, Connection connection) throws SQLException;
    boolean saveItem(ItemDTO dto, Connection connection) throws SQLException;
    List<ItemDTO> getAllItems(Connection connection) throws SQLException;
    boolean deleteItem(String id, Connection connection) throws SQLException;
}
