/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Entidad.Administrador_Atributos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Conexion.Conexion; 

/**
 *
 * @author EDU LLERENA
 */
public class Administrador_BD 
{

    public static Administrador_Atributos BuscarUsuario(String usuario) 
    {
         Administrador_Atributos usu = new Administrador_Atributos();
        
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
        
        try{
            PreparedStatement pstm = cn.prepareStatement("select id,nombre,password,nombre_usuario from administrador where nombre_usuario = ?");
            pstm.setString(1, usuario);
            
            ResultSet rs = pstm.executeQuery(); //solo es para select
            
            if(rs.next()){
                usu.setNombre(rs.getString("nombre")); 
                usu.setUsuario(rs.getString("nombre_usuario"));
                usu.setPassword(rs.getString("password"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return usu;
    }
    
}
