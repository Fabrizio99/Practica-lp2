/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelobean.evaluacion;
import modelodao.alumnoDAO;
import modelodao.cursoDAO;
import modelodao.evaluacionDAO;

/**
 *
 * @author Alumno
 */
@WebServlet(name = "servletEvaluacion", urlPatterns = {"/servletEvaluacion","/registro","/registrarultimo"})
public class servletEvaluacion extends HttpServlet {

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
        if(request.getServletPath().equals("/registro")){
            int idcurso = Integer.parseInt(request.getParameter("curso"));
            request.setAttribute("idcurso", idcurso);
            request.setAttribute("listacursos", cursoDAO.listado());
            request.getRequestDispatcher("WEB-INF/registroEvaluacion.jsp").forward(request, response);
        }
        if(request.getServletPath().equals("/registrarultimo")){
            int idcursoinicial = Integer.parseInt(request.getParameter("idcurso"));
            System.out.println(idcursoinicial);
            int idcurso = Integer.parseInt(request.getParameter("curso"));
            System.out.println(idcurso);
            int idalumno = Integer.parseInt(request.getParameter("alumno"));
            System.out.println(idalumno);
            Double nota1 = Double.parseDouble(request.getParameter("nota1"));
            System.out.println(nota1);
            Double nota2 = Double.parseDouble(request.getParameter("nota2"));
            System.out.println(nota2);
            Double notaPromedio = Double.parseDouble(request.getParameter("notaPromedio"));
            System.out.println("promedio"+notaPromedio);
            evaluacion ev = new evaluacion();
            ev.setIda(idalumno);
            ev.setIdc(idcurso);
            ev.setNota1(nota1);
            ev.setNota2(nota2);
            ev.setPromedio(notaPromedio);
            evaluacionDAO.editarEvaluacion(ev);
            request.setAttribute("curso", cursoDAO.busquedaID(idcursoinicial));
            request.setAttribute("listadoalumnos", alumnoDAO.busquedaCurso(idcursoinicial));
            request.getRequestDispatcher("WEB-INF/listadocurso.jsp").forward(request, response);
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
