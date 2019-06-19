package controllers;

import data.AdminDAO;
import data.ClienteDAO;
import data.FornitoreDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

class RegistrationEngine {

    static void performRegistration(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String ruolo = request.getParameter("ruolo");
        String nome = request.getParameter("nome");
        String descrizione = request.getParameter("descrizione");
        String email = request.getParameter("email");

        if (valid(ruolo, username, password, nome, descrizione, email)) {
            LoginEngine.performLogin(request, response);
        }
        else {
            response.sendRedirect("");
        }
    }

    private static boolean valid(String ruolo, String username, String password, String nome, String descrizione,
                                 String email) {


        if (ruolo.equals("cliente")) {
            return (ClienteDAO.createCliente(username, password, nome, descrizione, email) > 0);
        }
        else if (ruolo.equals("fornitore")) {
            return (FornitoreDAO.createFornitore(username, password, nome, descrizione, email) > 0);
        }
        else if (ruolo.equals("admin")) {
            return (AdminDAO.createAdmin(username, password) > 0);
        }
        else {
            return false;
        }
    }
}
