/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler.connect;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Helder Castrillon
 */
public class pgConnect {

    public pgConnect() {
    }
    

    
    public  Connection settingConnect() throws ClassNotFoundException, SQLException{
        String cadena = "jdbc:postgresql://192.168.200.166:5432/alquiler";
        String user ="postgres";
        String pass = "123456";
        Class.forName("org.postgresql.Driver");
        Connection conex = DriverManager.getConnection(cadena,user,pass);
        return conex;
    }
 
  
}
