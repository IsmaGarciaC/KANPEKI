/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ismael
 */
public class Conexion {
    
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://127.0.0.1/bd_kanpeki";
    private static final String user = "root";
    private static final String password = "Ismael1708..";
    private static Connection conectar;

    public Conexion() {
        
        conectar = null;
        
        try {
            System.out.println("--------ENTRA BASE--------");
            Class.forName(driver);
            conectar = DriverManager.getConnection(url, user, password);
            
            if (conectar != null) {
                System.out.println("-----CONEXION CORRECTA-----");
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null, ex);
            
        }
    }
    
    public void cerrar(){
    
        conectar = null;
        
        if (conectar == null) {
            System.out.println("-----CONEXION CERRADA-----");
        }
    
    }
    
    public Connection getConector (){
    
        return conectar;
    }
    
}
    

