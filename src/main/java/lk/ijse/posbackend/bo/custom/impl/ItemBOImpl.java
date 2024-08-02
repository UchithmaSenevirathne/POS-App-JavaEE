package lk.ijse.posbackend.bo.custom.impl;

import lk.ijse.posbackend.bo.custom.ItemBO;
import lk.ijse.posbackend.dto.ItemDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ItemBOImpl implements ItemBO {
    @Override
    public boolean updateItem(ItemDTO dto, Connection connection) throws SQLException {
        return false;
    }

    @Override
    public boolean saveItem(ItemDTO dto, Connection connection) throws SQLException {
        return false;
    }

    @Override
    public List<ItemDTO> getAllItems(Connection connection) throws SQLException {
        return null;
    }

    @Override
    public boolean deleteItem(String id, Connection connection) throws SQLException {
        return false;
    }
}
