package controllers;

import servlet.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class NoSuchPageCtrl implements Controller {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request .getServletContext()
                .getRequestDispatcher("/WEB-INF/pages/404.jsp")
                .forward(request, response);
    }
}
