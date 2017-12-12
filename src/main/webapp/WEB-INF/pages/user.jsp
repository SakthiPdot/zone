<!DOCTYPE html>

<html lang="en">
<head>
			<meta charset="utf-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
			<meta name="description" content="">
			<meta name="author" content="">

			<title>User</title>
			
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
	
</style>

</head>

<body class="bg-dark" data-ng-app = "zoneApp">

			<div class="container">
			<div class="card card-login mx-auto mt-5">
				<div class="card-header">User</div>
				<div class="card-body">
					<form data-ng-submit="userctrl.submit()" name = "userForm">
						<input type="hidden"/>
						<div class="form-group">
							<label>Name</label>
							<input type="text" class="form-control" onkeyup="this.value = this.value.replace(/[^a-zA-Z]/,'')" maxlength="15" required>
						</div>
						<div class="form-group">
							<label>Username</label>
							<input type="text" class="form-control" onkeyup="this.value = this.value.replace(/[^a-zA-Z]/,'')" maxlength="10" required>
						</div>
						
						<div class="form-group">
							<label>Password</label>
							<input type="password" class="form-control" pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$"   required>
						</div>
						
						
						<div class="form-group">
							<label>Email</label>
							<input type="email" class="form-control" data-ng-model="ctrl.signup.email">
						</div>
						
						<div class="form-group">
							<label>Mobile No</label>
							<input type="number" class="form-control" onkeypress = "return CheckIsNumeric(event)" maxlength ="10" required data-ng-model="ctrl.signup.mobileno">
						</div>
						
											
						<button class="btn btn-primary btn-block"> Save</button>
					</form>
				</div>
			</div>
			</div>
			
			<script src="resources/angular/js/jquery-1.11.1.min.js"></script>
			<script src="resources/common/js/popper.min.js"></script>
			<script src="resources/common/bootstrap.min.js"></script>
			<script type="text/javascript" src="resources/common/js/dataTables.bootstrap.js"></script>
			<script type="text/javascript" src="resources/angular/js/confirmDialog.js"></script>
			<script type="text/javascript" src="resources/angular/js/bootstrap-dialog.min.js"></script>	
			<script type="text/javascript" src="resources/common/validation.js"></script>
			
			
</body>
</html>