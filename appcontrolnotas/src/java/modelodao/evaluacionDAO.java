/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelodao;

import Conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import modelobean.evaluacion;

/**
 *
 * @author Alumno
 */
public class evaluacionDAO {
    public static void editarEvaluacion(evaluacion ev){
        Connection cn = conexion.abrir();
        String sql = "update evaluación set nota1=?, nota2=?, promedio=? where ida=? and idc=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            System.out.println(ev.getNota1());
            pst.setDouble(1, ev.getNota1());
            System.out.println(ev.getNota2());
            pst.setDouble(2, ev.getNota2());
            System.out.println(ev.getPromedio());
            pst.setDouble(3, ev.getPromedio());
            pst.setInt(4,ev.getIda());
            pst.setInt(5,ev.getIdc());
            pst.executeUpdate();
            
        } catch (Exception e) {
        }
    }
}
