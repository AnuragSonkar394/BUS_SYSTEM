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


public class AddTrainServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		int tno=Integer.parseInt(request.getParameter("tno"));
		String tname=request.getParameter("tname"); 
		String src=request.getParameter("src"); 
		String dest=request.getParameter("dest"); 
		  

		          
		try{
			
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system"); 

		PreparedStatement ps=con.prepareStatement("insert into TrainDetail  values(?,?,?,?)");  
		  
		ps.setInt(1,tno);  
		ps.setString(2,tname);
		ps.setString(3,src);
		ps.setString(4,dest);
		 
		          
		int i=ps.executeUpdate();  
		if(i>0)  
		out.print("ADDED ADMIN"); 

		

		 
			
		 
		       
		      
		
		    
		  


		con.close();
		 }
		catch (Exception e2) {System.out.println(e2);}  
		          
		out.close();  
		
		
		
		
	}

}
