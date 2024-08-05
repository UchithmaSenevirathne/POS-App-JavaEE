package lk.ijse.posbackend.bo.custom;

import lk.ijse.posbackend.bo.SuperBO;
import lk.ijse.posbackend.dto.OrderDTO;
import lk.ijse.posbackend.dto.OrderDetailsDTO;

public interface PlaceOrderBO extends SuperBO {
    boolean placeOrder(OrderDetailsDTO orderDetailsDTO, OrderDTO orderDTO);
}
