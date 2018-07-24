package org.bemelaborado.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.bemelaborado.model.*;

public class UsuarioDAO {
	private String dburl;
	private String dblogin;
	private String dbpass;
	private Connection dbcon;
	
	public UsuarioDAO(String dburl, String dblogin, String dbpass) { // esse construtor vai ser utilizado la no controllermain
		this.dburl = dburl;											
		this.dblogin = dblogin;
		this.dbpass = dbpass;
	}
	
	protected void connect() throws SQLException{
		if(dbcon == null || dbcon.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			dburl = "jdbc:mysql://localhost/struts";
			dblogin = "root";
			dbpass = "root";
			dbcon = DriverManager.getConnection(dburl, dblogin, dbpass);
		}
	}
	
	protected void disconnect() throws SQLException{
		if(dbcon != null && !dbcon.isClosed()) {
			dbcon.close();
		}
	}
	
	public boolean inserirUsuario(Usuario usuario) throws SQLException {
		String sql = "INSERT INTO usuario (nome,idade) VALUES (?,?)";
		connect();
		
		PreparedStatement stmt = dbcon.prepareStatement(sql);
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getIdade());
		
		boolean inserido = stmt.executeUpdate() > 0;
		stmt.close();
		disconnect();
		return inserido;
	}
	
	public List<Usuario> listUsuario() throws SQLException {
		List<Usuario> showUsuarios = new ArrayList<>();
		String sql = "SELECT * FROM usuario ORDER BY id ASC";
		connect();
		Statement stmt = dbcon.createStatement();
		ResultSet resultSet = stmt.executeQuery(sql);
		while (resultSet.next()) {
			String id = resultSet.getString("id");
			String nome = resultSet.getString("nome");
			String idade = resultSet.getString("idade");
			
			Usuario usuario = new Usuario(nome, idade, id);
			
			showUsuarios.add(usuario);
		}
		resultSet.close();
		stmt.close();
		disconnect();
			
		return showUsuarios;
	}
	
	public boolean deletarUsuario(Usuario usuario) throws SQLException{
		String sql = "DELETE FROM usuario WHERE id = ?";
		connect();
		PreparedStatement stmt = dbcon.prepareStatement(sql);
		stmt.setString(1, usuario.getId());
		
		boolean deletado = stmt.executeUpdate() > 0;
		stmt.close();
		disconnect();
		return deletado;
	}
	
	public boolean updateUsuario (Usuario usuario) throws SQLException{
		String sql = "UPDATE usuario SET nome = ?, idade = ?";
		sql += "WHERE id = ?";
		connect();
		PreparedStatement stmt = dbcon.prepareStatement(sql);
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getIdade());
		stmt.setString(3, usuario.getId());
		
		boolean atualizado = stmt.executeUpdate() > 0;
		stmt.close();
		disconnect();
		return atualizado;
		
	}
	
	public Usuario usuarioporId(String id) throws SQLException {
		Usuario usuario = null;
		String sql = "SELECT * FROM usuario WHERE id = ?";
		
		connect();
		
		PreparedStatement stmt = dbcon.prepareStatement(sql);
		stmt.setString(1, id);
		
		ResultSet resultSet = stmt.executeQuery();
		
		if(resultSet.next()) {
			String nome = resultSet.getString("nome");
			String idade = resultSet.getString("idade");
			
			usuario = new Usuario (nome, idade, id);
			
		}
		
		resultSet.close();
		stmt.close();
		return usuario;
	}
	
}
