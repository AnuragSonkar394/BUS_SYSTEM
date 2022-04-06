<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="AdminPanel border border-info shadow-lg p-3 mb-5 bg-body rounded ">
     <h1> Enter BUSNO To Delete</h1>
     <form action="DeleteTrain" method="post"> 
  TNO:<input type="number" name="TNO"><br></br>
  <input type="submit" class="btn btn-dark"  name="DELETE">
  </form>
   </div>
</body>
</html>