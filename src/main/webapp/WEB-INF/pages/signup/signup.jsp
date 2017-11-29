<!DOCTYPE html>

<html lang="en">
<head>
			<meta charset="utf-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
			<meta name="description" content="">
			<meta name="author" content="">

			<title>SignUp</title>
			
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

<body class="bg-dark" data-ng-app = "zoneApp" data-ng-controller = "SignupController as ctrl">

			SignUp
			
			<div class="container">
			<div class="card card-login mx-auto mt-5">
				<div class="card-header">SignUp</div>
				<div class="card-body">
					<form data-ng-submit = "ctrl.submit()" name="signupForm">
						<input type="hidden" data-ng-model="ctrl.signup.client_id"/>
						<div class="form-group">
							<label>First Name</label>
							<input type="text" class="form-control" data-ng-model="ctrl.signup.name">
						</div>
						<div class="form-group">
							<label>Last Name</label>
							<input type="text" class="form-control" data-ng-model="ctrl.signup.lastname">
						</div>
						<div class="form-group">
							<label>Username</label>
							<input type="text" class="form-control" data-ng-model="ctrl.signup.username">
						</div>
						<div class="form-group">
							<label>Password</label>
							<input type="password" class="form-control" data-ng-model="ctrl.signup.password">
						</div>
						<div class="form-group">
							<label>Email</label>
							<input type="email" class="form-control" data-ng-model="ctrl.signup.email">
						</div>
						<div class="form-group">
							<label>City</label>
							<input type="text" class="form-control" data-ng-model="ctrl.signup.city">
						</div>
						<div class="form-group">
							<label>State</label>
							<input type="text" class="form-control" data-ng-model="ctrl.signup.state">
						</div>
						
						<button class="btn btn-primary btn-block" data-ng-click="save($event)" type="submit"> Save</button>
					</form>
				</div>
			</div>
			</div>
			
			<script src="resources/angular/js/jquery-1.11.1.min.js"></script>
			<script src="resources/common/js/popper.min.js"></script>
			<script src="resources/common/bootstrap.min.js"></script>
			<script type="text/javascript" src="resources/application/signup/signup_controller.js"></script>
			<script type="text/javascript" src="resources/application/signup/signup_service.js"></script>
			<!-- <script type="text/javascript" src="resources/common/session.js"></script> -->
			<script type="text/javascript" src="resources/common/js/dataTables.bootstrap.js"></script>
			<script type="text/javascript" src="resources/angular/js/confirmDialog.js"></script>
			<script type="text/javascript" src="resources/angular/js/bootstrap-dialog.min.js"></script>	
			<script type="text/javascript" src="resources/common/validation.js"></script>

</body>
</html>