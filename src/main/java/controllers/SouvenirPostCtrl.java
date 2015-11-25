package controllers;


import dao.SouvenirDAO;
import model.Souvenir;
import servlet.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;



public class SouvenirPostCtrl implements Controller {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SouvenirDAO souvenirDAO = new SouvenirDAO();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

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
            Logger.getLogger(SouvenirPostCtrl.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(SouvenirPostCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        souvenirDAO.insert(souvenir);
        response.sendRedirect(request.getContextPath() + "/souvenir");

    }
}
