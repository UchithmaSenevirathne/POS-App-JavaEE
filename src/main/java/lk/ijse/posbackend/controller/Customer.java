package lk.ijse.posbackend.controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.posbackend.bo.BOFactory;
import lk.ijse.posbackend.bo.custom.CustomerBO;
import lk.ijse.posbackend.dto.CutomerDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/customer", loadOnStartup = 2)
public class Customer extends HttpServlet {
    Connection connection;

    static Logger logger = LoggerFactory.getLogger(Customer.class);

    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(var writer = resp.getWriter()) {
            Jsonb jsonb = JsonbBuilder.create();
            resp.setContentType("application/json");

            List<CutomerDTO> customers = customerBO.getAllCustomers(connection);

            if (customers != null){
                jsonb.toJson(customers, writer);
            }else{
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "no customers found");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
        try {
            Jsonb jsonb = JsonbBuilder.create();
            CutomerDTO cutomerDTO = jsonb.fromJson(req.getReader(), CutomerDTO.class);
            if(false){
                return;
            }
            //save data to the db
            boolean isSaved = customerBO.saveCustomer(cutomerDTO,connection);

            if(isSaved){
                resp.setStatus(HttpServletResponse.SC_CREATED);
            }else{
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "failed to save");
            }
//            writer.write(studentBOIMPL.saveStudent(student,connection));
//            resp.setStatus(HttpServletResponse.SC_CREATED);

        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (var writer = resp.getWriter()){
            var id = req.getParameter("id");
            Jsonb jsonb = JsonbBuilder.create();
            CutomerDTO cutomerDTO = jsonb.fromJson(req.getReader(), CutomerDTO.class);

            if (customerBO.updateCustomer(cutomerDTO, connection)){
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }else {
                writer.write("update failed");
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
