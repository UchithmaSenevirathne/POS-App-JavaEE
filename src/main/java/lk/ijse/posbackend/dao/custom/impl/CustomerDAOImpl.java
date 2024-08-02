package lk.ijse.posbackend.dao.custom.impl;

import lk.ijse.posbackend.dao.SQLUtil;
import lk.ijse.posbackend.dao.custom.CustomerDAO;
import lk.ijse.posbackend.entity.CustomerEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean save(Connection connection, CustomerEntity entity) throws SQLException {
        return SQLUtil.execute(connection,
                "INSERT INTO customer VALUES(?, ?, ?, ?, ?)",
                entity.getId(),
                entity.getName(),
                entity.getAddress(),
                entity.getEmail(),
                entity.getContact()
        );
    }

    @Override
    public List<CustomerEntity> getAll(Connection connection) throws SQLException {
        List<CustomerEntity> customers = new ArrayList<>();

        ResultSet resultSet = SQLUtil.execute(connection,"SELECT * FROM customer");

        while (resultSet.next()){
            String cus_id = resultSet.getString(1);
            String cus_name = resultSet.getString(2);
            String cus_address = resultSet.getString(3);
            String cus_email = resultSet.getString(4);
            String cus_contact = resultSet.getString(5);

            var entity = new CustomerEntity(cus_id, cus_name, cus_address, cus_email, cus_contact);
            customers.add(entity);
        }
        return customers;
    }

    @Override
    public CustomerEntity search(Connection connection,String id) throws SQLException {
        return null;
    }

    @Override
    public boolean update(Connection connection,CustomerEntity entity) throws SQLException {
        return SQLUtil.execute(connection,
                "UPDATE customer SET name = ?, address = ?, email = ?, contact = ?  WHERE id = ?",
                entity.getName(),
                entity.getAddress(),
                entity.getEmail(),
                entity.getContact(),
                entity.getId());
    }

    @Override
    public boolean delete(Connection connection,String id) throws SQLException {
        return SQLUtil.execute(connection,
                "DELETE FROM customer WHERE id = ?",
                id);
    }
}
