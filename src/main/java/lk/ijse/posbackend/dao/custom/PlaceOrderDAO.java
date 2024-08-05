package lk.ijse.posbackend.dao.custom;

import lk.ijse.posbackend.dao.SuperDAO;
import lk.ijse.posbackend.entity.OrderDetailsEntity;
import lk.ijse.posbackend.entity.OrderEntity;

public interface PlaceOrderDAO extends SuperDAO {
    void saveOrder(OrderEntity orderEntity);
    void saveOrderDetails(OrderDetailsEntity orderDetailsEntity);
}
