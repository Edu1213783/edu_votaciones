/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author EDU LLERENA
 */
public class Partidos_Atributos 
{
    public int id;
    public String nombre_partido;
    public String descripcion;
    public String logo;
    public String contador_votos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre_partido(String nombre_partido) {
        this.nombre_partido = nombre_partido;
    }

  

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getContador_votos() {
        return contador_votos;
    }

    public void setContador_votos(String contador_votos) {
        this.contador_votos = contador_votos;
    }
    
    
}
