package controller;


import dao.ProducerDAO;
import dao.SouvenirDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Souvenir;


public class SouvenirSearchServlet extends HttpServlet {
    
    ProducerDAO producerDAO = new ProducerDAO();
    SouvenirDAO souvenirDAO = new SouvenirDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Souvenir> souvenirs = souvenirDAO.selectAll();
        for (Souvenir souvenir : souvenirs) {
            souvenir.setProducer(producerDAO.selectById(souvenir.getProducerId()));
        }
        
        String souvernirMadeCountryParam = request.getParameter("souvernir-made-country");        
        if (souvernirMadeCountryParam != null && !souvernirMadeCountryParam.isEmpty()) {                   
            List<Souvenir> filterdSouvenirs = new ArrayList<>();        
            for (Souvenir souvenir : souvenirs) {
                if (souvenir.getProducer().getCountry().equals(souvernirMadeCountryParam)) {
                    filterdSouvenirs.add(souvenir);
                }
            }                     
            souvenirs = filterdSouvenirs;           
        }
        
        
        String souvenirProducerName = request.getParameter("souvenir-producer-name");        
        if (souvenirProducerName != null && !souvenirProducerName.isEmpty()) {               
            List<Souvenir> filterdSouvenirs = new ArrayList<>();         
            for (Souvenir souvenir : souvenirs) {               
                if (souvenir.getProducer().getName().equals(souvenirProducerName)) {
                    filterdSouvenirs.add(souvenir);
                }
            }               
            souvenirs = filterdSouvenirs;           
        }
           
        request.setAttribute("souvenirs", souvenirs);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/pages/souvenir-search.jsp")
                .forward(request, response);         
    }  

}
