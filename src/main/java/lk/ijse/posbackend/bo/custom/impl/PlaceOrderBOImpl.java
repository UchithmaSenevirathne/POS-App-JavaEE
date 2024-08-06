package lk.ijse.posbackend.bo.custom.impl;

import lk.ijse.posbackend.bo.custom.PlaceOrderBO;
import lk.ijse.posbackend.dao.DAOFactory;
import lk.ijse.posbackend.dao.custom.PlaceOrderDAO;
import lk.ijse.posbackend.dto.OrderDTO;
import lk.ijse.posbackend.dto.OrderDetailsDTO;
import lk.ijse.posbackend.entity.OrderDetailsEntity;
import lk.ijse.posbackend.entity.OrderEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaceOrderBOImpl implements PlaceOrderBO {
    PlaceOrderDAO placeOrderDAO = (PlaceOrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PLACEORDER);
    @Override
    public boolean placeOrder(OrderDTO orderDTO, Connection connection) throws Exception {
        try {
            connection.setAutoCommit(false);

            OrderEntity order = new OrderEntity();
            order.setOId(orderDTO.getOId());
            order.setDate(orderDTO.getDate());
            order.setTotal(orderDTO.getTotal());
            order.setCustomerId(orderDTO.getCustomerId());

            boolean orderSaved = placeOrderDAO.saveOrder(order, connection);
            if (!orderSaved) {
                connection.rollback();
                return false;
            }

            List<OrderDetailsDTO> orderDetailsList = orderDTO.getOrderDetails();
            for (OrderDetailsDTO detailsDTO : orderDetailsList) {
                OrderDetailsEntity orderDetails = new OrderDetailsEntity();
                orderDetails.setItemId(detailsDTO.getItemId());
                orderDetails.setItemName(detailsDTO.getItemName());
                orderDetails.setItemDescription(detailsDTO.getItemDescription());
                orderDetails.setQty(detailsDTO.getQty());
                orderDetails.setUnitPrice(detailsDTO.getUnitPrice());
                orderDetails.setTotal(detailsDTO.getTotal());

                boolean orderDetailsSaved = placeOrderDAO.saveOrderDetails(orderDetails, connection);
                if (!orderDetailsSaved) {
                    connection.rollback();
                    return false;
                }
            }

            connection.commit();
            return true;
        } catch (Exception e) {
            connection.rollback();
            throw e;
        }
    }

    @Override
    public List<OrderDetailsDTO> getAllOrders(Connection connection) throws SQLException {
        List<OrderDetailsDTO> orderDTOS = new ArrayList<>();
        List<OrderDetailsEntity> orderEntities = placeOrderDAO.getAllOrders(connection);

        for (OrderDetailsEntity entity : orderEntities){
            orderDTOS.add(new OrderDetailsDTO(entity.getItemId(), entity.getItemName(), entity.getItemDescription(), entity.getQty(), entity.getUnitPrice(), entity.getTotal()));
        }

        return orderDTOS;
    }
}
