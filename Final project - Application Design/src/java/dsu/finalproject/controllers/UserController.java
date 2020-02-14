package dsu.finalproject.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dsu.finalproject.DBConnection;
import dsu.finalproject.models.User;
import dsu.finalproject.models.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.Session;

/**
 *
 * @author carlos.chiquillo
 */
public class UserController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operation = request.getParameter("operation");
        switch (operation) {
            case "register":
                User user = new User(request.getParameter("username"), request.getParameter("email"), request.getParameter("password"));
                addUserOperation(user);
                response.sendRedirect("login.jsp");
                //listUsers(request, response);
                break;
                
            case "login":
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    if(UserService.login(email, password)){
                         response.sendRedirect("productcategories.jsp");
                    }else{
                         response.sendRedirect("login.jsp");
                    }
             
            break;
            default:
                errorPage(request, response);
                break;
        }
    }

    private void addUserOperation(User user) {
        new UserService().addUser(user);
        return;
    }

    public void listUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> listUsers = new ArrayList<>();
        listUsers = new UserService().listUsers();
        request.setAttribute("listUsers", listUsers);
        request.setAttribute("title", "List of users");
        request.getRequestDispatcher("listUsers.jsp").forward(request, response);

    }

    public void errorPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("title", "Error page");
        request.getRequestDispatcher("error.jsp").forward(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
