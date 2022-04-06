package com.ibm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteTrain extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		
		int tno=Integer.parseInt(request.getParameter("TNO"));  
		
		
		       
		try{  
			
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system"); 
		
		PreparedStatement ps=con.prepareStatement("delete from trainDetail where TNO = (?)");  
		  
		ps.setInt(1,tno);  
		
		
		 
		          
		int i=ps.executeUpdate();  
		if(i>0)  
		out.print("DELETED ADMIN");  
		  con.close();    
		          
		}catch (Exception e2) {System.out.println(e2);}  
		          
		out.close();  
	}
		
		


}
