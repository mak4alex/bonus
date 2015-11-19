package controller;


import dao.ProducerDAO;
import dao.SouvenirDAO;
import model.Souvenir;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


/**
 *
 * class SouvenirSearchServlet предоставляет
 * поиск сувениров по заданному производителю и
 * стране производителя.
 *
 */


public class SouvenirSearchServlet extends HttpServlet {
    
    ProducerDAO producerDAO = new ProducerDAO();
    SouvenirDAO souvenirDAO = new SouvenirDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Souvenir> souvenirs = souvenirDAO.selectAll();
        souvenirs.forEach( souvenir -> souvenir.setProducer(producerDAO.selectById(souvenir.getProducerId())));

        String souvenirName = request.getParameter("souvenir-name") != null ? request.getParameter("souvenir-name") : "";
        String souvenirPrice = request.getParameter("souvenir-price") != null ? request.getParameter("souvenir-price") : "";
        String souvenirMadeCountry = request.getParameter("souvenir-made-country") != null ? request.getParameter("souvenir-made-country") : "";
        String souvenirProducerName = request.getParameter("souvenir-producer-name") != null ? request.getParameter("souvenir-producer-name") : "";

        souvenirs = souvenirs.stream()
                .filter(souvenir -> souvenirName.isEmpty() || souvenir.getName().contains(souvenirName))
                .filter(souvenir -> souvenirPrice.isEmpty() || Double.parseDouble(souvenirPrice) == souvenir.getPrice())
                .filter(souvenir -> souvenirMadeCountry.isEmpty() ||
                        souvenir.getProducer().getCountry().contains(souvenirMadeCountry))
                .filter(souvenir -> souvenirProducerName.isEmpty() || souvenir.getProducer().getName().contains(souvenirProducerName))
                .collect(Collectors.toList());
           
        request.setAttribute("souvenirs", souvenirs);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/pages/souvenir-search.jsp")
                .forward(request, response);         
    }  

}
