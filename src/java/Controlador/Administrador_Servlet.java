/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.Administrador_Atributos;
import Modelo.Administrador_BD;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author EDU LLERENA
 */
@WebServlet(name = "Administrador_Servlet", urlPatterns = {"/Administrador_Servlet"})
public class Administrador_Servlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) 
        {
            String accion = request.getParameter("accion");
//            if(accion.equals("listar")){
//                Listar(request, response); 
//            }if(accion.equals("crear")){
//                Crear(request, response); 
//            }
            if(accion.equals("login")){
                Login(request, response); 
            }

            if(accion.equals("Salir")){
                Salir(request, response); 
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

    private void Login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        
        String data_json = request.getParameter("text_json").trim();
        JsonObject jobj = new Gson().fromJson(data_json, JsonObject.class);
        String usuario = jobj.get("userName").getAsString();
        String clave = jobj.get("userPass").getAsString();
        String jsonResult = "";
        
        
        try{    
            Administrador_Atributos admi = Administrador_BD.BuscarUsuario(usuario);
            String respuesta=" ";
            if(usuario.equals(admi.getUsuario())){
                if(clave.equals(admi.getPassword())){
                    request.getSession().setAttribute("Administrador", admi); //session es una variable que esta en el navegador
                    //que se mantiene durante la session si hay session se mantiene y cuando se cierra la session se borra todo
                    request.getSession().setAttribute("tipo", "administrador");
                     respuesta="Pass";
                    
                    
                }else{
                   respuesta="Error";
                   
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
    private void Salir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        String jsonResult = "";        
                
        HttpSession session = request.getSession();
        session.invalidate();
        
        
        String respuesta="Salida";
        Gson g = new Gson();
        jsonResult = g.toJson(respuesta);
        writer.print(jsonResult);
        writer.flush();
        writer.close();
    
    }
}

