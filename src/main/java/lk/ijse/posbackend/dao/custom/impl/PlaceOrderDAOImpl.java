package lk.ijse.posbackend.dao.custom.impl;

import lk.ijse.posbackend.dao.SQLUtil;
import lk.ijse.posbackend.dao.custom.PlaceOrderDAO;
import lk.ijse.posbackend.entity.ItemEntity;
import lk.ijse.posbackend.entity.OrderDetailsEntity;
import lk.ijse.posbackend.entity.OrderEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        List<OrderDetailsEntity> orderDetailsEntities = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute(connection,"SELECT * FROM order_details");
        while (resultSet.next()){
            String item_id = resultSet.getString(1);
            Integer item_qty = resultSet.getInt(2);
            Double item_up = resultSet.getDouble(3);
            String item_name = resultSet.getString(4);
            String item_desc = resultSet.getString(5);
            Double total = resultSet.getDouble(6);
            var entity = new OrderDetailsEntity(item_id, item_name, item_desc, item_qty, item_up, total);
            orderDetailsEntities.add(entity);
        }
        return orderDetailsEntities;
    }
}
