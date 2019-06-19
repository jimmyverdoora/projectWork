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

    public static List<RigaOrdineTO> getRigheOrdiniByFornitoreAndOrderId(int fornitoreId, int ordineId) {
        String query = "SELECT * FROM progettot1.rigaordine WHERE (articolo_id IN (" +

                "SELECT articolo.id FROM progettot1.articolo, progettot1.listino WHERE articolo.listino_id="
                + "listino.id AND listino.fornitore_id=" + fornitoreId +

                ") AND ordine_id=" + ordineId +");";
        return castToRigaOrdine(returnListOfTransferObjects(query));
    }

    public static RigaOrdineTO getRigaOrdineById(int id) {
        String query = "SELECT * FROM progettot1.rigaordine WHERE id=" + id + ";";
        return castToRigaOrdine(returnListOfTransferObjects(query)).get(0);
    }

    public static int createRigaOrdine(int ordine_id, int articolo_id, double prezzoUnitario, int quantita,
                                    String stato) {
        String query = "INSERT INTO progettot1.rigaordine (ordine_id, articolo_id, prezzounitario, quantita, stato)" +
                " VALUES ('" + ordine_id + "', '" + articolo_id + "', '" + prezzoUnitario + "', '" + quantita +
                "', '" + stato + "');";
        return performDBUpdate(query);
    }

    public static void changeStato(int id,  String stato) {
        String query = "UPDATE progettot1.rigaordine SET stato='" + stato + "' WHERE id=" + id + ";";
        performDBUpdate(query);
    }

    public static void changePrezzoAndQuantita(int id, double prezzo, int quantita) {
        String query = "UPDATE progettot1.rigaordine SET prezzounitario=" + prezzo + ", quantita=" + quantita +
                " WHERE id=" + id + ";";
        performDBUpdate(query);
    }

    static int editRigaOrdine(int id, int ordine_id, int articolo_id, double prezzoUnitario, int quantita,
                                    String stato) {
        String query = ""; //TODO
        return performDBUpdate(query);
    }

    static int deleteRigaOrdine(int id) {
        String query = ""; //TODO
        return performDBUpdate(query);
    }

    private static List<RigaOrdineTO> castToRigaOrdine(List<TO> lista) {
        List<RigaOrdineTO> newLista = new ArrayList<>();
        for (TO elemento : lista) {
            newLista.add((RigaOrdineTO) elemento);
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
