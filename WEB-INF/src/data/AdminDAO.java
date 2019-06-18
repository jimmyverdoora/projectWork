package data;

import java.sql.ResultSet;
import java.sql.SQLException;
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
}
