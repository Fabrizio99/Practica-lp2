<%-- 
    Document   : foto
    Created on : 14/11/2019, 11:07:12 AM
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
        <img src="foto/${alumno.foto}" width="30%">
        <p>${alumno.nombre} ${alumno.apellidos}</p>
    </body>
</html>
