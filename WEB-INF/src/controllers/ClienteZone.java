package controllers;

import data.FornitoreTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class ClienteZone extends Zone {

    static void execAction(String action, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //TODO: attach data to requests using DAOs

        if (action.equals("home")) {
            show("HomeCliente.jsp", request, response);
        }
        else if (action.equals("listafornitori")) {
            show("ListaFornitori.jsp", request, response);
        }
        else if (action.equals("listalistini")) {
            show("ListaListini.jsp", request, response);
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
