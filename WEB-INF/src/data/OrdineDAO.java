package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
