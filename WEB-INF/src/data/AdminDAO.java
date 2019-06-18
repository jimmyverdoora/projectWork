package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO extends DAO {

    public static int isAdminPresent(String username, String password) {
        String query = "SELECT * FROM progetto.admin WHERE username='" + username +
                "' AND password='" + password + "';";
        List<AdminTO> admins = castToAdmin(returnListOfTransferObjects(query));
        if (admins.size() > 0) {
            return admins.get(0).getId();
        }
        return -1;
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

    private static List<AdminTO> castToAdmin(List<TO> lista) {
        List<AdminTO> newLista = new ArrayList<>();
        for (TO elemento : lista) {
            newLista.add((AdminTO) elemento);
        }
        return newLista;
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
