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

<style type="text/css">

     input[type='number'] {
        -moz-appearance:textfield;
     }

	 input::-webkit-outer-spin-button,
	 input::-webkit-inner-spin-button {
	    -webkit-appearance: none;
	    margin : 0;
	 }
	 
	 .errorMsg 
	 {
	 	color : red;
	 }
	
</style>


</head>

<body class="bg-dark" data-ng-app = "zoneApp" data-ng-controller = "SignupController as ctrl">

			<div class="container">
			<div class="card card-login mx-auto mt-5">
				<div class="card-header">SignUp</div>
				<div class="card-body">
					<form data-ng-submit = "ctrl.submit()" name="signupForm">
						<input type="hidden" data-ng-model="ctrl.signup.client_id"/>
						<div class="form-group">
							<label>First Name</label>
							<input type="text" class="form-control char" data-ng-model="ctrl.signup.name"  maxlength="6"  required>
						</div>
						<div class="form-group">
							<label>Last Name</label>
							<input type="text" class="form-control charspace" data-ng-model="ctrl.signup.lastname"  maxlength="6" required>
						</div>
						<div class="form-group">
							<label>Username</label>
							<input type="text" class="form-control charnumeric" data-ng-blur="ctrl.checkUsername(ctrl.signup.username)" data-ng-model="ctrl.signup.username"  maxlength="10" required>
							<span class="errorMsg" data-ng-show="nameWrong">This Username Already Choose Someone..!</span>
						</div>
						<div class="form-group">
							<label>Password</label>
							<input type="password" class="form-control"  id="password" data-ng-model="ctrl.signup.password" required>
						</div>
						<div class="form-group">
							<label>Confirm Password</label>
							<input type="password" class="form-control" id="confpassword" required>
						</div>
						
						<div class="form-group">
							<label>Email</label>
							<input type="email" class="form-control" data-ng-model="ctrl.signup.email">
						</div>
						
						<div class="form-group">
							<label>Mobile No</label>
							<input type="text" class="form-control numeric"  maxlength="10"  required data-ng-model="ctrl.signup.mobileno">
						</div>
						
						<div class="form-group">
							<label>City</label>
							<input type="text" class="form-control charnumspace" maxlength="15" data-ng-model="ctrl.signup.city">
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
			
			
			<script>
			
				$("#confpassword").focusout(function(){
					console.log("c");
					var password = $("#password").val();
					var confpassword = $('#confpassword').val();
					console.log(password + " == " + confpassword);
					if(password == confpassword) {
						console.log("match");
						return true;
					}
					console.log("kk");	
					return false;
				});
			
				$("#password").focusin(function(){
					console.log("S");
					console.log("must enter one caps");
					console.log("must enter one small");
					console.log("must enter one special characters");
					console.log("must enter one number");
					console.log("password must should be 8 letters");
					
				});
				
				
				
				
							
			</script>

</body>
</html>