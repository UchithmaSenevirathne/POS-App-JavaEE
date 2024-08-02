package lk.ijse.posbackend.dao.custom.impl;

import lk.ijse.posbackend.dao.SQLUtil;
import lk.ijse.posbackend.dao.custom.ItemDAO;
import lk.ijse.posbackend.entity.ItemEntity;

import java.sql.Connection;
import java.sql.SQLException;
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
        return null;
    }

    @Override
    public ItemEntity search(Connection connection, String id) throws SQLException {
        return null;
    }

    @Override
    public boolean update(Connection connection, ItemEntity entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Connection connection, String id) throws SQLException {
        return false;
    }
}
