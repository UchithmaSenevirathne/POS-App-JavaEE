package lk.ijse.posbackend.bo.custom;

import lk.ijse.posbackend.bo.SuperBO;
import lk.ijse.posbackend.dto.OrderDTO;
import lk.ijse.posbackend.dto.OrderDetailsDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface PlaceOrderBO extends SuperBO {
    boolean placeOrder(OrderDTO orderDTO, Connection connection) throws Exception;

    List<OrderDetailsDTO> getAllOrders(Connection connection) throws SQLException;
}
