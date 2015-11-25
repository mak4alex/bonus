package controllers;

import dao.ProducerDAO;
import model.Producer;
import servlet.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ProducerGetFormCtrl implements Controller {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ProducerDAO producerDAO = new ProducerDAO();

        String idParameter = request.getParameter("id");

        if (idParameter != null && !idParameter.isEmpty()) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));

                Producer producer = producerDAO.selectById(id);
                request.setAttribute("producer", producer);
            } catch (NumberFormatException ex) {
                Logger.getLogger(ProducerGetFormCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        request.getServletContext()
                .getRequestDispatcher("/WEB-INF/pages/producer-form.jsp")
                .forward(request, response);
    }
}
