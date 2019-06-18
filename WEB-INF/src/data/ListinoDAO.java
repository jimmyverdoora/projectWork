package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ListinoDAO extends DAO {

    // main function, overrides DAO
    static ListinoTO createTransferObject(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int fornitore_id = rs.getInt("fornitore_id");
        String descrizione = rs.getString("descrizione");
        return new ListinoTO(id, fornitore_id, descrizione);
    }

    static List<TO> getListiniByFornitoreId(int id) {
        String query = ""; // TODO
        return returnListOfTransferObjects(query);
    }

    static boolean createListino(int id, int fornitore_id, String descrizione) {
        String query = ""; //TODO
        return performDBUpdate(query);
    }

    static boolean editListino(int id, int fornitore_id, String descrizione) {
        // id is the id of the fornitore to be edited, the fields are the new fields, if a field is "", no edit
        String query = ""; //TODO
        return performDBUpdate(query);
    }

    static boolean deleteListino(int id) {
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
