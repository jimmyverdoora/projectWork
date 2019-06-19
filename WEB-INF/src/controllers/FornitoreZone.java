package controllers;

import data.*;
import log.Generic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            int quantita = Integer.parseInt(request.getParameter("quantita"));
            ArticoloDAO.createArticolo(id, prezzo, quantita, request.getParameter("nome"),
                    request.getParameter("descrizione"), request.getParameter("tipo"));
            execAction("listaarticoli", request, response);
        }

        else if (action.equals("listaordini")) {
            HttpSession session = request.getSession();
            int id = (int) session.getAttribute("ruoloId");
            List<OrdineTO> lista = OrdineDAO.getOrdiniByFornitoreId(id);
            request.setAttribute("listaOrdini", lista);
            show("/ListaOrdiniFornitore.jsp", request, response);
        }
        else if (action.equals("ordine")) {
            int id = (int) request.getSession().getAttribute("ruoloId");
            int ordineId;
            try {
                ordineId = Integer.parseInt(request.getParameter("ordineId"));
            }
            catch (Exception e) {
                ordineId = (int) request.getAttribute("ordineId");
            }
            List<RigaOrdineTO> listaRighe = RigaOrdineDAO.getRigheOrdiniByFornitoreAndOrderId(id, ordineId);

            Map<Integer, String> mappaIdNome = new HashMap<>();
            for (ArticoloTO articolo : ArticoloDAO.getArticoliByOrdineId(ordineId)) {
                mappaIdNome.put(articolo.getId(), articolo.getNome());
            }
            request.setAttribute("listaRighe", listaRighe);
            request.setAttribute("mappaArticoli", mappaIdNome);
            request.setAttribute("idOrdine", ordineId);
            show("/OrdineFornitore.jsp", request, response);
        }

        else if (action.equals("modifica")) {
            int id = Integer.parseInt(request.getParameter("rid"));
            double prezzo = Double.parseDouble(request.getParameter("prezzo"));
            int quantita = Integer.parseInt(request.getParameter("quantita"));
            int quantitaInMagazzino = ArticoloDAO.getQuantitaByRigaId(id);
            if (quantita <= quantitaInMagazzino) {
                RigaOrdineDAO.changeStato(id, "MODIFICATA");
                RigaOrdineDAO.changePrezzoAndQuantita(id, prezzo, quantita);
            }
            int ordineId = RigaOrdineDAO.getRigaOrdineById(id).getOrdine_id();
            request.setAttribute("ordineId", ordineId);
            execAction("ordine", request, response);
        }
    }

}
