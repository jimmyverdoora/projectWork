package controllers;

import com.sun.corba.se.impl.oa.toa.TOA;
import data.FornitoreDAO;
import data.FornitoreTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ClienteZone extends Zone {

    static void execAction(String action, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //TODO: attach data to requests using DAOs

        if (action.equals("home")) {
            show("/HomeCliente.jsp", request, response);
        }
        else if (action.equals("listafornitori")) {
            String parolaChiave = request.getParameter("parolaChiave");
            String ruolo = request.getParameter("ruolo");
            List<FornitoreTO> lista;
            if (ruolo.equals("articolo")) {
                lista = FornitoreDAO.getFornitoriByArticoloNameOrDescriptionOrType(parolaChiave);
            }
            else {
                lista = FornitoreDAO.getFornitoriByNameOrDescription(parolaChiave);
            }
            request.setAttribute("listaFornitori", lista);
            show("/ListaFornitori.jsp?a=1", request, response);
        }
        else if (action.equals("dettagliofornitore")) {
            show("DettaglioFornitore.jsp", request, response);
        }
        else if (action.equals("listaarticoli")) {
            show("ListaArticoli.jsp", request, response);
        }
        else if (action.equals("listaordini")) {
            show("ListaOrdini.jsp", request, response);
        }
        else if (action.equals("ordine")) {
            show("Ordine.jsp", request, response);
        }
    }
}
