/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author u09192385133
 */
public class TesteSelect {
    public static void main(String[] args) {
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             String url, user, pass;
             url = "jdbc:mysql://localhost:3306/db_edivilson_mioto";
             user = "edivilson_mioto";
             pass = "edivilson_mioto";
             //url = "jdbc:mysql://10.7.0.51:33062/db_edivilson_mioto";
             //user = "edivilson_mioto";
             //pass = "edivilson_mioto";
             Connection cnt;
             cnt = DriverManager.getConnection(url, user, pass);
             System.out.println("certo");
             Statement stm;
             stm = cnt.createStatement();
             ResultSet rs;
             rs = stm.executeQuery("selet * from ebm_usuarios");
             while(rs.next() == true) {
                 System.out.println(rs.getString("ebm_idusuarios"));
                 System.out.println(rs.getString("ebm_nome"));
             }
             
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(TesteSelect.class.getName()).log(Level.SEVERE, null, ex);
             
         } catch (SQLException ex) {
             Logger.getLogger(TesteSelect.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
