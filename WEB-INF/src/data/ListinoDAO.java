package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ListinoDAO extends DAO {

    // main function, overrides DAO
    private static ListinoTO createTransferObject(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int fornitore_id = rs.getInt("fornitore_id");
        String nome = rs.getString("nome");
        String descrizione = rs.getString("descrizione");
        return new ListinoTO(id, fornitore_id, nome, descrizione);
    }

    public static List<ListinoTO> getListiniByFornitoreId(int id) {
        String query = "SELECT * FROM progetto.listino WHERE progetto.listino.fornitore_id=" + id + ";";
        return castToListino(returnListOfTransferObjects(query));
    }

    public static ListinoTO getListinoById(int id) {
        String query = "SELECT * FROM progetto.listino WHERE progetto.listino.id=" + id + ";";
        return castToListino(returnListOfTransferObjects(query)).get(0);
    }

    public static boolean createListino(int fornitore_id, String nome, String descrizione) {
        String query = "INSERT INTO progetto.listino (fornitore_id, nome, descrizione) VALUES ('" +
                fornitore_id + "', '" + nome + "', '" + descrizione + "');";
        return performDBUpdate(query);
    }

    public static boolean editListino(int id, int fornitore_id, String nome, String descrizione) {
        // id is the id of the fornitore to be edited, the fields are the new fields, if a field is "", no edit
        String query = ""; //TODO
        return performDBUpdate(query);
    }

    public static boolean deleteListino(int id) {
        String query = ""; //TODO
        return performDBUpdate(query);
    }

    private static List<ListinoTO> castToListino(List<TO> lista) {
        List<ListinoTO> newLista = new ArrayList<>();
        for (TO elemento : lista) {
            newLista.add((ListinoTO) elemento);
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
