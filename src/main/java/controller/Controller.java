package controller;

import command.Command;
import helper.RequestHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by timki on 07.01.2016.
 */
@WebServlet(name = "Controller", urlPatterns = {"/controller"})
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws  ServletException, IOException {
        String page = null;
        Command command = RequestHelper.getInstance().defineCommand(req);
        page = command.execute(req);
        if (page != null) {
            resp.sendRedirect(getServletContext().getContextPath() + page);
        } else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
