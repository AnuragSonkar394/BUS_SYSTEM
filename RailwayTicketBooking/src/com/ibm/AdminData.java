package com.ibm;

import java.io.*;  
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.http.*;

 

  
public class AdminData extends HttpServlet {  

	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String uname=request.getParameter("Adname");
String pwd=request.getParameter("Adpass"); 
  

          
try{
	
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system"); 

String vsql="select *from Admindetail"; 

Statement st= con.createStatement();
ResultSet rs=st.executeQuery(vsql);


while (rs.next()) 
{ 
	if(rs.getString(1).equals(uname)&& rs.getString(2).equals(pwd))
	{ 
		RequestDispatcher rd=request.getRequestDispatcher("/AdminLogin.jsp");  
         rd.forward(request, response); 
         con.close();
         break;
    } 

 
	
 
       
      
}  
    out.print("Sorry UserName or Password Error!");  
    RequestDispatcher rd=request.getRequestDispatcher("/web.html");  
    rd.include(request, response);  
  


con.close();
 }
catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
  
}  

