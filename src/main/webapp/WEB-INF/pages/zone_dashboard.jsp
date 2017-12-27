<!DOCTYPE html>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
    <%@ page isELIgnored="false" %>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
       <title>Dashboard</title>
  
  <!-- Bootstrap core CSS-->
  <link href="resources/common/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="resources/common/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="resources/common/css/sb-admin.css" rel="stylesheet">
  
</head>
<body>

	<h2>Dashboard</h2>Hi ${names}
	<br>
	Username ${username}
	
	<br>
	client ID ${clientid }
	<br>
	User ID ${userid}
	<br>

	
	<a href="student"> Application</a><br>
	<a href="user">User</a>
	
	<a href="${pageContext.servletContext.contextPath}/logout">Logout</a>

  <script src="resources/angular/js/jquery-1.11.1.min.js"></script>
  <script src="resources/common/js/popper.min.js"></script>
  <script src="resources/common/bootstrap.min.js"></script>

</body>
</html>