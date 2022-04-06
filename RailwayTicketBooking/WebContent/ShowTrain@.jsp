<%@ page import="java.sql.*" %>
<% Class.forName("oracle.jdbc.driver.OracleDriver"); %>
<HTML>
       <HEAD>
       <TITLE>Select BUS</TITLE>
       <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
       </HEAD>
       <BODY >
          <div class="AdminPanel border border-info shadow-lg p-3 m-5 bg-body rounded ">
            <H1 class="text-center">AVAILABLE SERVICES</H1>
            <%
                Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe","system","system");
                Statement statement = connection.createStatement() ;
                ResultSet resultset =
                statement.executeQuery("select * from traindetail") ;
            %>
                <TABLE class="table table-info">
           <TR>
                 <TH class="text-center">Bus Number</TH>
                 <TH class="text-center">Bus Name</TH>
                 <TH class="text-center">FROM</TH>
                 <TH class="text-center">TO</TH>
                 
          </TR>
           <% while(resultset.next()){ %>
           <TR>
                <TD class="text-center"> <%= resultset.getString(1) %></td>
               <TD class="text-center"> <%= resultset.getString(2) %></TD>
               <TD class="text-center"> <%= resultset.getString(3) %></TD>
               <TD class="text-center"> <%= resultset.getString(4) %></TD>
             
          </TR>
           <% } %>
               </TABLE>
  
    <form action="RegisterTrain" method="post"> 
 
   <H4>BOOK WITH BUS NUMBER</H4>
  
  Passenger Name: <input type="text" name="passengername"><br></br>
  BUS NO: <input type="number" name="tno"><br></br>
  <input type="submit" class="btn btn-dark"  value="BOOK"> <br></br>
 </form>
 </div>
         </BODY>
</HTML>