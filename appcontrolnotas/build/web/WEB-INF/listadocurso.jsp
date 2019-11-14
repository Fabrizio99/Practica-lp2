<%-- 
    Document   : listadocurso
    Created on : 14/11/2019, 09:02:15 AM
    Author     : Alumno
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelobean.alumno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            td,th{
                border: 1px solid black;
            }
            table{
                border-collapse: collapse;
            }
        </style>
    </head>
    <body>
        <%
            ArrayList<alumno> lista = (ArrayList<alumno>) request.getAttribute("listadoalumnos");
        %>
        <h1>Curso ${curso.nombre}</h1>
        
        <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th colspan="2" style="text-align: center"><a href="registro?curso=${curso.idc}">Registrar Evaluacion</a></th>
            </tr>
        </thead>
        <tbody>
        <%for(alumno al:lista){%>
        <tr>
            <td><%=al.getIda()%></td>
            <td><%=al.getNombre()%></td>
            <td><%=al.getApellidos()%></td>
            <td><a href="editarAlumno?id=<%=al.getIda()%>&curso=${curso.idc}">Editar</a></td>
            <td><a href="verfoto?id=<%=al.getIda()%>">Ver</a></td>
        </tr>
        <%}%>
        </tbody>
        </table>
    </body>
</html>
