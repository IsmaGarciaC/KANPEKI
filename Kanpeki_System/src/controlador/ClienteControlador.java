/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import java.lang.System.Logger.Level;

import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Cliente;

/**
 *
 * @author Ismael
 */
public class ClienteControlador {
    
    Conexion con = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    Statement sentencia;
    
    Cliente cliente = new Cliente();

    public ClienteControlador() {
        con.getConector();
    }
    
    //Metodo de Crear
    
    public void crearCliente (Cliente c){
    
        try {
            String sql = "INSERT INTO Cliente (id, nombre, apellido, cedula, edad, direccion, genero)"
                    + "VALUES ( "+c.getId() + ",'" +c.getNombre() + "','" +c.getApellido() + "','" +c.getCedula()+ "','" +c.getEdad()+ "','" +c.getDireccion()+ "','" 
                    +c.getGenero()+"');";
            
            sentencia = con.getConector().createStatement();
            
            if (sentencia.executeUpdate(sql) > 0) {
                System.out.println("El registro se inserto correctamente");
    
            }
            else{
            
                System.out.println("No se pudo insertar el registro");
            
            }
        } catch (SQLException e) {
            
            System.out.println("Error" + " " + e);
            
        }
        
        System.out.println(c.toString());
        con.cerrar();
        
    }
    
    
    //Metodo de Eliminar
    
    public void eliminarCliente (int cod){
        String sql = "DELETE FROM Cliente WHERE cod = id";
        try {
            sentencia =  con.getConector().createStatement();
            sentencia.execute(sql);
            
        } catch (Exception e) {
            System.out.println("ERROR" + e);
        }
}
    
    //Metodo de Buscar
    
    public Cliente buscarCliente (int cod) {
        
        Cliente c = new Cliente();
        String sql = "SELECT * FROM Cliente WHERE cod  = id";
        
        try {
            Statement st = con.getConector().createStatement();
            ResultSet resultado = st.executeQuery(sql);
            
            while (resultado.next()) {                
                int id = resultado.getInt(cod);
                String nombre = resultado.getString("nombre");
                
                c.setId(id);
                c.setNombre(nombre);
            }
            return c;
        } catch (SQLException ex) {
            
            Logger.getLogger(ClienteControlador.class.getName()).log(java.util.logging.Level.SEVERE, null ,ex);
        }
        
        con.cerrar();
        return null;
    
    }
    
}
