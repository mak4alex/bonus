package controller;


import dao.ProducerDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Producer;

/**
 *
 * class ProducerPostServlet выводит
 * форму для создания и редактирования
 * производителя. А также сохраняет/создаёт
 * производителя.
 *
 */

public class ProducerPostServlet extends HttpServlet {
    
    private final ProducerDAO producerDAO = new ProducerDAO();
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idParameter = request.getParameter("id");

        if (idParameter != null && !idParameter.isEmpty()) {            
            try {
                int id = Integer.parseInt(request.getParameter("id")); 
                
                Producer producer = producerDAO.selectById(id);
                request.setAttribute("producer", producer);             
            } catch (NumberFormatException ex) {
                Logger.getLogger(ProducerPostServlet.class.getName()).log(Level.SEVERE, null, ex);
            }                
        }
        
        getServletContext()
                .getRequestDispatcher("/WEB-INF/pages/producer-form.jsp")
                .forward(request, response);  

    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
                Logger.getLogger(ProducerPostServlet.class.getName()).log(Level.SEVERE, null, ex);
            }              
        } 
        
        producerDAO.insert(producer);    
        
        response.sendRedirect(request.getContextPath() + "/producer");        
    }
  
}
