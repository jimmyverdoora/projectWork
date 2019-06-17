package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ArticoloDAO extends DAO {

    // main function, overrides DAO
    static ArticoloTO createTransferObject(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int listino_id = rs.getInt("listino_id");
        double prezzo = rs.getDouble("prezzo");
        String nome = rs.getString("nome");
        String descrizione = rs.getString("descrizione");
        String tipo = rs.getString("tipo");
        return new ArticoloTO(id, listino_id, prezzo, nome, descrizione, tipo);
    }

    static List<TO> getArticoliByListinoId(int id) {
        String query = ""; // TODO
        return returnListOfTransferObjects(query);
    }

    static boolean createArticolo(int id, int listino_id, double prezzo, String nome, String descrizione, String tipo) {
        String query = ""; //TODO
        return performDBUpdate(query);
    }

    static boolean editArticolo(int id, int listino_id, double prezzo, String nome, String descrizione, String tipo) {
        // id is the id of the fornitore to be edited, the fields are the new fields, if a field is "", no edit
        String query = ""; //TODO
        return performDBUpdate(query);
    }

    static boolean deleteArticolo(int id) {
        String query = ""; //TODO
        return performDBUpdate(query);
    }
}
