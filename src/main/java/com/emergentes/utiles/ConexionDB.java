package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ConexionDB {
   static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/bd_eventos";
    static String usuario = "root";
    static String password = "";
    Connection conn = null;
    public ConexionDB(){
    try {
    // especificaciuon de driver
    Class.forName(driver);
    //establece la conexion a la base de datos
    conn = DriverManager.getConnection(url, usuario, password);
    // verificar si la conexion fue exitosa
    if (conn != null){
        System.out.println("conexion ok:" + conn);
    }
    }
    catch (SQLException ex){
    System.out.println("Error del sql" + ex.getMessage());
    
    }
    catch (ClassNotFoundException ex){
        Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }
    public Connection conectar()
    {
    return conn;
    }
    public void desconectar()
    {
    try{
    conn.close();
    }
    catch (SQLException ex){
    Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
