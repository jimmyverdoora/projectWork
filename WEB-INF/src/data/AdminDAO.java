package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO extends DAO {

    public static boolean isAdminPresent(String username, String password) {
        String query = "SELECT * FROM progetto.admin WHERE username='" + username +
                "' AND password='" + password + "';";
        List<TO> admins = returnListOfTransferObjects(query);
        return (admins.size() > 0);
    }

    public static boolean createAdmin(String username, String password) {
        String query = "INSERT INTO progetto.admin (username, password) VALUES ('" +
                username + "', '" + password + "');";
        return performDBUpdate(query);
    }

    private static AdminTO createTransferObject(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String username = rs.getString("username");
        String password = rs.getString("password");
        return new AdminTO(id, username, password);
    }

    private static List<TO> returnListOfTransferObjects(String query) {
        List<TO> listOfTransferObjects = new ArrayList<>();
        try {

            Connection conn = DBUtil.getDataSource().getConnection();
            Statement stmt;
            stmt = conn.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                listOfTransferObjects.add(createTransferObject(rs));
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfTransferObjects;
    }
}
