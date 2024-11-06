/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.Ebm_Usuarios;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author u09192385133
 */
public class UsuariosDAO extends DAOAbstract {


    private Connection connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url, user, pass;
//            url = "jdbc:mysql://localhost:3306/db_edivilson_mioto";;
//            user = "root";
//            pass = "";
            url = "jdbc:mysql://10.7.0.51:33062/db_edivilson_mioto";
            user = "edivilson_mioto";
            pass = "edivilson_mioto";
            Connection conn;
            conn = DriverManager.getConnection(url, user, pass);
            return conn;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(Object object) {
        Ebm_Usuarios usuarios = (Ebm_Usuarios) object;
        try {
            String sql = "INSERT INTO Ebm_usuarios VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = this.connection().prepareStatement(sql);
            pstmt.setInt(0, usuarios.getIdusuarios());
            pstmt.setString(1, usuarios.getNome());
            pstmt.setString(2, usuarios.getApelido());
            pstmt.setString(3, usuarios.getCpf());
            pstmt.setDate(4, null);
            pstmt.setString(5, usuarios.getSenha());
            pstmt.setInt(6, usuarios.getNivel());
            pstmt.setString(7, usuarios.getAtivo());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Object object) {
        Ebm_Usuarios usuarios = (Ebm_Usuarios) object;
        try {
            String sql = "UPDATE ebm_usuarios SET ebm_nome?, apelido=?, WHERE ebm_id_codigo";
            PreparedStatement pstmt = this.connection().prepareStatement(sql);
            pstmt.setString(0, usuarios.getNome());
            pstmt.setString(1, usuarios.getApelido());
            pstmt.setInt(2, usuarios.getIdusuarios());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        Ebm_Usuarios usuarios = (Ebm_Usuarios) object;
        try {
            String sql = "DELETE FROM ebm_usuarios WHERE ebm_id_usuarios = ?";
            PreparedStatement pstmt = this.connection().prepareStatement(sql);
            pstmt.setInt(0, usuarios.getIdusuarios());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        Ebm_Usuarios usuarios = new Ebm_Usuarios();
        try {
            String sql = "SELECT * FROM ebm_usuarios WHERE ebm_id_usuarios = ?";
            PreparedStatement pstmt = this.connection().prepareStatement(sql);
            pstmt.setInt( 0,id);
            ResultSet rs;
            rs = pstmt.executeQuery();
            if(rs.next()){
                usuarios.setIdusuarios(rs.getInt("ebm_id_usuarios"));
                usuarios.setNome(rs.getString("ebm_nome"));
                usuarios.setApelido(rs.getString("ebm_apelido"));
                usuarios.setCpf(rs.getString("ebm_cpf"));
                usuarios.setDataNascimento(rs.getDate("ebm_dataNascimento"));
                usuarios.setSenha(rs.getString("ebm_senha"));
                usuarios.setNivel(rs.getInt("ebm_nivel"));
                usuarios.setAtivo(rs.getString("ebm_ativo"));
            }
         
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List listAll() {
        Ebm_Usuarios usuarios = new Ebm_Usuarios();
        try {
            String sql = "SELECT * FROM ebm_usuarios";
            PreparedStatement pstmt = this.connection().prepareStatement(sql);
            ResultSet rs;
            rs = pstmt.executeQuery();
            List<Object> lista = new Vector<>();
            while(rs.next()){
                usuarios.setIdusuarios(rs.getInt("ebm_id_usuarios"));
                usuarios.setNome(rs.getString("ebm_nome"));
                usuarios.setApelido(rs.getString("ebm_apelido"));
                usuarios.setCpf(rs.getString("ebm_cpf"));
                usuarios.setDataNascimento(rs.getDate("ebm_dataNascimento"));
                usuarios.setSenha(rs.getString("ebm_senha"));
                usuarios.setNivel(rs.getInt("ebm_nivel"));
                usuarios.setAtivo(rs.getString("ebm_ativo"));
                
                lista.add(usuarios);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void main(String[] args) {
        
    }

}
