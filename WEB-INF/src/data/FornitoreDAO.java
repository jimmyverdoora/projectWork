package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FornitoreDAO extends DAO {

    // main function, overrides DAO
    private static TO createTransferObject(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String username = rs.getString("username");
        String password = rs.getString("password");
        String nome = rs.getString("nome");
        String descrizione = rs.getString("descrizione");
        String email = rs.getString("email");
        return new FornitoreTO(id, username, password, nome, descrizione, email);
    }

    public static int isFornitorePresent(String username, String password) {
        String query = "SELECT * FROM progetto.fornitore WHERE username='" + username +
                "' AND password='" + password + "';";;
        List<FornitoreTO> fornitori = castToFornitore(returnListOfTransferObjects(query));
        if (fornitori.size() > 0) {
            return fornitori.get(0).getId();
        }
        return -1;
    }

    public static FornitoreTO getFornitoreById(int id) {
        String query = "SELECT * FROM progetto.fornitore WHERE fornitore.id=" + id + ";";
        return castToFornitore(returnListOfTransferObjects(query)).get(0);
    }

    public static List<FornitoreTO> getFornitoriByNameOrDescription(String hint) {
        String query = "SELECT * FROM progetto.fornitore WHERE nome LIKE '" + hint + "' OR descrizione LIKE '" +
                hint + "';";
        return castToFornitore(returnListOfTransferObjects(query));
    }

    public static List<FornitoreTO> getFornitoriByArticoloNameOrDescriptionOrType(String hint) {
        String query = "SELECT * FROM progetto.fornitore WHERE progetto.fornitore.id IN" +
                " (SELECT fornitore_id FROM progetto.listino WHERE progetto.listino.id IN" +
                " (SELECT listino_id FROM progetto.articolo WHERE tipo LIKE '" + hint + "' OR descrizione LIKE '" +
                hint + "'));";
        return castToFornitore(returnListOfTransferObjects(query));
    }

    public static boolean createFornitore(String username, String password, String nome, String descrizione,
                                   String email) {
        String query = "INSERT INTO progetto.fornitore (username, password, nome, descrizione, email) VALUES ('" +
                username + "', '" + password + "', '" + nome + "', '" + descrizione + "', '" + email + "');";
        return performDBUpdate(query);
    }

    public static boolean editFornitore(int id, String username, String password, String nome, String descrizione,
                                   String email) {
        // id is the id of the fornitore to be edited, the fields are the new fields, if a field is "", no edit
        String query = ""; //TODO
        return performDBUpdate(query);
    }

    public static boolean deleteFornitore(int id) {
        String query = ""; //TODO
        return performDBUpdate(query);
    }

    private static List<FornitoreTO> castToFornitore(List<TO> lista) {
        List<FornitoreTO> newLista = new ArrayList<>();
        for (TO elemento : lista) {
            newLista.add((FornitoreTO) elemento);
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
