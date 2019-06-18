package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends DAO {

    // main function, overrides DAO
    static ClienteTO createTransferObject(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String username = rs.getString("username");
        String password = rs.getString("password");
        String nome = rs.getString("nome");
        String descrizione = rs.getString("descrizione");
        String email = rs.getString("email");
        return new ClienteTO(id, username, password, nome, descrizione, email);
    }

    public static boolean isClientePresent(String username, String password) {
        String query = "SELECT * FROM progetto.cliente WHERE username='" + username +
                "' AND password='" + password + "';";;
        List<TO> clienti = returnListOfTransferObjects(query);
        return (clienti.size() > 0);
    }

    public static List<TO> getClientiByNameOrDescription(String hint) {
        String query = ""; // TODO
        return returnListOfTransferObjects(query);
    }

    public static boolean createCliente(String username, String password, String nome, String descrizione,
                                   String email) {
        String query = "INSERT INTO progetto.cliente (username, password, nome, descrizione, email) VALUES ('" +
                username + "', '" + password + "', '" + nome + "', '" + descrizione + "', '" + email + "');";
        return performDBUpdate(query);
    }

    public static boolean editCliente(int id, String username, String password, String nome, String descrizione,
                                   String email) {
        // id is the id of the fornitore to be edited, the fields are the new fields, if a field is "", no edit
        String query = ""; //TODO
        return performDBUpdate(query);
    }

    public static boolean deleteCliente(int id) {
        String query = ""; //TODO
        return performDBUpdate(query);
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
