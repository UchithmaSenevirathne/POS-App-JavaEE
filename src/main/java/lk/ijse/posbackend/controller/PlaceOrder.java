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
import java.util.List;

@WebServlet(urlPatterns = "/placeOrder", loadOnStartup = 2)
public class PlaceOrder extends HttpServlet {
    private PlaceOrderBO placeOrderBO = (PlaceOrderBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PLACEORDER);
    private Connection connection;
    private static Logger logger = LoggerFactory.getLogger(PlaceOrder.class);

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            OrderDTO orderDTO = mapper.readValue(req.getInputStream(), OrderDTO.class);

            boolean saveOrder = placeOrderBO.placeOrder(orderDTO, connection);

            if (saveOrder) {
                resp.setStatus(HttpServletResponse.SC_CREATED);
            } else {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to save order");
            }
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        try {
            List<OrderDetailsDTO> orders = placeOrderBO.getAllOrders(connection);
            ObjectMapper mapper = new ObjectMapper();
            String jsonResponse = mapper.writeValueAsString(orders);
            resp.getWriter().write(jsonResponse);
            resp.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception e) {
            logger.error("Error fetching orders", e);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to fetch orders");
        }
    }
}
