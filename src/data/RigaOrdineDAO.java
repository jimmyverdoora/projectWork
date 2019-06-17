package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RigaOrdineDAO extends DAO {

    // main function, overrides DAO
    static RigaOrdineTO createTransferObject(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int ordine_id = rs.getInt("ordine_id");
        int articolo_id = rs.getInt("articolo_id");
        double prezzoUnitario = rs.getDouble("prezzounitario");
        int quantita = rs.getInt("quantita");
        String stato = rs.getString("stato");
        return new RigaOrdineTO(id, ordine_id, articolo_id, prezzoUnitario, quantita, stato);
    }

    static List<TO> getRigheOrdiniByOrdineId(int id) {
        String query = ""; // TODO
        return returnListOfTransferObjects(query);
    }

    static boolean createRigaOrdine(int id, int ordine_id, int articolo_id, double prezzoUnitario, int quantita,
                                    String stato) {
        String query = ""; //TODO
        return performDBUpdate(query);
    }

    static boolean editRigaOrdine(int id, int ordine_id, int articolo_id, double prezzoUnitario, int quantita,
                                    String stato) {
        String query = ""; //TODO
        return performDBUpdate(query);
    }

    static boolean deleteRigaOrdine(int id) {
        String query = ""; //TODO
        return performDBUpdate(query);
    }
}
