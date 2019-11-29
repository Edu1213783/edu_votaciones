/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Entidad.Partidos_Atributos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Conexion.Conexion; 

/**
 *
 * @author EDU LLERENA
 */
public class Partido_BD {
    
    public static ArrayList<Partidos_Atributos> ListarPartdios() {
        
    ArrayList<Partidos_Atributos> lista = new ArrayList<Partidos_Atributos>();
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
        
        try{
            PreparedStatement pstm = cn.prepareStatement("SELECT * FROM partidos");
            
             System.out.println(pstm.toString());
            
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Partidos_Atributos partido = new Partidos_Atributos();
                partido.setId(rs.getInt("id"));
                partido.setNombre_partido(rs.getString("nombre_partido"));
                partido.setDescripcion(rs.getString("descripcion"));
                partido.setLogo(rs.getString("logo"));
                partido.setContador_votos(rs.getString("contador_votos"));
                lista.add(partido);
            }
        }catch(Exception e){ 
            System.out.println(e);
        }
        return lista;
    }
    public static String VotarPartido(String id, String dni) {
        Partidos_Atributos partido = new Partidos_Atributos();
        Connection cn;
        Conexion con = new Conexion();
        cn=con.conectar();
        
        String respuesta="";
        
        try{
            PreparedStatement pstm = cn.prepareStatement("SELECT * FROM  partidos WHERE id= ? ");
            pstm.setString(1, id);
            
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                
                    partido.setContador_votos(rs.getString("contador_votos"));
                    
            }
            //aumentando el numero de votos
            int contador = Integer.parseInt(partido.getContador_votos())+1;
            partido.setContador_votos(contador+"");
            
            pstm = cn.prepareStatement("UPDATE partidos SET contador_votos = ?\n" +
                                            "WHERE id = ?;");
            pstm.setString(1, partido.getContador_votos());
            pstm.setString(2, id);
            
            
            int i = pstm.executeUpdate();
            
            if(i==1)    {
                pstm = cn.prepareStatement("UPDATE votantes SET estado_votante = 'si' \n" +
                                            "WHERE dni = ?;");
                pstm.setString(1, dni);
            
            
                int a = pstm.executeUpdate();
                
                if(a==1)    {
                    respuesta="Correcto";
                }else{
                    respuesta="ErrorEstado";
                }
                
            }
            else
                respuesta="ErrorVoto";
                
            
        }catch(Exception e){ 
            System.out.println(e);
        }
        
        return respuesta;
    }
}
