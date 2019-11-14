/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelodao;

import Conexion.conexion;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import modelobean.alumno;

/**
 *
 * @author Alumno
 */
public class alumnoDAO {
    public static ArrayList<alumno> busquedaCurso(int id){
        ArrayList<alumno> lista = new ArrayList();
        alumno al = null;
        Connection cn = conexion.abrir();
        String sql = "select alumno.ida,alumno.nombre,alumno.apellidos,alumno.foto from alumno, evaluación as ev where ev.idc=? and alumno.ida=ev.ida ";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                al = new alumno();
                al.setIda(rs.getInt("ida"));
                al.setNombre(rs.getString("nombre"));
                al.setApellidos(rs.getString("apellidos"));
                al.setFoto(rs.getString("foto"));
                lista.add(al);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
    public static alumno buscarID(int id){
        alumno al = null;
        Connection cn = conexion.abrir();
        String sql = "select * from alumno where ida=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                al = new alumno();
                al.setIda(rs.getInt("ida"));
                al.setNombre(rs.getString("nombre"));
                al.setApellidos(rs.getString("apellidos"));
                al.setFoto(rs.getString("foto"));
            }
            return al;
        } catch (Exception e) {
            return null;
        }
    }
    public static void editarAlumno(alumno al){
        Connection cn = conexion.abrir();
        String sql = "update alumno set nombre=?, apellidos=?, foto=? where ida=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, al.getNombre());
            pst.setString(2, al.getApellidos());
            pst.setString(3, al.getFoto());
            pst.setInt(4, al.getIda());
            pst.executeUpdate();
            
        } catch (Exception e) {
        }
    }
}
