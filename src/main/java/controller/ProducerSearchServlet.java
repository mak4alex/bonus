package controller;


import dao.ProducerDAO;
import dao.SouvenirDAO;
import model.Producer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * class ProducerSearchServlet предоставляет
 * поиск производителей по максимальной цене сувенира и
 * году производства сувенира.
 *
 */

public class ProducerSearchServlet extends HttpServlet {

    ProducerDAO producerDAO = new ProducerDAO();
    SouvenirDAO souvenirDAO = new SouvenirDAO();

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String producerNameParam = request.getParameter("producer-name") != null ? request.getParameter("producer-name") :  "";
        String producerCountryParam = request.getParameter("producer-country") != null ? request.getParameter("producer-country") :  "";
        String souvenirMaxPriceParam = request.getParameter("souvenir-max-price") != null ? request.getParameter("souvenir-max-price") :  "";
        String souvenirMadeYearParam = request.getParameter("souvenir-made-year") != null ? request.getParameter("souvenir-made-year") :  "";

        List<Producer> producers = producerDAO.selectAll();
        producers.forEach(producer -> producer.setSouvenirs(souvenirDAO.selectAll(producer.getId())));


        Calendar cal = Calendar.getInstance();
        producers = producers.stream()
                .filter(producer -> producerNameParam.isEmpty() || producer.getName().contains(producerNameParam))
                .filter(producer -> producerCountryParam.isEmpty() || producer.getCountry().contains(producerCountryParam))
                .filter(producer -> souvenirMaxPriceParam.isEmpty() ||
                        producer.getSouvenirs().stream().anyMatch(souvenir -> souvenir.getPrice() < Double.parseDouble(souvenirMaxPriceParam)))
                .filter(producer -> souvenirMadeYearParam.isEmpty() ||
                        producer.getSouvenirs().stream().anyMatch(souvenir ->{
                            cal.setTime(souvenir.getMadeDate());
                            return cal.get(Calendar.YEAR) == Integer.parseInt(souvenirMadeYearParam);
                        }))
                .collect(Collectors.toList());

        request.setAttribute("producers", producers);

        getServletContext()
                .getRequestDispatcher("/WEB-INF/pages/producer-search.jsp")
                .forward(request, response);        
        
    }

}
