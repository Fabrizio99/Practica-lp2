/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.*;

/**
 *
 * @author Alumno
 */
public class conexion {
    private static String url = "jdbc:mysql://localhost/controlnotas";
    private static String user = "root";
    private static String password = "12345678";
    private static Connection cn;
    public static Connection abrir(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url,user,password);
            return cn;
        } catch (Exception e) {
            return null;
        }
        
    }
}
