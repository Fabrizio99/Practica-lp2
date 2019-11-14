<%-- 
    Document   : registroEvaluacion
    Created on : 14/11/2019, 09:57:21 AM
    Author     : Alumno
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelobean.curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            select{
                display: block;
            }
        </style>
    </head>
    <body>
        <h1>Registro Evaluación</h1>
        <%
            ArrayList<curso> lista = (ArrayList<curso>) request.getAttribute("listacursos");
        %>
        <form action="registrarultimo" method="post">
            <input type="text" name="idcurso" value="${idcurso}" style="display: none">
            <select name="curso" id="listacursos">
                <%for(curso cs:lista){%>
                <option value="<%=cs.getIdc()%>"><%=cs.getNombre()%></option>
                <%}%>
            </select>
            <select name="alumno" id="listaalumno">
            </select>
            <table>
                <tr>
                    <td>Nota 1</td>
                    <td><input type="text" name="nota1" id="n1"></td>
                </tr>
                <tr>
                    <td>Nota 2</td>
                    <td><input type="text" name="nota2" id="n2"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><a href="#"id="promedio" onclick="return promedio()">Obtener promedio</a></td>
                </tr>
                <tr>
                    <td>Promedio</td>
                    <td><input type="text"  name="notaPromedio" id="npromedio"></td>
                </tr>
            </table>
            <input type="submit" value="Registrar">
        </form>
            <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
            <script>
                $(document).ready(function (){
                    $('#listacursos').change(function (){
                        var id = $(this).val();
                        $.ajax({
                            url: "busquedaal",
                            type: 'POST',
                            data: {id:id},
                            success: function (data, textStatus, jqXHR) {
                                $('#listaalumno').html(data)
                            }
                        })
                    })
                    
                })
                function promedio(){
                        var promedio  = (Number(document.getElementById('n1').value)+Number(document.getElementById('n2').value))/2;
                        console.log(promedio)
                        $('#npromedio').val(promedio);
                        return false;
                    }
            </script>
    </body>
</html>
