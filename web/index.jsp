<%-- 
    Document   : index
    Created on : 27/11/2019, 12:18:31 PM
    Author     : EDU LLERENA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <label for="usuario">Ingrese el Usuario</label>
        <input type="text" id="usuario">
        <br>
        <label for="password">Ingrese el Password</label>
        <input type="password" id="password">
        <button id="buttonIngresar" >Ingresar</button>
        <div id="ajaxResponseUsuario"></div>
        
        <br>
        
        <label for="dni"></label>
        <input type="text" id="dni">
        <br>
        <button id="buttonIngresoVotar" > Votar </button>
        
        <script src="https://code.jquery.com/jquery-3.3.1.min.js" ></script>
        
        <script>   
            
            //AJAX con JSON
            $("#buttonIngresar" ).click(function() {
                var user = new Object();
                user.userName = $('#usuario').val(); //valor que tenga el id_usuario se guarda
                user.userPass = $('#password').val();
                console.log(user);
                $.ajax({
                        url: "Administrador_Servlet",
                        type: 'POST',   
                        dataType: 'json',
                        data: {
                            accion: "login",
                            text_json: JSON.stringify(user) //convertirlo el user que es un objeto en una extructura json
                        },
                          
                        success : function(response) {
                                console.log(response);
                                if(response == "Error"){
                                    $('#ajaxResponseUsuario').html("Usuario o Contraseña Incorrecta...");
                                }else{
                                    window.location.href = "Menu_Administrador.jsp"; //localizar ventana en el navegador .
                                }
                        },
                        error:function(data,status,er) {
                            $('#ajaxResponseUsuario').html("No registrado " );
                        }
                });
            });
            
            //AJAX con JSON
            $("#buttonIngresoVotar" ).click(function() {
                var user = new Object();
                user.userdni = $('#dni').val();
                console.log(user);
                $.ajax({
                        url: "Servlet_Persona",
                        type: 'POST',   
                        dataType: 'json',
                        data: {
                            accion: $("#accion").val(),
                            text_json: JSON.stringify(user)
                        },
                          
                        success : function(response) {
                                console.log(response);
                                if(response == "noPass"){
                                    $('#ajaxResponseDNI').html("Este DNI no existe");
                                }else if(response == "noUsu"){
                                    $('#ajaxResponseDNI').html("Usuario equivocado");
                                }else{
                                    window.location.href = "votar.jsp";
                                }
                        },
                        error:function(data,status,er) {
                            $('#ajaxResponseDNI').html("No registrado " );
                        }
                });
            });
        </script>
    </body>
</html>
