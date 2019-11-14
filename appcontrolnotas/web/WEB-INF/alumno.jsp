<%-- 
    Document   : alumno
    Created on : 14/11/2019, 09:29:06 AM
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Alumno</h1>
        <form action="grabarAlumno" method="post">
            <table>
                <tr>
                    <td>Nombre</td>
                    <input type="text" name="curso" value="${idcurso}" style="display: none">
                <input type="text" name="id" style="display: none" value="${alumno.ida}">
                <td><input type="text" name="nombre" value="${alumno.nombre}"></td>
                </tr>
                <tr>
                    <td>Apellidos</td>
                    <td><input type="text" name="apellidos" value="${alumno.apellidos}"></td>
                    <input type="text" name="foto" value="${alumno.foto}" style="display: none">
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Guardar"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
