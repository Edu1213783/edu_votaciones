<%-- 
    Document   : Elegir_Partido
    Created on : 29/11/2019, 04:31:28 PM
    Author     : EDU LLERENA
--%>

<%@page import="Entidad.Votantes_Atributos"%>
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

        
        <h1>LISTA PARTIDOS</h1>
        <div id="ajaxResponse"></div>
        <table  style="border: solid black 2px">
            
                    <thead>
                        <tr>
                            <th>Nombre Partido</th>
                            <th>Logo</th>
                            <th>Elegir Partido</th>
                        </tr>
                        
                    </thead>
                    <tbody id="tblVotantes">
                       
                    </tbody>
                    
                </table>
        <button id="Votar"><h1>Votar</h1></button>

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
                                            "<td>"+element.nombre_partido+"</td>"+
                                            "<td> <img src='imagen/"+element.logo+"' height='25'/></td>"+
                                            "<td><input type='radio' name='voto' value='"+element.id+"'/></td>"+
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
                            $('#ajaxResponse').html("No se pudo salir de sesion" );
                        }
                });
            });
            <% 
                String dni ="";
                if (session.getAttribute("Votante") == null) {
                        response.sendRedirect("index.jsp"); //redirecciona si el tipo es nulo 
                    }else{
                Votantes_Atributos vot=(Votantes_Atributos)session.getAttribute("Votante");
                dni = vot.dni;
                }
            %>
            
            
            $("#Votar").click(function() {
                var user = new Object();
                user.id =$('input:radio[name=voto]:checked').val();
                user.dni = <%=dni%>;
                
                $.ajax({
                        url: "Votantes_Servlet",
                        type: 'POST',   
                        dataType: 'json',
                        data: {
                            accion: "votar",
                            text_json: JSON.stringify(user)
                        },
                          
                        success : function(response) {
                                if(response == "ErrorVoto"){
                                    $(ajaxResponse).html("no se voto");
                                }else if(response == "ErrorEstado"){
                                    $(ajaxResponse).html("No se cambio estado");
                                }else{
                                    alert('Voto Registrado..');
                                    window.location.href = "index.jsp"; //localizar ventana en el navegador .;
                                }
                        },
                        error:function(data,status,er) {
                            alert('Error SistemaAjax');
                        }
                });
            });
           

        </script>


    </body>
</html>