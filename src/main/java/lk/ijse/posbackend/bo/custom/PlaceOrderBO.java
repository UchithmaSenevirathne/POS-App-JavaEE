package lk.ijse.posbackend.bo.custom;

import lk.ijse.posbackend.dto.OrderDTO;
import lk.ijse.posbackend.dto.OrderDetailsDTO;

public interface PlaceOrderBO {
    void placeOrder(OrderDetailsDTO orderDetailsDTO, OrderDTO orderDTO);
}
