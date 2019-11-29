/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.Votantes_Atributos;
import Modelo.Partido_BD;
import Modelo.Votante_BD;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author EDU LLERENA
 */
@WebServlet(name = "Votantes_Servlet", urlPatterns = {"/Votantes_Servlet"})
public class Votantes_Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String accion = request.getParameter("accion");
            System.out.println("prueba");
           if(accion.equals("login")){
                Login(request, response); 
            }if(accion.equals("votar")){
                Votar(request, response); 
            }if(accion.equals("listar")){
                Listar(request, response); 
            }
        
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void Listar(HttpServletRequest request, HttpServletResponse response) throws IOException 
    {
         PrintWriter writer = response.getWriter();
        String jsonResult = "";
        try{    
            ArrayList<Votantes_Atributos> pers = Votante_BD.ListarVotantes();
            
            if(pers != null){
                    Gson g = new Gson();
                jsonResult = g.toJson(pers);
            }
        }catch(Exception ex){System.out.println(ex);}
        
        writer.print(jsonResult);
        writer.flush();
        writer.close();
    }

    private void Login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        
        String data_json = request.getParameter("text_json").trim();
        JsonObject jobj = new Gson().fromJson(data_json, JsonObject.class);
        String dni = jobj.get("dni").getAsString();
        String jsonResult = "";
        
        
        try{    
            Votantes_Atributos votante = Votante_BD.BuscarVotantes(dni);
            String respuesta=" ";
            if(dni.equals(votante.getDni())){
                if("no".equals(votante.getEstado_votante())){
                    request.getSession().setAttribute("Votante", votante); 
                     respuesta="Pass";
                    
                    
                }else{
                   respuesta="No Voto";
                   
                }
            }else{
                respuesta="Error";
                    
                    
            }
            Gson g = new Gson();
                    jsonResult = g.toJson(respuesta);
            
        }catch(Exception ex){writer.println(ex);}
        writer.print(jsonResult);
        writer.flush();
        writer.close();
    }

    private void Votar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        
        String data_json = request.getParameter("text_json").trim();
        JsonObject jobj = new Gson().fromJson(data_json, JsonObject.class);
        String id = jobj.get("id").getAsString();
        String dni = jobj.get("dni").getAsString();
        String jsonResult = "";
        
        
        try{    
            String respuesta= Partido_BD.VotarPartido(id,dni);
            System.out.print("llego ;"+ respuesta);
            Gson g = new Gson();
                    jsonResult = g.toJson(respuesta);
            
        }catch(Exception ex){writer.println(ex);}
        writer.print(jsonResult);
        writer.flush();
        writer.close();
    
    }

}
