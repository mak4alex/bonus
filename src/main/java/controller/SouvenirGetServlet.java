/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProducerDAO;
import dao.SouvenirDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Souvenir;


public class SouvenirGetServlet extends HttpServlet {

    ProducerDAO producerDAO = new ProducerDAO();
    SouvenirDAO souvenirDAO = new SouvenirDAO();    
  
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idParameter = request.getParameter("id");
        
        if ( idParameter != null && !idParameter.isEmpty() ) {
            
            try {            
                int id = Integer.parseInt(request.getParameter("id"));
            
                Souvenir souvenir = souvenirDAO.selectById(id);
                
                if (souvenir != null) {                    
                    souvenir.setProducer(producerDAO.selectById(souvenir.getProducerId()));
                    request.setAttribute("souvenir", souvenir);
                    getServletContext()
                            .getRequestDispatcher("/WEB-INF/pages/souvenir-one.jsp")
                            .forward(request, response);
                    return;                    
                }                
                    
            } catch (NumberFormatException | ServletException | IOException ex) {
                Logger.getLogger(SouvenirGetServlet.class.getName()).log(Level.SEVERE, null, ex);
            }       
            
        }        
       
        List<Souvenir> souvenirs = souvenirDAO.selectAll();
        
        for (Souvenir souvenir : souvenirs) {
            souvenir.setProducer(producerDAO.selectById(souvenir.getProducerId()));            
        }        
        
        request.setAttribute("souvenirs", souvenirs);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/pages/souvenir-list.jsp")
                .forward(request, response);        
        
    }    
    
}
