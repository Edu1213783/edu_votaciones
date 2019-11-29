<%-- 
    Document   : Menu_Administrador
    Created on : 27/11/2019, 01:01:40 PM
    Author     : EDU LLERENA
--%>

<%@page import="Entidad.Administrador_Atributos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table, td, th {  
              border: 1px solid #ddd;
              text-align: left;
            }

            table {
              border-collapse: collapse;
              width: 100%;
            }

            th, td {
              padding: 15px;
            }
        </style>
    </head>
    <body>
        <%@include file="Validar_Administrador.jsp" %>
        <%@include file="Barra_Navegacion.jsp" %>
        <%
            Administrador_Atributos admi = (Administrador_Atributos)session.getAttribute("Administrador");
            if(admi!=null){
            String nombre = admi.getNombre();
        %>

        <div style="margin-left:15%;padding:1px 16px;height:1000px;"> <!--buena ubicacion-->
        <h1>Menu Administrador</h1>
        <h1><%=nombre%></h1>
        <%
            };
        %>
        
    </div>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js" ></script>
        <script>
            $("#buttonSalir").click(function() {
                
                $.ajax({
                        url: "Administrador_Servlet",
                        type: 'POST',   
                        dataType: 'json',
                        data: {
                            accion: "Salir",
                        },
                          
                        success : function(response) {
                                if(response == "Salida"){
                                    window.location.href = "index.jsp"; //localizar ventana en el navegador .
                                }
                        },
                        error:function(data,status,er) {
                            $('#ajaxResponseUsuario').html("No registrado " );
                        }
                });
            });
        </script>
    </body>
</html>
