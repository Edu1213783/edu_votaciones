<%-- 
    Document   : Barra_Navegacion
    Created on : 29/11/2019, 02:16:54 PM
    Author     : EDU LLERENA
--%>


<style>
body {
  margin: 0;
}

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  width: 15%;
  background-color: #f1f1f1;
  position: fixed;
  height: 100%;
  overflow: auto;
}

li a {
  display: block;
  color: #000;
  padding: 8px 16px;
  text-decoration: none;
}

li a.active {
  background-color: #4CAF50;
  color: white;
}

li a:hover:not(.active) {
  background-color: #555;
  color: white;
}
</style>


<ul>
  <li><a class="active" href="Menu_Administrador.jsp">Home</a></li>
  <li><a href="listar_Votantes.jsp">Listar Votantes</a></li>
  <li><a href="listar_Partidos.jsp">Listar Partidos</a></li>
  <li><a href="" id="buttonSalir">Cerrar Sesion</a></li>
</ul>


<script>
     
</script>
