package lk.ijse.posbackend.dao.custom;

import lk.ijse.posbackend.dao.SuperDAO;
import lk.ijse.posbackend.entity.OrderDetailsEntity;
import lk.ijse.posbackend.entity.OrderEntity;

import java.sql.Connection;
import java.sql.SQLException;

public interface PlaceOrderDAO extends SuperDAO {
    boolean saveOrder(OrderEntity orderEntity, Connection connection) throws SQLException;
    boolean saveOrderDetails(OrderDetailsEntity orderDetailsEntity, Connection connection) throws SQLException;
}
