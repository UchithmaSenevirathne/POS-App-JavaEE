package lk.ijse.posbackend.bo.custom.impl;

import lk.ijse.posbackend.bo.custom.ItemBO;
import lk.ijse.posbackend.dao.DAOFactory;
import lk.ijse.posbackend.dao.custom.CustomerDAO;
import lk.ijse.posbackend.dao.custom.ItemDAO;
import lk.ijse.posbackend.dto.CutomerDTO;
import lk.ijse.posbackend.dto.ItemDTO;
import lk.ijse.posbackend.entity.CustomerEntity;
import lk.ijse.posbackend.entity.ItemEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public boolean updateItem(ItemDTO dto, Connection connection) throws SQLException {
        return itemDAO.update(connection,new ItemEntity(dto.getId(),
                dto.getName(),
                dto.getDescription(),
                dto.getUnit_price()));
    }

    @Override
    public boolean saveItem(ItemDTO dto, Connection connection) throws SQLException {
        return itemDAO.save(connection,new ItemEntity(dto.getId(),
                dto.getName(),
                dto.getDescription(),
                dto.getUnit_price()));
    }

    @Override
    public List<ItemDTO> getAllItems(Connection connection) throws SQLException {
        List<ItemEntity> itemEntities = itemDAO.getAll(connection);
        List<ItemDTO> itemDTOS = new ArrayList<>();

        for (ItemEntity item : itemEntities){
            itemDTOS.add(new ItemDTO(item.getId(),
                    item.getName(),
                    item.getDescription(),
                    item.getUnit_price()));
        }
        return itemDTOS;
    }

    @Override
    public boolean deleteItem(String id, Connection connection) throws SQLException {
        System.out.println("bo.........."+id);
        return itemDAO.delete(connection, id);
    }
}
