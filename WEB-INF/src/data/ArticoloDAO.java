package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArticoloDAO extends DAO {

    // main function, overrides DAO
    private static ArticoloTO createTransferObject(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int listino_id = rs.getInt("listino_id");
        double prezzo = rs.getDouble("prezzo");
        String nome = rs.getString("nome");
        String descrizione = rs.getString("descrizione");
        String tipo = rs.getString("tipo");
        return new ArticoloTO(id, listino_id, prezzo, nome, descrizione, tipo);
    }

    public static List<ArticoloTO> getArticoliByListinoId(int id) {
        String query = "SELECT * FROM progettot1.articolo WHERE progettot1.articolo.listino_id=" + id + ";";
        return castToArticolo(returnListOfTransferObjects(query));
    }

    public static List<ArticoloTO> getArticoliByOrdineId(int id) {
        String query = "SELECT * FROM progettot1.articolo WHERE articolo.id IN (" +
                "SELECT articolo_id FROM progettot1.rigaordine WHERE rigaordine.ordine_id=" + id +
                ");";
        return castToArticolo(returnListOfTransferObjects(query));
    }

    public static int createArticolo(int listino_id, double prezzo, String nome, String descrizione, String tipo) {
        String query = "INSERT INTO progettot1.articolo (listino_id, prezzo, nome, descrizione, tipo) VALUES ('" +
                listino_id + "', '" + prezzo + "', '" + nome + "', '" + descrizione + "', '" + tipo + "');";
        return performDBUpdate(query);
    }

    static int editArticolo(int id, int listino_id, double prezzo, String nome, String descrizione, String tipo) {
        // id is the id of the fornitore to be edited, the fields are the new fields, if a field is "", no edit
        String query = ""; //TODO
        return performDBUpdate(query);
    }

    static int deleteArticolo(int id) {
        String query = ""; //TODO
        return performDBUpdate(query);
    }

    private static List<ArticoloTO> castToArticolo(List<TO> lista) {
        List<ArticoloTO> newLista = new ArrayList<>();
        for (TO elemento : lista) {
            newLista.add((ArticoloTO) elemento);
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
