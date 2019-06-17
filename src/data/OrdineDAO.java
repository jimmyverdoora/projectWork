package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrdineDAO extends DAO {

    // main function, overrides DAO
    static OrdineTO createTransferObject(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int cliente_id = rs.getInt("cliente_id");
        return new OrdineTO(id, cliente_id);
    }

    static List<TO> getOrdiniByClienteId(int id) {
        String query = ""; // TODO
        return returnListOfTransferObjects(query);
    }

    static boolean createOrdine(int id, int fornitore_id) {
        String query = ""; //TODO
        return performDBUpdate(query);
    }

    static boolean deleteOrdine(int id) {
        String query = ""; //TODO
        return performDBUpdate(query);
    }
}
