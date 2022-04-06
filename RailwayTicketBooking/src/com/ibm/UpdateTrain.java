package com.ibm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateTrain
 */
public class UpdateTrain extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");  
			PrintWriter out = response.getWriter();  
			          
			int oldtno=Integer.parseInt(request.getParameter("oldtno"));
			int newtno=Integer.parseInt(request.getParameter("newtno"));
			String tname=request.getParameter("tname");
			String src=request.getParameter("src");
			String dest=request.getParameter("dest");
			

			
			
			
			
			
			       
			try{  
				
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system"); 
			
			PreparedStatement ps=con.prepareStatement("update traindetail set TNO=(?), TNAME=(?),SRC=(?),DEST=(?) where TNO=(?)" );  
			  
			ps.setInt(1,newtno); 
			ps.setString(2,tname); 
			ps.setString(3,src); 
			ps.setString(4,dest); 
			ps.setInt(5,oldtno); 
			
			
			 
			          
			int i=ps.executeUpdate();  
			if(i>0)  
			out.print("UPDATED ADMIN");  
			  con.close();    
			          
			}catch (Exception e2) {System.out.println(e2);}  
			          
			out.close();  
		}
			

}
