/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.empresaalimentosumd.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author AlainGomez
 */
public class BaseDeDatos {
    public static Connection conectarABaseDeDatos() throws SQLException{
       var url = "jdbc:mysql://localhost:3306/InventarioDB";
       var usuario = "root";
       var clave = "admin";
       
       try{
         
           return DriverManager.getConnection(url, usuario, clave);
       }catch(SQLException e){
           System.out.println("Error conexion");
           return null;
       }
       
    }
}
