package lk.ijse.posbackend.bo.custom.impl;

import lk.ijse.posbackend.bo.custom.CustomerBO;
import lk.ijse.posbackend.dao.DAOFactory;
import lk.ijse.posbackend.dao.custom.CustomerDAO;
import lk.ijse.posbackend.dto.CutomerDTO;
import lk.ijse.posbackend.entity.CustomerEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    @Override
    public boolean updateCustomer(CutomerDTO dto, Connection connection) throws SQLException {
        return false;
    }

    @Override
    public boolean saveCustomer(CutomerDTO dto, Connection connection) throws SQLException {
        return customerDAO.save(connection,new CustomerEntity(dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getEmail(),
                dto.getContact()));
    }

    @Override
    public List<CutomerDTO> getAllCustomers(Connection connection) throws SQLException {
        List<CustomerEntity> customerEntities = customerDAO.getAll(connection);
        List<CutomerDTO> cutomerDTOS = new ArrayList<>();

        for (CustomerEntity customer : customerEntities){
            cutomerDTOS.add(new CutomerDTO(customer.getId(),
                    customer.getName(),
                    customer.getAddress(),
                    customer.getEmail(),
                    customer.getContact()));
        }
        return cutomerDTOS;
    }

    @Override
    public boolean deleteCustomer(String id, Connection connection) throws SQLException {
        return false;
    }

    @Override
    public CutomerDTO getOneCustomer(Connection connection, String data) {
        return null;
    }
}
