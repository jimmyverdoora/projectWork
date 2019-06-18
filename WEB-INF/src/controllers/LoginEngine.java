package controllers;

import data.AdminDAO;
import data.ClienteDAO;
import data.FornitoreDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

class LoginEngine {

    static void performLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String ruolo = request.getParameter("ruolo");

        int key = authenticate(ruolo, username, password);
        if (key > -1) {
            HttpSession session = request.getSession();
            session.setAttribute("ruolo", ruolo);
            session.setAttribute("ruoloId", key);
            response.sendRedirect(ruolo + "/home");
        }
        else {
            response.sendRedirect("");
        }
    }

    private static int authenticate(String ruolo, String username, String password) {

        if (ruolo.equals("cliente")) {
            return ClienteDAO.isClientePresent(username, password);
        }
        else if (ruolo.equals("fornitore")) {
            return FornitoreDAO.isFornitorePresent(username, password);
        }
        else if (ruolo.equals("admin")) {
            return AdminDAO.isAdminPresent(username, password);
        }
        else {
            return -1;
        }
    }
}
