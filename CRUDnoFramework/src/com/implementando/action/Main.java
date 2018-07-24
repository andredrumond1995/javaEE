package com.implementando.action;
import com.implementando.*;
import com.implementando.dao.*;
import com.implementando.bean.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DatabaseOperation dao;
	/**
     * Default constructor. 
     */
	public Main() {
		// TODO Auto-generated constructor stub
		super();
        dao = new DatabaseOperation();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		        
		
        }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		DatabaseOperation dao = new DatabaseOperation();
		String check;
		check = request.getParameter("check");
		
		if(check.equals("update")) {
			String idupdt = request.getParameter("id");
			String nomeupdt = request.getParameter("nome");
			String idadeupdt = request.getParameter("idade");
			dao.updtUsuario(nomeupdt, idadeupdt, idupdt);
			response.sendRedirect("showdata.jsp");
		} 
		if(check.equals("insert")) {
			String nome = request.getParameter("nome");
			String idade = request.getParameter("idade");
			dao.insertData(nome,idade);
			response.sendRedirect("showdata.jsp");
		} 
        if(check.equals("delete")) {
			String id = request.getParameter("id");
			dao.delData(id);
			response.sendRedirect("showdata.jsp");
		}
				
	}
	
	
   

}
