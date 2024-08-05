package lk.ijse.posbackend.dao.custom.impl;

import lk.ijse.posbackend.dao.custom.PlaceOrderDAO;
import lk.ijse.posbackend.entity.OrderDetailsEntity;
import lk.ijse.posbackend.entity.OrderEntity;

public class PlaceOrderDAOImpl implements PlaceOrderDAO {
    @Override
    public boolean saveOrder(OrderEntity orderEntity) {
        return false;
    }

    @Override
    public boolean saveOrderDetails(OrderDetailsEntity orderDetailsEntity) {
        return false;
    }
}
