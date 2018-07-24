package com.implementando.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.implementando.bean.Usuario;
import com.implementando.dbconn.Dbconnection;

public class DatabaseOperation {
	Dbconnection db = new Dbconnection();
	ArrayList<Usuario> UsuarioList = new ArrayList<Usuario>();
	
	public String insertData(String nome, String idade) {
		String temp="";
		String sql = "INSERT INTO usuario (nome,idade) values(?,?)";
		Connection con = db.getCon();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, nome);
			stmt.setString(2, idade);
			stmt.executeUpdate();
			temp = "success";
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
	public ArrayList<Usuario> showData(){
			String sql = "SELECT * FROM usuario ORDER BY id ASC";
			Connection con = db.getCon();
			try {
				
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery(sql);
				while(rs.next()) {
					Usuario usuario = new Usuario();
					String id = rs.getString("id");
					String nome = rs.getString("nome");
					String idade = rs.getString("idade");
					
					usuario.setId(id);
					usuario.setNome(nome);
					usuario.setIdade(idade);
					UsuarioList.add(usuario);
				}
				for(int i=0;i<UsuarioList.size();i++) {
					System.out.println(UsuarioList.get(i).getId()+"   "+UsuarioList.get(i).getNome()+ "   "+UsuarioList.get(i).getIdade());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return UsuarioList;
	}
	
	
	public String delData(String id) {
		String temp="";
		String sql = "DELETE FROM usuario WHERE id = ?";
		Connection con = db.getCon();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.execute();
			temp = "success";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	public Usuario updtUsuario (String nome, String idade, String id) {
		Usuario user = new Usuario();
		String sql = "UPDATE usuario SET nome=?, idade=?";
		sql += " WHERE id=?";
		Connection con = db.getCon();
        try {
        	PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, nome);
			ps.setString(2, idade);
			ps.setString(3, id);
			
			ps.executeUpdate();
			ps.close();
			con.close();
           
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
