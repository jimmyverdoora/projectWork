package controllers;

import com.sun.corba.se.impl.oa.toa.TOA;
import data.*;
import log.Generic;

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
            show("/ListaFornitori.jsp", request, response);
        }
        else if (action.equals("dettagliofornitore")) {
            int id = Integer.parseInt(request.getParameter("fid"));
            FornitoreTO fornitore = FornitoreDAO.getFornitoreById(id);
            request.setAttribute("fornitore", fornitore);
            List<ListinoTO> lista = ListinoDAO.getListiniByFornitoreId(id);
            request.setAttribute("listaListini", lista);
            show("/DettaglioFornitore.jsp", request, response);
        }
        else if (action.equals("listaarticoli")) {
            int id = Integer.parseInt(request.getParameter("lid"));
            ListinoTO listino = ListinoDAO.getListinoById(id);
            request.setAttribute("listino", listino);
            FornitoreTO fornitore = FornitoreDAO.getFornitoreById(listino.getFornitore_id());
            request.setAttribute("fornitore", fornitore);
            List<ArticoloTO> lista = ArticoloDAO.getArticoliByListinoId(id);
            request.setAttribute("listaArticoli", lista);
            show("/ListaArticoli.jsp", request, response);
        }
        else if (action.equals("listaordini")) {
            show("/ListaOrdini.jsp", request, response);
        }
        else if (action.equals("ordine")) {
            show("/Ordine.jsp", request, response);
        }
    }
}
