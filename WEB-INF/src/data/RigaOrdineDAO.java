package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RigaOrdineDAO extends DAO {

    // main function, overrides DAO
    private static RigaOrdineTO createTransferObject(ResultSet rs) throws SQLException {
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
