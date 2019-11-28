
package Conexion;
import java.sql.*;
/**
 *
 * @author Edu Llerena
 */
public class Conexion {
    Connection conectar = null;
    
    public Connection conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/edu_votaciones","root","");
            System.out.println("Conexion exitosa");
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("Error al conectar: "+e.getMessage());
        }
        return conectar;
    }
}
