package lk.ijse.posbackend.dao.custom.impl;

import lk.ijse.posbackend.dao.SQLUtil;
import lk.ijse.posbackend.dao.custom.PlaceOrderDAO;
import lk.ijse.posbackend.entity.OrderDetailsEntity;
import lk.ijse.posbackend.entity.OrderEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PlaceOrderDAOImpl implements PlaceOrderDAO {
    @Override
    public boolean saveOrder(OrderEntity order, Connection connection) throws SQLException {
        String query = "INSERT INTO orders (oId, date, total, customerId) VALUES (?, ?, ?, ?)";
        return SQLUtil.execute(connection, query, order.getOId(), order.getDate(), order.getTotal(), order.getCustomerId());
    }

    @Override
    public boolean saveOrderDetails(OrderDetailsEntity orderDetails, Connection connection) throws SQLException {
        String query = "INSERT INTO order_details (itemId, qty, unitPrice, itemName, itemDescription, total) VALUES (?, ?, ?, ?, ?, ?)";
        return SQLUtil.execute(connection, query, orderDetails.getItemId(), orderDetails.getQty(), orderDetails.getUnitPrice(), orderDetails.getItemName(), orderDetails.getItemDescription(), orderDetails.getTotal());
    }

    @Override
    public List<OrderDetailsEntity> getAllOrders(Connection connection) throws SQLException {
        return SQLUtil.execute(connection,"SELECT * FROM order_details");
    }
}
