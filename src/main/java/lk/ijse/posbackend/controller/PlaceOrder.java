package lk.ijse.posbackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.posbackend.bo.BOFactory;
import lk.ijse.posbackend.bo.custom.PlaceOrderBO;
import lk.ijse.posbackend.dto.OrderDTO;
import lk.ijse.posbackend.dto.OrderDetailsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/placeOrder")
public class PlaceOrder extends HttpServlet {
    PlaceOrderBO placeOrderBO = (PlaceOrderBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PLACEORDER);

    Connection connection;

    static Logger logger = LoggerFactory.getLogger(PlaceOrder.class);

    @Override
    public void init() throws ServletException {
        logger.info("Init method invoked");

        try {
            var ctx = new InitialContext();
            DataSource pool = (DataSource) ctx.lookup("java:comp/env/jdbc/POS_Backend");

            this.connection = pool.getConnection();
            logger.debug("connection initialized", this.connection);

        } catch (SQLException | NamingException e) {
            logger.error("DB connection not init");
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        try {
            ObjectMapper mapper = new ObjectMapper();
            OrderDTO orderDTO = mapper.readValue(req.getInputStream(), OrderDTO.class);
            OrderDetailsDTO orderDetailsDTO = new OrderDetailsDTO();

            for (OrderDetailsDTO detailsDTO : orderDTO.getOrderDetailsDTOS()){
                orderDetailsDTO.setItemCode(detailsDTO.getItemCode());
                orderDetailsDTO.setQty(detailsDTO.getQty());
                orderDetailsDTO.setUnitPrice(detailsDTO.getUnitPrice());
                orderDetailsDTO.setCustomerId(detailsDTO.getCustomerId());
            }

            boolean saveOrder = placeOrderBO.placeOrder(orderDetailsDTO,orderDTO,connection);

            if(saveOrder){
                resp.setStatus(HttpServletResponse.SC_CREATED);
            }else{
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "failed to save");
            }
        }catch (Exception e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
    }
}
