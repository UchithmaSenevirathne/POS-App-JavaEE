package lk.ijse.posbackend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLUtil {
    public static <T> T execute(Connection connection, String query, Object...args) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(query);

        for (int i = 0; i < args.length; i++) {
            pstm.setObject((i+1), args[i]);
        }

        if(query.toUpperCase().startsWith("SELECT")){
            return (T)pstm.executeQuery();
        }
        return (T)(Boolean)(pstm.executeUpdate() > 0);
    }

}
