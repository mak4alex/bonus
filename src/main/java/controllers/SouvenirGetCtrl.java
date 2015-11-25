/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.ProducerDAO;
import dao.SouvenirDAO;
import model.Souvenir;
import servlet.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SouvenirGetCtrl implements Controller {


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ProducerDAO producerDAO = new ProducerDAO();
        SouvenirDAO souvenirDAO = new SouvenirDAO();

        String idParameter = request.getParameter("id");

        if ( idParameter != null && !idParameter.isEmpty() ) {

            try {
                int id = Integer.parseInt(request.getParameter("id"));

                Souvenir souvenir = souvenirDAO.selectById(id);

                if (souvenir != null) {
                    souvenir.setProducer(producerDAO.selectById(souvenir.getProducerId()));
                    request.setAttribute("souvenir", souvenir);
                    request.getServletContext()
                            .getRequestDispatcher("/WEB-INF/pages/souvenir-one.jsp")
                            .forward(request, response);
                    return;
                }

            } catch (NumberFormatException | ServletException | IOException ex) {
                Logger.getLogger(SouvenirGetCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        List<Souvenir> souvenirs = souvenirDAO.selectAll();

        for (Souvenir souvenir : souvenirs) {
            souvenir.setProducer(producerDAO.selectById(souvenir.getProducerId()));
        }

        request.setAttribute("souvenirs", souvenirs);
        request.getServletContext()
                .getRequestDispatcher("/WEB-INF/pages/souvenir-list.jsp")
                .forward(request, response);
    }


    
}
