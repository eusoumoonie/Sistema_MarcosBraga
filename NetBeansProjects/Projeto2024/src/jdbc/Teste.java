/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author u09192385133
 */
public class Teste {
     public static void main(String[] args){
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
             Statement stm = cnt.createStatement();

             
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
             
         } catch (SQLException ex) {
             Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
         }
         System.out.println("Rodou");
    }
 
}

