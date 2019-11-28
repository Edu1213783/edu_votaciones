<%-- 
    Document   : Validar_Administrador
    Created on : 27/11/2019, 01:36:34 PM
    Author     : EDU LLERENA
--%>

<% 
    String Administrador = (String)session.getAttribute("tipo");
    if(session.getAttribute("tipo")== null){
        response.sendRedirect("index.jsp"); //redirecciona si el tipo es nulo 
    }
    %>