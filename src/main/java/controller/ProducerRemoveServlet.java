package controller;

import dao.ProducerDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * class ProducerRemoveServlet удаляет
 * производителя по идентификатору.
 *
 */

public class ProducerRemoveServlet extends HttpServlet {
   
    private final ProducerDAO producerDAO = new ProducerDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idParameter = request.getParameter("id");
        
        if ( idParameter != null && !idParameter.isEmpty() ) {
        
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                producerDAO.delete(id);
            } catch (NumberFormatException ex) {
                Logger.getLogger(ProducerRemoveServlet.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }        

        getServletContext()
                .getRequestDispatcher("/producer")
                .forward(request, response);     
    } 

}
