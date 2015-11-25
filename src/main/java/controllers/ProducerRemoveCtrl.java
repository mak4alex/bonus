package controllers;

import dao.ProducerDAO;
import servlet.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ProducerRemoveCtrl implements Controller {
   
    private final ProducerDAO producerDAO = new ProducerDAO();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String idParameter = request.getParameter("id");

        if ( idParameter != null && !idParameter.isEmpty() ) {

            try {
                int id = Integer.parseInt(request.getParameter("id"));
                producerDAO.delete(id);
            } catch (NumberFormatException ex) {
                Logger.getLogger(ProducerRemoveCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        request.getServletContext()
                .getRequestDispatcher("/producer")
                .forward(request, response);
    }
}
