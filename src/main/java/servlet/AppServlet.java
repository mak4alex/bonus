package servlet;

import controllers.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;


public class AppServlet extends HttpServlet {

    private HashMap<String,Controller> getControllersMap;
    private HashMap<String,Controller> postControllersMap;


    @Override
    public void init() throws ServletException {
        super.init();
        getControllersMap = new HashMap<>();
        postControllersMap = new HashMap<>();
        fillGetControllersMap();
        fillPostControllersMap();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        try {
            String path = req.getRequestURI();
            String faviconPath = "/favicon.ico";
            System.out.println("Path is: " + path);

            if (getControllersMap.containsKey(path)) {
                getControllersMap.get(path).execute(req, res);
            } else if (! path.equals(faviconPath)) {
                res.sendRedirect(req.getContextPath() + "/404");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        try {
            String path = req.getRequestURI();
            String faviconPath = "/favicon.ico";
            System.out.println("Path is: " + path);

            if (postControllersMap.containsKey(path)) {
                postControllersMap.get(path).execute(req, res);
            } else if (! path.equals(faviconPath)) {
                res.sendRedirect(req.getContextPath() + "/404");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private void fillPostControllersMap() {
        getControllersMap.put("/", new MainCtrl());
        getControllersMap.put("/producer", new ProducerGetCtrl());
        getControllersMap.put("/producer/create", new ProducerGetFormCtrl());
        getControllersMap.put("/producer/remove", new ProducerRemoveCtrl());
        getControllersMap.put("/producer/search", new ProducerSearchCtrl());
        getControllersMap.put("/producer/diagram", new ProducerDiagramCtrl());
        getControllersMap.put("/souvenir", new SouvenirGetCtrl());
        getControllersMap.put("/souvenir/create", new SouvenirGetFormCtrl());
        getControllersMap.put("/souvenir/remove", new SouvenirRemoveCtrl());
        getControllersMap.put("/souvenir/search", new SouvenirSearchCtrl());
        getControllersMap.put("/404", new NoSuchPageCtrl());

    }

    private void fillGetControllersMap() {
        postControllersMap.put("/producer/create", new ProducerPostCtrl());
        postControllersMap.put("/souvenir/create", new SouvenirPostCtrl());
    }

}