package controllers;

import data.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

class FornitoreZone extends Zone {

    static void execAction(String action, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //TODO: attach data to requests using DAOs

        if (action.equals("home")) {
            HttpSession session = request.getSession();
            int id = (int) session.getAttribute("ruoloId");
            FornitoreTO fornitore = FornitoreDAO.getFornitoreById(id);
            request.setAttribute("fornitore", fornitore);
            List<ListinoTO> lista = ListinoDAO.getListiniByFornitoreId(id);
            request.setAttribute("listaListini", lista);
            show("/HomeFornitore.jsp", request, response);
        }

        else if (action.equals("aggiungilistino")) {
            HttpSession session = request.getSession();
            int id = (int) session.getAttribute("ruoloId");
            ListinoDAO.createListino(id, request.getParameter("nome"), request.getParameter("descrizione"));
            response.sendRedirect("home");
        }

        else if (action.equals("listaarticoli")) {
            int id = Integer.parseInt(request.getParameter("lid"));
            ListinoTO listino = ListinoDAO.getListinoById(id);
            request.setAttribute("listino", listino);
            FornitoreTO fornitore = FornitoreDAO.getFornitoreById(listino.getFornitore_id());
            request.setAttribute("fornitore", fornitore);
            List<ArticoloTO> lista = ArticoloDAO.getArticoliByListinoId(id);
            request.setAttribute("listaArticoli", lista);
            show("/ListaArticoliFornitore.jsp", request, response);
        }

        else if (action.equals("aggiungiarticolo")) {
            int id = Integer.parseInt(request.getParameter("lid"));
            double prezzo = Double.parseDouble(request.getParameter("prezzo"));
            ArticoloDAO.createArticolo(id, prezzo, request.getParameter("nome"),
                    request.getParameter("descrizione"), request.getParameter("tipo"));
            execAction("listaarticoli", request, response);
        }

        else if (action.equals("listaordini")) {
            show("/ListaOrdiniFornitore.jsp", request, response);
        }
        else if (action.equals("ordine")) {
            show("/OrdineFornitore.jsp", request, response);
        }
    }

}
