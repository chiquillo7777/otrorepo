/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsu.finalproject.controllers;

import dsu.finalproject.models.Product;
import dsu.finalproject.models.ProductService;

import dsu.finalproject.models.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author carlos.chiquillo
 */
public class ProductController extends HttpServlet {

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
        String operation = request.getParameter("operation");
        switch (operation) {
            case "category":

                listCategories(request, response);
                
                break;

            default:
                errorPage(request, response);
                break;
        }

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
            case "Add":
                
                
                Product product = new Product(request.getParameter("name"), request.getParameter("description"), request.getParameter("category"), Float.parseFloat(request.getParameter("price")));
                addProductOperation(product);

                response.sendRedirect("product.jsp");
                //listUsers(request, response);
                break;

            case "login":
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                if (UserService.login(email, password)) {
                    response.sendRedirect("summary.jsp");
                } else {
                    response.sendRedirect("product.jsp");
                }

                break;
            default:
                errorPage(request, response);
                break;
        }

    }

    private void addProductOperation(Product product) {
        new ProductService().addProduct(product);
        return;
    }

    /*public void listProducts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> listProducts = new ArrayList<>();
        listProducts = new ProductService().getProductByCategory();
        request.setAttribute("listProducts", listProducts);
        request.setAttribute("title", "List of Products");
        request.getRequestDispatcher("productByCategory.jsp").forward(request, response);

    }*/
    
    public void listCategories(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<String> listcategories = new ArrayList<>();
        listcategories = new ProductService().getProductByCategory();
        request.setAttribute("listcategories", listcategories);
        request.setAttribute("title", "List of products by Category");
        request.getRequestDispatcher("productByCategory.jsp").forward(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public void errorPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("title", "Error page");
        request.getRequestDispatcher("error.jsp").forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
