package lk.ijse.posbackend.dao.custom.impl;

import lk.ijse.posbackend.dao.SQLUtil;
import lk.ijse.posbackend.dao.custom.PlaceOrderDAO;
import lk.ijse.posbackend.entity.OrderDetailsEntity;
import lk.ijse.posbackend.entity.OrderEntity;

import java.sql.Connection;
import java.sql.SQLException;

public class PlaceOrderDAOImpl implements PlaceOrderDAO {
    @Override
    public boolean saveOrder(OrderEntity order, Connection connection) throws SQLException {
        String query = "INSERT INTO orders (oId, date, total) VALUES (?, ?, ?)";
        return SQLUtil.execute(connection, query, order.getOId(), order.getDate(), order.getTotal());
    }

    @Override
    public boolean saveOrderDetails(OrderDetailsEntity orderDetails, Connection connection) throws SQLException {
        String query = "INSERT INTO order_details (itemId, qty, unitPrice, customerId) VALUES (?, ?, ?, ?)";
        return SQLUtil.execute(connection, query, orderDetails.getItemId(), orderDetails.getQty(), orderDetails.getUnitPrice(), orderDetails.getCustomerId());
    }
}
