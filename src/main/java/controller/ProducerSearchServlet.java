package controller;


import dao.ProducerDAO;
import dao.SouvenirDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Producer;
import model.Souvenir;


public class ProducerSearchServlet extends HttpServlet {

    ProducerDAO producerDAO = new ProducerDAO();
    SouvenirDAO souvenirDAO = new SouvenirDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Producer> producers = producerDAO.selectAll();
        for (Producer producer : producers) {
            producer.setSouvenirs(souvenirDAO.selectAll(producer.getId()));
        }
        
        String souvernirMaxPriceParam = request.getParameter("souvernir-max-price");        
        if (souvernirMaxPriceParam != null && !souvernirMaxPriceParam.isEmpty()) {            
            double souvernirMaxPrice = Double.parseDouble(souvernirMaxPriceParam);            
            List<Producer> filterdProducers = new ArrayList<>();            
            for (Producer producer : producers) {
                for (Souvenir souvenir : producer.getSouvenirs()) {
                    if (souvenir.getPrice() < souvernirMaxPrice) {
                        filterdProducers.add(producer);
                    }
                }            
            }            
            producers = filterdProducers;           
        }
        
        
        String souvenirMadeYearParam = request.getParameter("souvenir-made-year");        
        if (souvenirMadeYearParam != null && !souvenirMadeYearParam.isEmpty()) {            
            int souvenirMadeYear = Integer.parseInt(souvenirMadeYearParam);            
            List<Producer> filterdProducers = new ArrayList<>();      
            Calendar cal = Calendar.getInstance();           
            for (Producer producer : producers) {
                for (Souvenir souvenir : producer.getSouvenirs()) {
                    cal.setTime(souvenir.getMadeDate());
                    if (cal.get(Calendar.YEAR) == souvenirMadeYear) {
                        filterdProducers.add(producer);
                    }
                }            
            }            
            producers = filterdProducers;           
        }
           
        
        request.setAttribute("producers", producers);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/pages/producer-search.jsp")
                .forward(request, response);        
        
    }

}
