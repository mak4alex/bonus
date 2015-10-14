package controller;


import dao.SouvenirDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * class SouvenirRemoveServlet удаляет
 * сувенир по идентификатору.
 *
 */



public class SouvenirRemoveServlet extends HttpServlet {

    private final SouvenirDAO souvenirDAO = new SouvenirDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idParameter = request.getParameter("id");
        
        if ( idParameter != null && !idParameter.isEmpty() ) {
        
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                souvenirDAO.delete(id);
            } catch (NumberFormatException ex) {
                Logger.getLogger(SouvenirRemoveServlet.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }        

        getServletContext()
                .getRequestDispatcher("/souvenir")
                .forward(request, response);     
    } 
}
