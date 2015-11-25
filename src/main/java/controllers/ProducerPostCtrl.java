package controllers;


import dao.ProducerDAO;
import model.Producer;
import servlet.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProducerPostCtrl implements Controller {


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ProducerDAO producerDAO = new ProducerDAO();

        String idParameter = request.getParameter("id");
        String name = request.getParameter("name");
        String country = request.getParameter("country");

        Producer producer = new Producer();
        producer.setName(name);
        producer.setCountry(country);

        if (idParameter != null &&  !idParameter.isEmpty()) {

            try {
                int id = Integer.parseInt(request.getParameter("id"));
                producerDAO.update(id, producer);

                response.sendRedirect(request.getContextPath() + "/producer?id=" + id);
                return;
            } catch (NumberFormatException | IOException ex) {
                Logger.getLogger(ProducerPostCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        producerDAO.insert(producer);

        response.sendRedirect(request.getContextPath() + "/producer");

    }
}
