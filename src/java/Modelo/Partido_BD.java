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
}
