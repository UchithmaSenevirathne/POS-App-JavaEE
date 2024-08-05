package lk.ijse.posbackend.dao.custom.impl;

import lk.ijse.posbackend.dao.SQLUtil;
import lk.ijse.posbackend.dao.custom.PlaceOrderDAO;
import lk.ijse.posbackend.entity.OrderDetailsEntity;
import lk.ijse.posbackend.entity.OrderEntity;

import java.sql.Connection;
import java.sql.SQLException;

public class PlaceOrderDAOImpl implements PlaceOrderDAO {
    @Override
    public boolean saveOrder(OrderEntity orderEntity, Connection connection) throws SQLException {
        return SQLUtil.execute(connection,
                "INSERT INTO order VALUES(?, ?, ?)",
                orderEntity.getId(),
                orderEntity.getDate(),
                orderEntity.getTotal()
        );
    }

    @Override
    public boolean saveOrderDetails(OrderDetailsEntity orderDetailsEntity, Connection connection) throws SQLException {
        return SQLUtil.execute(connection,
                "INSERT INTO order_detail VALUES(?, ?, ?)",
                orderDetailsEntity.getItemCode(),
                orderDetailsEntity.getQty(),
                orderDetailsEntity.getUnitPrice(),
                orderDetailsEntity.getCustomerId()
        );
    }
}
