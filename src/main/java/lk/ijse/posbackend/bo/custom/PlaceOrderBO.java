package lk.ijse.posbackend.bo.custom;

import lk.ijse.posbackend.dto.OrderDTO;
import lk.ijse.posbackend.dto.OrderDetailsDTO;

public interface PlaceOrderBO {
    boolean placeOrder(OrderDetailsDTO orderDetailsDTO, OrderDTO orderDTO);
}
