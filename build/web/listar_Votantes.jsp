<%-- 
    Document   : listar_Usuarios
    Created on : 29/11/2019, 02:33:31 PM
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
        

        <div style="margin-left:15%;padding:1px 16px;height:1000px;"> <!--buena ubicacion-->
        <h1>LISTA DE VOTANTES</h1>
        
        <table  style="border: solid black 2px">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>DNI</th>
                            <th>Nombres</th>
                            <th>Apellidos</th>
                            <th>Direccion</th>
                            <th>Estado_Civil</th>
                            <th>Sexo</th>
                            <th>Estado_Votante</th>
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
                            url: "Votantes_Servlet",
                            type: 'POST',
                            dataType: 'json',
                            data: {
                                accion: "listar"
                            },
                            success: function (response) {
                                $('#tblVotantes').html("");
                                if(response.length > 0 ){
                                    response.forEach(function(element) {                                    
                                        $('#tblVotantes').append("<tr>"+
                                            "<td>"+element.id+"</td>"+
                                            "<td>"+element.dni+"</td>"+
                                            "<td>"+element.nombre+"</td>"+
                                            "<td>"+element.apellido+"</td>"+
                                            "<td>"+element.dirección+"</td>"+
                                            "<td>"+element.estado_civil+"</td>"+
                                            "<td>"+element.sexo+"</td>"+
                                            "<td>"+element.estado_votante+"</td>"+
                                            "</tr>");
                                    });
                                    
                                } else {
                                    $('#tblVotantes').append("<tr><td colspan='11'> NO HAY RESULTADOS</td></tr>");
                                }

                            },
                            error: function (data, status, er) {
                                $('#tblVotantes').html("Error en base de datos ");
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
