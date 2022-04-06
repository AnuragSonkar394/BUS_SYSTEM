<%@ page import="java.sql.*" %>
<% Class.forName("oracle.jdbc.driver.OracleDriver"); %>
<HTML>
       <HEAD>
       <TITLE>Select BUS</TITLE>
       <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
       </HEAD>
       <BODY >
      <div class="AdminPanel border border-info shadow-lg p-3 mb-5 bg-body rounded ">
            <H1>AVAILABLE SERVICES</H1>
            <%
                Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe","system","system");
                Statement statement = connection.createStatement() ;
                ResultSet resultset =
                statement.executeQuery("select * from traindetail") ;
            %>
                <TABLE BORDER="1">
           <TR>
                 <TH>Bus Number</TH>
                 <TH>Bus Name</TH>
                 <TH>FROM</TH>
                 <TH>TO</TH>
                 
          </TR>
           <% while(resultset.next()){ %>
           <TR>
                <TD> <%= resultset.getString(1) %></td>
               <TD> <%= resultset.getString(2) %></TD>
               <TD> <%= resultset.getString(3) %></TD>
               <TD> <%= resultset.getString(4) %></TD>
             
          </TR>
           <% } %>
               </TABLE>
  
    <form action="RegisterBus.jsp" method="get"> 
 
   <H4>BOOK WITH BUS NUMBER</H4>
  BUS NO: <input type="number" name="tno"><br></br>
  
  <input type="submit" class="btn btn-dark"  value="BOOK"> <br></br>
 </form>
 </div>
         </BODY>
</HTML>