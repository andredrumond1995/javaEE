package org.bemelaborado.action;
import org.bemelaborado.dao.*;
import org.bemelaborado.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO;
    
    public void init() {
        String dburl = getServletContext().getInitParameter("dburl");
        String dblogin = getServletContext().getInitParameter("dblogin");
        String dbpass = getServletContext().getInitParameter("dbpass");
 
        usuarioDAO = new UsuarioDAO(dburl, dblogin, dbpass); //no web.xml tem os dados referentes aos valores dessas vars
 
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
 
        try {
        		if(action.equals("/novo")) {
        			formUsuario(request, response);
            	}
        		if(action.equals("/listing")) {
        			listarUsuario(request, response);
        		}
        		if(action.equals("/insert")) {
        			inserirUsuario(request, response);
        		}
        	
        		if(action.equals("/delete")) {
        			deletarUsuario(request, response);
        		}
        		if(action.equals("/edit")) {
        			formEditUsuario(request, response);
        		}
        		if(action.equals("/update")) {
        			atualizarUsuario(request, response);
           		}
        	} catch (SQLException ex) {
                throw new ServletException(ex);
            }
              
    }
    private void listarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Usuario> showUsuarios = usuarioDAO.listUsuario();
        request.setAttribute("showUsuarios", showUsuarios);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listing.jsp");
        dispatcher.forward(request, response);
    }
 
    private void formUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("usuarioformulario.jsp");
        dispatcher.forward(request, response);
    }
 
    private void formEditUsuario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        Usuario verificandousuarioporid = usuarioDAO.usuarioporId(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("editform.jsp");
        request.setAttribute("usuario", verificandousuarioporid);
        dispatcher.forward(request, response);
 
    }
 
    private void inserirUsuario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String nome = request.getParameter("nome");
        String idade = request.getParameter("idade");
 
        Usuario inserirusuario = new Usuario(nome,idade);
        usuarioDAO.inserirUsuario(inserirusuario);
        response.sendRedirect("/CRUDbemelaborado/listing");
    }
 
    private void atualizarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String idade = request.getParameter("idade");
        
 
        Usuario usuario = new Usuario(nome,idade,id);
        usuarioDAO.updateUsuario(usuario);
        response.sendRedirect("/CRUDbemelaborado/listing");
    }
 
    private void deletarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String id = request.getParameter("id");
 
        Usuario usuario = new Usuario(id);
        usuarioDAO.deletarUsuario(usuario);
        response.sendRedirect("/CRUDbemelaborado/listing");
 
    }
   
    
}
