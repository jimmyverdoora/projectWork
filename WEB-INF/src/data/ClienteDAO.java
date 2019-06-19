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

    public static int isClientePresent(String username, String password) {
        String query = "SELECT * FROM progettot1.cliente WHERE username='" + username +
                "' AND password='" + password + "';";;
        List<ClienteTO> clienti = castToCliente(returnListOfTransferObjects(query));
        if (clienti.size() > 0) {
            return clienti.get(0).getId();
        }
        return -1;
    }

    public static List<TO> getClientiByNameOrDescription(String hint) {
        String query = ""; // TODO
        return returnListOfTransferObjects(query);
    }

    public static int createCliente(String username, String password, String nome, String descrizione,
                                   String email) {
        String query = "INSERT INTO progettot1.cliente (username, password, nome, descrizione, email) VALUES ('" +
                username + "', '" + password + "', '" + nome + "', '" + descrizione + "', '" + email + "');";
        return performDBUpdate(query);
    }

    public static int editCliente(int id, String username, String password, String nome, String descrizione,
                                   String email) {
        // id is the id of the fornitore to be edited, the fields are the new fields, if a field is "", no edit
        String query = ""; //TODO
        return performDBUpdate(query);
    }

    public static int deleteCliente(int id) {
        String query = ""; //TODO
        return performDBUpdate(query);
    }

    private static List<ClienteTO> castToCliente(List<TO> lista) {
        List<ClienteTO> newLista = new ArrayList<>();
        for (TO elemento : lista) {
            newLista.add((ClienteTO) elemento);
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
