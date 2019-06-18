package data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import log.Generic;

class DAO {

    static boolean performDBUpdate(String query) {
        try {

            Connection conn = DBUtil.getDataSource().getConnection();
            Statement stmt;
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
