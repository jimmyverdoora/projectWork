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

    public static List<OrdineTO> getOrdiniByClienteId(int id) {
        String query = "SELECT * FROM progettot1.ordine WHERE progettot1.ordine.cliente_id=" + id + ";";
        return castToOrdine(returnListOfTransferObjects(query));
    }

    public static List<OrdineTO> getOrdiniByFornitoreId(int id) {
        String query = "SELECT * FROM progettot1.ordine WHERE id IN (" +

                "SELECT ordine_id FROM progettot1.rigaordine WHERE articolo_id IN (" +

                "SELECT articolo.id FROM progettot1.articolo, progettot1.listino WHERE articolo.listino_id=" +
                "listino.id AND listino.fornitore_id=" + id +

                ")" +
                ");";
        return castToOrdine(returnListOfTransferObjects(query));
    }

    public static int createOrdine(int cliente_id) {
        String query = "INSERT INTO progettot1.ordine (cliente_id) VALUES ('" +
                cliente_id + "');";
        return performDBUpdate(query);
    }

    static int deleteOrdine(int id) {
        String query = ""; //TODO
        return performDBUpdate(query);
    }

    private static List<OrdineTO> castToOrdine(List<TO> lista) {
        List<OrdineTO> newLista = new ArrayList<>();
        for (TO elemento : lista) {
            newLista.add((OrdineTO) elemento);
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
