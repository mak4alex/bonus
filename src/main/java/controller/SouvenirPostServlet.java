package controller;


import dao.ProducerDAO;
import dao.SouvenirDAO;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Souvenir;


public class SouvenirPostServlet extends HttpServlet {

    ProducerDAO producerDAO = new ProducerDAO();
    SouvenirDAO souvenirDAO = new SouvenirDAO();
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idParameter = request.getParameter("id");

        if (idParameter != null && !idParameter.isEmpty()) {            
            try {
                int id = Integer.parseInt(request.getParameter("id")); 
                
                Souvenir souvenir = souvenirDAO.selectById(id);
                request.setAttribute("souvenir", souvenir);                   
            } catch (NumberFormatException ex) {
                Logger.getLogger(ProducerPostServlet.class.getName()).log(Level.SEVERE, null, ex);
            }                
        }
        
        request.setAttribute("producers", producerDAO.selectAll());
        
        getServletContext()
                .getRequestDispatcher("/WEB-INF/pages/souvenir-form.jsp")
                .forward(request, response);  
    }
    
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idParameter = request.getParameter("id");
        String name = request.getParameter("name");
        String madeDate = request.getParameter("made-date");      
        String price = request.getParameter("price");
        String producerId = request.getParameter("producer-id");
        
        Souvenir souvenir = new Souvenir();
        
        souvenir.setName(name);
        try {
            souvenir.setMadeDate(dateFormat.parse(madeDate));
        } catch (ParseException ex) {
            Logger.getLogger(SouvenirPostServlet.class.getName()).log(Level.SEVERE, null, ex);
            souvenir.setMadeDate(new Date());
        }
        souvenir.setPrice(Double.parseDouble(price));
        souvenir.setProducerId(Integer.parseInt(producerId));
                        
        if (idParameter != null &&  !idParameter.isEmpty()) {
            
            try {
                int id = Integer.parseInt(request.getParameter("id"));               
                souvenirDAO.update(id, souvenir);      
                
                response.sendRedirect(request.getContextPath() + "/souvenir?id=" + id);
                return;
            } catch (NumberFormatException | IOException ex) {
                Logger.getLogger(SouvenirPostServlet.class.getName()).log(Level.SEVERE, null, ex);
            }              
        } 
        
        souvenirDAO.insert(souvenir);      
        response.sendRedirect(request.getContextPath() + "/souvenir");        
    }

}
