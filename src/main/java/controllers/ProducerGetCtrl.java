package controllers;


import dao.ProducerDAO;
import dao.SouvenirDAO;
import model.Producer;
import servlet.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProducerGetCtrl implements Controller {


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ProducerDAO producerDAO = new ProducerDAO();
        SouvenirDAO souvenirDAO = new SouvenirDAO();

        String idParameter = request.getParameter("id");

        if ( idParameter != null && !idParameter.isEmpty() ) {

            try {
                int id = Integer.parseInt(request.getParameter("id"));
                Producer producer = producerDAO.selectById(id);

                if (producer != null) {
                    producer.setSouvenirs(souvenirDAO.selectAll(producer.getId()));
                    request.setAttribute("producer", producer);
                    request.getServletContext()
                            .getRequestDispatcher("/WEB-INF/pages/producer-one.jsp")
                            .forward(request, response);
                    return;
                }

            } catch (NumberFormatException | ServletException | IOException ex) {
                Logger.getLogger(ProducerGetCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


        List<Producer> producers = producerDAO.selectAll();

        for (Producer producer : producers) {
            producer.setSouvenirs(souvenirDAO.selectAll(producer.getId()));
        }

        request.setAttribute("producers", producers);
        request.getServletContext()
                .getRequestDispatcher("/WEB-INF/pages/producer-list.jsp")
                .forward(request, response);

    }
}
