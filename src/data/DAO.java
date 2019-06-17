package data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

class DAO {

    static List<TO> returnListOfTransferObjects(String query) {
        List<TO> listOfTransferObjects = new ArrayList<>();
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://root:root@192.168.8.55/progetto?serverTimezone=" + TimeZone.getDefault().getID());

            Statement stmt;
            stmt = conn.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                listOfTransferObjects.add(createTransferObject(rs));
            }
            stmt.close();
            conn.close();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return listOfTransferObjects;
    }

    static boolean performDBUpdate(String query) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://root:root@192.168.8.55/progetto?serverTimezone=" + TimeZone.getDefault().getID());

            Statement stmt;
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    static TO createTransferObject(ResultSet rs) throws InstantiationException, IllegalAccessException {
        return null;
    }

}
