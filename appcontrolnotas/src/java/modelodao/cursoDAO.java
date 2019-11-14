/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelodao;

import Conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelobean.curso;

/**
 *
 * @author Alumno
 */
public class cursoDAO {
    public static ArrayList<curso> listado(){
        ArrayList<curso> lista = new ArrayList();
        curso cr = null;
        Connection cn = conexion.abrir();
        String sql = "select * from curso";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                cr = new curso();
                cr.setIdc(rs.getInt("idc"));
                cr.setNombre(rs.getString("nombre"));
                lista.add(cr);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
        
    }
    public static curso busquedaID(int id){
        curso cr = null;
        Connection cn = conexion.abrir();
        String sql = "select * from curso where idc=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {                
                cr = new curso();
                cr.setIdc(rs.getInt("idc"));
                cr.setNombre(rs.getString("nombre"));
            }
            return cr;
        } catch (Exception e) {
            return null;
        }
        
    }
    public static ArrayList<curso> listadoAlumno(int id){
        String sql = "select curso.idc,curso.nombre from curso, evaluación as ev where curso.idc=ev.idc and ev.ida=?";
        ArrayList<curso> lista = new ArrayList();
        curso cr = null;
        Connection cn = conexion.abrir();
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                cr = new curso();
                cr.setIdc(rs.getInt("idc"));
                cr.setNombre(rs.getString("nombre"));
                lista.add(cr);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
}
