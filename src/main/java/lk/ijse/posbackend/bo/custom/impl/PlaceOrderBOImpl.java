package lk.ijse.posbackend.bo.custom.impl;

import lk.ijse.posbackend.bo.custom.PlaceOrderBO;
import lk.ijse.posbackend.dao.DAOFactory;
import lk.ijse.posbackend.dao.custom.PlaceOrderDAO;
import lk.ijse.posbackend.dto.OrderDTO;
import lk.ijse.posbackend.dto.OrderDetailsDTO;
import lk.ijse.posbackend.entity.OrderDetailsEntity;
import lk.ijse.posbackend.entity.OrderEntity;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class PlaceOrderBOImpl implements PlaceOrderBO {
    PlaceOrderDAO placeOrderDAO = (PlaceOrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PLACEORDER);
    @Override
    public boolean placeOrder(OrderDetailsDTO orderDetailsDTO, OrderDTO orderDTO, Connection connection) {
        List<OrderDetailsEntity> orderDetailsEntities = new ArrayList<>();
        for (OrderDetailsDTO dto : orderDTO.getOrderDetailsDTOS()){
            orderDetailsEntities.add(new OrderDetailsEntity(dto.getItemCode(),
                    dto.getQty(),
                    dto.getUnitPrice(),
                    dto.getCustomerId()));
        }
        boolean saveOrder = placeOrderDAO.saveOrder(new OrderEntity(orderDTO.getId(),
                orderDTO.getDate(),
                orderDTO.getTotal(),
                orderDetailsEntities),
                connection
        );

        if (saveOrder){
            boolean saveDetails = placeOrderDAO.saveOrderDetails(new OrderDetailsEntity(orderDetailsDTO.getItemCode(),
                    orderDetailsDTO.getQty(),
                    orderDetailsDTO.getUnitPrice(),
                    orderDetailsDTO.getCustomerId()), connection);

            if (saveDetails){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
}
