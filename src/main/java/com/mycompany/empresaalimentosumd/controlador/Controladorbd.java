/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.empresaalimentosumd.controlador;

import com.mycompany.empresaalimentosumd.TransaccionesDistribuidas.Productos;
import com.mycompany.empresaalimentosumd.TransaccionesDistribuidas.Sucursales;
import com.mycompany.empresaalimentosumd.conexion.BaseDeDatos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gomez
 */
public class Controladorbd {
     private static Controladorbd instance;
     public static Controladorbd getInstance() {
        if (instance == null) {
            instance = new Controladorbd();
        }
        return instance;
    }

    private Controladorbd() {

        sucursales = new ArrayList<>();
        productos = new ArrayList<>();

    }

    private List<Sucursales> sucursales; //Debo crear las clases sucursales y productos que repliquen la informacion que va a trasladar a la base de datos
    private List<Productos> productos;

    public List<Procedimiento> getProcedimientos() {

        List<Procedimiento> procedimientos = new ArrayList<>();

        try {
            //conectar a base de datos
            var conn = BaseDeDatos.conectarABaseDeDatos();
            //consultar lista de procedimientos
           var stmt = conn.createStatement();
            var rset = stmt.executeQuery("SELECT * FROM procedimiento ");

            while (rset.next()) {
                var procedimiento = new Procedimiento(rset.getInt("codigo"), 
                                                      rset.getString("nombre"));
                //cargar lista 
                procedimientos.add(procedimiento);
            }
           rset.close();
           stmt.close();
           conn.close();

        } catch (SQLException e) {
            System.err.print("Error en la Base de Datos" + e.getLocalizedMessage());
        }
        return procedimientos;
    } 

    public List<Sucursales> getMascotas() {
        return sucursales;
    }

    public List<Productos> getHistoriales() {
        return productos;
    }

    public Procedimiento crearProcedimiento(String nombre) {

        Procedimiento procedimiento = null;
        try{
        //conectar a bd
        var conn = BaseDeDatos.conectarABaseDeDatos();
        //crear sentencia para crear elemento
        var stmt = conn.prepareStatement("INSERT INTO procedimiento (nombre) VALUES (?)");
        stmt.setString(1,nombre);
        
        stmt.executeUpdate();
        stmt.close();
        
        
        //consultar elemento
        
      stmt = conn.prepareStatement("SELECT * FROM procedimiento WHERE nombre = ?");
        stmt.setString(1, nombre);
        var rset = stmt.executeQuery();
        if(rset.next()){
            procedimiento = new Procedimiento(rset.getInt("codigo"),
                                              rset.getString("nombre"));
        }
        rset.close();
        stmt.close();
        conn.close();
        
        //devolver elemento
        }catch(SQLException e){
             System.err.print("Error en la Base de Datos" + e.getLocalizedMessage());
 
        }
     
           
        return procedimiento;
    }

    public void eliminarProcedimiento(Integer codigo) {

        try(var conn = BaseDeDatos.conectarABaseDeDatos()){
        
           try ( var stmt = conn.prepareStatement("DELETE FROM procedimiento WHERE codigo = ?")){
             stmt.setInt(1, codigo);
             stmt.executeUpdate();
           }
        
        
        
        
        
        }catch(SQLException e){
            
        }
    }
}
