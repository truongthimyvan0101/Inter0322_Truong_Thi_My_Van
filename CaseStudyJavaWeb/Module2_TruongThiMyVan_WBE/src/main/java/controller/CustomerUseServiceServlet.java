package controller;

import model.service.CustomerUseServiceService;
import model.service.impl.CustomerUseServiceServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerUseServlet", urlPatterns = {"/customerUseService"})
public class CustomerUseServiceServlet extends HttpServlet {
    CustomerUseServiceService customerUseServiceService = new CustomerUseServiceServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "list":
                showListForm(request, response);
                break;
        }
    }

    private void showListForm(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("customerUseServiceList", customerUseServiceService.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/customerUseService/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}