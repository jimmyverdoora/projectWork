package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FornitoreDAO extends DAO {

    // main function, overrides DAO
    static FornitoreTO createTransferObject(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String username = rs.getString("username");
        String password = rs.getString("password");
        String nome = rs.getString("nome");
        String descrizione = rs.getString("descrizione");
        String email = rs.getString("email");
        return new FornitoreTO(id, username, password, nome, descrizione, email);
    }

    static List<TO> getFornitoriByNameOrDescription(String hint) {
        String query = ""; // TODO
        return returnListOfTransferObjects(query);
    }

    static List<TO> getFornitoriByArticoloNameOrDescriptionOrType(String hint) {
        String query = ""; // TODO
        return returnListOfTransferObjects(query);
    }

    static boolean createFornitore(int id, String username, String password, String nome, String descrizione,
                                   String email) {
        String query = ""; //TODO
        return performDBUpdate(query);
    }

    static boolean editFornitore(int id, String username, String password, String nome, String descrizione,
                                   String email) {
        // id is the id of the fornitore to be edited, the fields are the new fields, if a field is "", no edit
        String query = ""; //TODO
        return performDBUpdate(query);
    }

    static boolean deleteFornitore(int id) {
        String query = ""; //TODO
        return performDBUpdate(query);
    }
}
