package controller;


import dao.ProducerDAO;
import dao.SouvenirDAO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Producer;

/**
 *
 * class ProducerGetServlet выводит
 * производителя при указании его
 * идентификатора. Иначе выводится список
 * всех производителей.
 *
 */

public class ProducerGetServlet extends HttpServlet {

    ProducerDAO producerDAO = new ProducerDAO();
    SouvenirDAO souvenirDAO = new SouvenirDAO();
  
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idParameter = request.getParameter("id");
        
        if ( idParameter != null && !idParameter.isEmpty() ) {
            
            try {            
                int id = Integer.parseInt(request.getParameter("id"));            
                Producer producer = producerDAO.selectById(id);
                
                if (producer != null) {                    
                    producer.setSouvenirs(souvenirDAO.selectAll(producer.getId()));
                    request.setAttribute("producer", producer);
                    getServletContext()
                            .getRequestDispatcher("/WEB-INF/pages/producer-one.jsp")
                            .forward(request, response);
                    return;                    
                }                
                    
            } catch (NumberFormatException | ServletException | IOException ex) {
                Logger.getLogger(SouvenirDAO.class.getName()).log(Level.SEVERE, null, ex);
            }       
            
        }
        
       
        List<Producer> producers = producerDAO.selectAll();
        
        for (Producer producer : producers) {
            producer.setSouvenirs(souvenirDAO.selectAll(producer.getId()));            
        }        
        
        request.setAttribute("producers", producers);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/pages/producer-list.jsp")
                .forward(request, response);        
        
    }
}
