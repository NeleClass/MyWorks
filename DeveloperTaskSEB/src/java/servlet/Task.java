/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NeleN
 */
@WebServlet(name = "Task", urlPatterns = {"/Task"})
public class Task extends HttpServlet {

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
        
        String akStr = request.getParameter("ak");
        Integer ak = null;
        try {
            ak = new Integer(akStr);
        } catch (Exception ex) {
        }
        
        String bkStr = request.getParameter("bk");
        Integer bk = null;
        try {
            bk = new Integer(bkStr);
        } catch (Exception ex) {
        }
        
        String aStr = request.getParameter("a");
        Integer a = null;
        try {
            a = new Integer(aStr);
        } catch (Exception ex) {
        }
        
        String divStr = request.getParameter("div");
        Integer div = null;
        try {
            div = new Integer(divStr);
        } catch (Exception ex) {
        }
        
        String bStr = request.getParameter("b");
        Integer b = null;
        try {
            b = new Integer(bStr);
        } catch (Exception ex) {
        }
      
        String adivStr = request.getParameter("adiv");
        Double adiv = null;
        try {
            adiv = new Double (adivStr);
        } catch (Exception ex) {
        }
        
        String bdivStr = request.getParameter("bdiv");
        Double bdiv = null;
        try {
            bdiv = new Double (bdivStr);
        } catch (Exception ex) {
        }
        
        response.sendRedirect("Task.jsp");
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
        processRequest(request, response);
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
