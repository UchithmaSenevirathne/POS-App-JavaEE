package lk.ijse.posbackend.dao.custom.impl;

import lk.ijse.posbackend.dao.SQLUtil;
import lk.ijse.posbackend.dao.custom.ItemDAO;
import lk.ijse.posbackend.entity.CustomerEntity;
import lk.ijse.posbackend.entity.ItemEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean save(Connection connection, ItemEntity entity) throws SQLException {
        return SQLUtil.execute(connection,
                "INSERT INTO item VALUES(?, ?, ?, ?)",
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getUnit_price()
        );
    }
    @Override
    public List<ItemEntity> getAll(Connection connection) throws SQLException {
        List<ItemEntity> items = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute(connection,"SELECT * FROM item");
        while (resultSet.next()){
            String item_id = resultSet.getString(1);
            String item_name = resultSet.getString(2);
            String item_desc = resultSet.getString(3);
            Double item_up = resultSet.getDouble(4);
            var entity = new ItemEntity(item_id, item_name, item_desc, item_up);
            items.add(entity);
        }
        return items;
    }
    @Override
    public boolean update(Connection connection, ItemEntity entity) throws SQLException {
        return SQLUtil.execute(connection,
                "UPDATE item SET name = ?, description = ?, unit_price = ? WHERE id = ?",
                entity.getName(),
                entity.getDescription(),
                entity.getUnit_price(),
                entity.getId());
    }
    @Override
    public boolean delete(Connection connection, String id) throws SQLException {
        return SQLUtil.execute(connection,
                "DELETE FROM item WHERE id = ?", id);
    }
}
