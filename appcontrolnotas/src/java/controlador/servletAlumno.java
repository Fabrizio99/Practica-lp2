/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelobean.alumno;
import modelodao.alumnoDAO;

/**
 *
 * @author Alumno
 */
@WebServlet(name = "servletAlumno", urlPatterns = {"/servletAlumno","/editarAlumno","/busquedaal","/verfoto"})
public class servletAlumno extends HttpServlet {

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
        if(request.getServletPath().equals("/editarAlumno")){
            int idc = Integer.parseInt(request.getParameter("curso"));
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("idcurso", idc);
            request.setAttribute("alumno", alumnoDAO.buscarID(id));
            request.getRequestDispatcher("WEB-INF/alumno.jsp").forward(request, response);
            
        }
        if(request.getServletPath().equals("/busquedaal")){
            PrintWriter out = response.getWriter();
            int idc = Integer.parseInt(request.getParameter("id"));
            ArrayList<alumno> lista = alumnoDAO.busquedaCurso(idc);
            for(alumno al:lista){
                out.println("<option value='"+al.getIda()+"'>"+al.getNombre()+"</option>");
            }
            
        }
        if(request.getServletPath().equals("/verfoto")){
            int idalumno = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("alumno", alumnoDAO.buscarID(idalumno));
            request.getRequestDispatcher("WEB-INF/foto.jsp").forward(request, response);
        }
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
