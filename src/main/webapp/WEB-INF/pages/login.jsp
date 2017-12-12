
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
			<title>Login</title>
	        <!-- Bootstrap core CSS-->
			<link href="resources/common/css/bootstrap.min.css" rel="stylesheet">
			<!-- Custom fonts for this template-->
			<link href="resources/common/css/font-awesome.min.css" rel="stylesheet" type="text/css">
			<!-- Custom styles for this template-->
			<link href="resources/common/css/sb-admin.css" rel="stylesheet">
		    <link href="resources/angular/css/bootstrap-dialog.min.css">
			<script type="text/javascript" src="resources/angular/js/angular.min.js"></script>
			<script type="text/javascript" src="resources/angular/js/app.js"></script>
</head>


<body class="bg-dark" data-ng-app = "zoneApp" data-ng-controller = "LoginController as ctrl">
	
	<!-- <form data-ng-submit = "ctrl.submit()" name = "loginForm"> -->
	Login
	
	<!-- Username <input type="text" data-ng-model = "ctrl.login.username">
	Password <input type="password" data-ng-model = "ctrl.login.password">
	<button data-ng-click = "save($event)" type="submit">Login</button> -->
	
	<div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">Login <a href="sign_up"><i class="fa fa-user-o fa-2x pull-right" aria-hidden="true"></i></a></div>
      <div class="card-body">
        <form data-ng-submit = "ctrl.submit()" name = "loginForm">
          <div class="form-group">
            <label>Username</label>
            <input class="form-control"  type="text" name="username" onkeyup="this.value = this.value.replace(/[^a-zA-Z]/,'')" maxlength="10" required data-ng-model = "ctrl.login.username"  placeholder="Username">
          </div>
          <div class="form-group">
            <label >Password</label>
            <input class="form-control"  type="password" name="password" data-ng-model = "ctrl.login.password"  placeholder="Password">
          </div>
          <!-- <div class="form-group">
            <div class="form-check">
              <label class="form-check-label">
                <input class="form-check-input" type="checkbox"> Remember Password</label>
            </div>
          </div> -->
          <button class="btn btn-primary btn-block" data-ng-click = "save($event)" type="submit">Login</button>
        </form>
        </div>
    </div>
  </div>
  
	<!-- </form> -->
	<a href="dashboard">Dashboard</a>
	<a href="z_user">User</a>
	
	
	        <script src="resources/angular/js/jquery-1.11.1.min.js"></script>
			<script src="resources/common/js/popper.min.js"></script>
			<script src="resources/common/bootstrap.min.js"></script>
			<script type="text/javascript" src="resources/application/login/login_controller.js"></script>
			<script type="text/javascript" src="resources/application/login/login_service.js"></script>
			<!-- <script type="text/javascript" src="resources/common/session.js"></script> -->
			<script type="text/javascript" src="resources/angular/js/confirmDialog.js"></script>
			<script type="text/javascript" src="resources/angular/js/bootstrap-dialog.min.js"></script> 
</body>
</html>