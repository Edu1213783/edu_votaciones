/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Entidad.Votantes_Atributos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Conexion.Conexion; 

/**
 *
 * @author EDU LLERENA
 */
public class Votante_BD 
{

    public static ArrayList<Votantes_Atributos> ListarVotantes() 
    {
        ArrayList<Votantes_Atributos> lista = new ArrayList<Votantes_Atributos>();
        Connection cn;
        Conexion con = new Conexion();
        cn=con.conectar();
        
        try{
            PreparedStatement pstm = cn.prepareStatement("SELECT * FROM votantes");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Votantes_Atributos votante = new Votantes_Atributos();
                
                    votante.setId(rs.getInt("id"));
                    votante.setNombre(rs.getString("nombre"));
                    votante.setApellido(rs.getString("apellido"));
                    votante.setDni(rs.getString("dni"));
                    votante.setDirección(rs.getString("direccion"));
                    votante.setSexo(rs.getString("sexo"));
                    votante.setEstado_civil(rs.getString("estado_civil"));
                    votante.setEstado_votante(rs.getString("estado_votante"));
                    
                    
                       
                lista.add(votante);
            }
        }catch(Exception e){ 
            System.out.println(e);
        }
        return lista;
    }

    public static Votantes_Atributos BuscarVotantes(String dni) {
        Votantes_Atributos votante = new Votantes_Atributos();
        Connection cn;
        Conexion con = new Conexion();
        cn=con.conectar();
        
        try{
            PreparedStatement pstm = cn.prepareStatement("SELECT * FROM  votantes WHERE dni= ? ");
            pstm.setString(1, dni);
            
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                
                    votante.setId(rs.getInt("id"));
                    votante.setNombre(rs.getString("nombre"));
                    votante.setApellido(rs.getString("apellido"));
                    votante.setDni(rs.getString("dni"));
                    votante.setDirección(rs.getString("direccion"));
                    votante.setSexo(rs.getString("sexo"));
                    votante.setEstado_civil(rs.getString("estado_civil"));
                    votante.setEstado_votante(rs.getString("estado_votante"));
                    
                    
                       
            }
        }catch(Exception e){ 
            System.out.println(e);
        }
        return votante;
    }
    
}
