package data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import log.Generic;

class DAO {

    static int performDBUpdate(String query) {
        int key = -1;
        try {

            Connection conn = DBUtil.getDataSource().getConnection();
            Statement stmt;
            stmt = conn.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = stmt.getGeneratedKeys();
            if (keys.next()) {
                key = keys.getInt(1);
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
        return key;
    }

}
