package controllers;

import dao.ProducerDAO;
import dao.SouvenirDAO;
import model.Souvenir;
import servlet.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SouvenirGetFormCtrl implements Controller {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ProducerDAO producerDAO = new ProducerDAO();
        SouvenirDAO souvenirDAO = new SouvenirDAO();

        String idParameter = request.getParameter("id");

        if (idParameter != null && !idParameter.isEmpty()) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));

                Souvenir souvenir = souvenirDAO.selectById(id);
                request.setAttribute("souvenir", souvenir);
            } catch (NumberFormatException ex) {
                Logger.getLogger(SouvenirGetFormCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        request.setAttribute("producers", producerDAO.selectAll());

        request.getServletContext()
                .getRequestDispatcher("/WEB-INF/pages/souvenir-form.jsp")
                .forward(request, response);
    }

}
