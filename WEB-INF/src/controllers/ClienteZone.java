package controllers;

import com.sun.corba.se.impl.oa.toa.TOA;
import data.*;
import log.Generic;
import pkg.WebPersonal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ClienteZone extends Zone {

    static void execAction(String action, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
            HttpSession session = request.getSession();
            int id = (int) session.getAttribute("ruoloId");
            List<OrdineTO> lista = OrdineDAO.getOrdiniByClienteId(id);
            request.setAttribute("listaOrdini", lista);
            show("/ListaOrdini.jsp", request, response);
        }
        else if (action.equals("ordine")) {
            int ordineId;
            try {
                ordineId = Integer.parseInt(request.getParameter("ordineId"));
            }
            catch (Exception e) {
                ordineId = (int) request.getAttribute("ordineId");
            }
            List<FornitoreTO> tuttiFornitori = FornitoreDAO.getAllFornitori();
            List<FornitoreTO> fornitoriSelezionati = new ArrayList<>();
            Map<Integer, List<RigaOrdineTO>> mappaFornitoreRighe = new HashMap<>();
            for (FornitoreTO fornitore : tuttiFornitori) {
                List<RigaOrdineTO> tmpLista = RigaOrdineDAO.getRigheOrdiniByFornitoreAndOrderId(
                        fornitore.getId(), ordineId);
                if (tmpLista.size() > 0) {
                    fornitoriSelezionati.add(fornitore);
                    mappaFornitoreRighe.put(fornitore.getId(), tmpLista);
                }
            }
            Map<Integer, String> mappaIdNome = new HashMap<>();
            for (ArticoloTO articolo : ArticoloDAO.getArticoliByOrdineId(ordineId)) {
                mappaIdNome.put(articolo.getId(), articolo.getNome());
            }
            request.setAttribute("mappaFornitori", mappaFornitoreRighe);
            request.setAttribute("mappaArticoli", mappaIdNome);
            request.setAttribute("listaFornitori", fornitoriSelezionati);
            request.setAttribute("idOrdine", ordineId);
            show("/Ordine.jsp", request, response);
        }

        else if (action.equals("upload")) {
            WebPersonal upload = new WebPersonal();
            upload.service(request, response);
        }

        else if (action.equals("conferma")) {
            int id = Integer.parseInt(request.getParameter("rid"));
            RigaOrdineDAO.changeStato(id, "CONFERMATA");
            int ordineId = RigaOrdineDAO.getRigaOrdineById(id).getOrdine_id();
            request.setAttribute("ordineId", ordineId);
            execAction("ordine", request, response);
        }

        else if (action.equals("rigetta")) {
            int id = Integer.parseInt(request.getParameter("rid"));
            RigaOrdineDAO.changeStato(id, "RIGETTATA");
            int ordineId = RigaOrdineDAO.getRigaOrdineById(id).getOrdine_id();
            request.setAttribute("ordineId", ordineId);
            execAction("ordine", request, response);
        }
    }
}
