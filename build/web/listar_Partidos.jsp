<%-- 
    Document   : listar_Partidos
    Created on : 29/11/2019, 02:33:52 PM
    Author     : EDU LLERENA
--%>

<%@page import="Entidad.Administrador_Atributos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="imagen/logo1.jpg"/>
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
        

        <div style="margin-left:15%;padding:1px 16px;height:1000px;"> <!--buena ubicacion-->
        <h1>LISTA PARTIDOS</h1>
        
        <table  style="border: solid black 2px">
            
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre Partido</th>
                            <th>Descripcion</th>
                            <th>Logo</th>
                            <th>Contador Votos</th>
                            
                        </tr>
                    </thead>
                    <tbody id="tblVotantes">
                       
                    </tbody>
                </table>
    </div>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js" ></script>
        
        <script>
            //AJAX con JSON
            $( document ).ready(function() {
              
                $.ajax({
                            url: "Partidos_Servlet",
                            type: 'POST',
                            dataType: 'json',
                            data: {
                                accion: "listar"
                            },
                            success: function (response) {
                                $('#tblPartidos').html("");
                                if(response.length > 0 ){
                                    response.forEach(function(element) {                                    
                                        $('#tblVotantes').append("<tr>"+
                                            "<td>"+element.id+"</td>"+
                                            "<td>"+element.nombre_partido+"</td>"+
                                            "<td>"+element.descripcion+"</td>"+
                                            "<td> <img src='imagen/"+element.logo+"' height='80'/></td>"+
                                            "<td>"+element.contador_votos+"</td>"+
                                            "</tr>");
                                    });
                                    
                                } else {
                                    $('#tblPartidos').append("<tr><td colspan='11'> NO HAY RESULTADOS</td></tr>");
                                }

                            },
                            error: function (data, status, er) {
                                $('#tblPartidos').html("Error en base de datos ");
                            }
                });
            });
            
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
