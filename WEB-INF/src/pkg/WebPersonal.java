package pkg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


import com.oreilly.servlet.MultipartRequest;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import data.OrdineDAO;
import data.RigaOrdineDAO;
import generated.ObjectFactory;
import generated.OrderStructure;
import log.Generic;

public class WebPersonal extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// Istanzio le variabili
        String forw = null;
        try {
            int maxUploadSize = 50000000;
            MultipartRequest multi = new MultipartRequest(request, "/tmp", maxUploadSize);
            String descrizione = multi.getParameter("text");
            File nomefile = multi.getFile("uploadedxml");

            try {

                FileInputStream inStream = new FileInputStream(nomefile);

                ObjectFactory of = new ObjectFactory();

                try {
                    JAXBContext jaxbContext
                            = JAXBContext.newInstance
                            ("generated");

                    Unmarshaller unmarshaller =
                            jaxbContext.createUnmarshaller();

                    OrderStructure o = (OrderStructure) unmarshaller.unmarshal(inStream);
                    int key = OrdineDAO.createOrdine((int) request.getSession().getAttribute("ruoloId"));

                    if (key == -1) {
                        throw new IOException();
                    }

                    OrderStructure.Order order = o.getOrder();
                    for (OrderStructure.Order.OrderLines.OrderLine line : order.getOrderLines().getOrderLine()) {
                        int articolo_id = Integer.parseInt(line.getItemCode());
                        double prezzo = Double.parseDouble(line.getItemPrice());
                        int quantita = (int) line.getItemQty();
                        int tmpKey = RigaOrdineDAO.createRigaOrdine(key, articolo_id, prezzo, quantita, "OPEN");
                        if (tmpKey == -1) {
                            throw new IOException();
                        }
                    }

                } catch (Exception e) {
                    throw e;
                }


//close the stream
                inStream.close();

            } catch (Exception ioe) {
                throw ioe;
            }

            forw = "listaordini";


            RequestDispatcher rd = request.getRequestDispatcher(forw);
            rd.forward(request, response);
        }catch( JAXBException e) {
            e.printStackTrace();
        }
        catch(Exception e) {
            throw e;
        }
    }
}
