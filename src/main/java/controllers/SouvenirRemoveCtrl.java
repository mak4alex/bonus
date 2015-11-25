package controllers;


import dao.SouvenirDAO;
import servlet.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;



public class SouvenirRemoveCtrl implements Controller {


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SouvenirDAO souvenirDAO = new SouvenirDAO();

        String idParameter = request.getParameter("id");

        if ( idParameter != null && !idParameter.isEmpty() ) {

            try {
                int id = Integer.parseInt(request.getParameter("id"));
                souvenirDAO.delete(id);
            } catch (NumberFormatException ex) {
                Logger.getLogger(SouvenirRemoveCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        request.getServletContext()
                .getRequestDispatcher("/souvenir")
                .forward(request, response);
    }

}
