/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemmnguniversity;

import java.sql.Connection;
import java.sql.DriverManager;


public class DataBase {
    
    public static Connection connectDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost/gestion_ecole_formation", "root", "");
            return cnx;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
