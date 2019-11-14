<%-- 
    Document   : index.jsp
    Created on : 14/11/2019, 08:50:27 AM
    Author     : Alumno
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelobean.curso"%>
<%@page import="modelodao.cursoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            a{
                display: block;
            }
        </style>
    </head>
    <body>
        <h1>Registro de notas</h1>
        <h2>Cursos</h2>
        <%
            ArrayList<curso> lista = cursoDAO.listado();
        %>
        <%for(curso cr : lista){%>
        <a href="listadoalumno?id=<%=cr.getIdc()%>"><%=cr.getNombre()%></a>
        <%}%>
    </body>
</html>
