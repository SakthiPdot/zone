<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
			<meta charset="utf-8"/>
			<%-- <meta name="_csrf" content="${_csrf.token}"/>
			<meta name="_csrf_header" content="${_csrf.headerName}">  --%>
   			<title>Signup</title>
			<link href="resources/common/css/bootstrap.css">
			<link href="resources/angular/css/bootstrap-dialog.min.css">
			<link href="resources/common/css/dataTables.bootstrap.css">
			<script type="text/javascript" src="resources/angular/js/angular.min.js"></script>
			<script type="text/javascript" src="resources/angular/js/app.js"></script>

<style type="text/css">
		.errorMsg{
			color : red;
		}
		
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

<body data-ng-app = "zoneApp" data-ng-controller ="SignupController as ctrl">
			
			
			<!-- <table>	
					<thead>
						<tr>
							<th>Username</th>
							<th>Password</th>
							<th>Mobile No</th>
						</tr>
					</thead>
					
					<tbody>				
					<tr data-ng-repeat = "signup in ctrl.signupall" data-ng-dblclick="ctrl.updateSignup(signup)">
						<td>{{signup.username}}</td>
						<td>{{signup.password}}</td>
						<td>{{signup.mobileno}}</td>
					</tr>
					</tbody>	
					
						
			</table> -->
			
			
			<h2>SignUp</h2> 
			
			<form data-ng-submit = "ctrl.submit()" name ="signupForm">
			<!-- <input type="hidden" data-ng-model = "ctrl.signup.client_id"/>
			First Name<input type="text" data-ng-model="ctrl.signup.name">
			<br>
			Last Name<input type="number" data-ng-model="ctrl.signup.lastname">
			<br>
			Username <input type="text" data-ng-blur="ctrl.checkUsername(ctrl.signup.username)" data-ng-model="ctrl.signup.username">
			<span class="errorMsg" data-ng-show = "nameWrong">This Username Already Choose Someone..!</span>
			<br>
			Password<input type="password" data-ng-model="ctrl.signup.password">
			<br>
			Email<input type="email" data-ng-model="ctrl.signup.email">
			<br>
			Mobile No<input type="number" data-ng-model="ctrl.signup.mobileno" required>
			<br>
			City <input type="text" data-ng-model="ctrl.signup.city">
			<br>
			State <input type="text" data-ng-model="ctrl.signup.state">
			<br> -->
			
			<label>Number</label>
			<input type="number" onkeypress = "return CheckIsNumeric(event)" required>
			<br>
			<label>Float</label>
			<input type="number" onkeypress = "return CheckIsNumericAnddot(event,this.value)" required>
			<br>
			<label>Number with (-)</label>
			<input type="number" onkeypress = "return CheckIsNumericAndHyphen(event)" required>
			<br>
			<label>Character and Letter</label>
			<input type="text"    onkeyup = "this.value = this.value.replace(/[^a-zA-Z0-9]/,'')" required>
			<br>
			<label>Character</label>
			<input type="text" onkeyup="this.value = this.value.replace(/[^a-z]/,'')" required>
			<br>
			<label>Character with Space</label>
			<input type="text" onkeyup="this.value = this.value.replace(/[^a-z\-\s]/,'')" maxlength="10" required>
			<br>
			<label>Character Letter with Space</label>
			<input type="text" name="num" maxlength="10" required>
			<br>
			<button data-ng-click ="save($event)" type="submit">Submit</button>
			<button data-ng-click ="ctrl.deleteSignup()">Delete</button>
			
			
			</form>

			
			<script type="text/javascript" src="resources/angular/js/jquery-1.11.1.min.js"></script>
			<script type="text/javascript" src="resources/common/bootstrap.min.js"></script>
			<script type="text/javascript" src="resources/application/signup/signup_controller.js"></script>
			<script type="text/javascript" src="resources/application/signup/signup_service.js"></script>
			<!-- <script type="text/javascript" src="resources/common/session.js"></script> -->
			<script type="text/javascript" src="resources/common/js/dataTables.bootstrap.js"></script>
			<script type="text/javascript" src="resources/angular/js/confirmDialog.js"></script>
			<script type="text/javascript" src="resources/angular/js/bootstrap-dialog.min.js"></script>	
			<script type="text/javascript" src="resources/common/validation.js"></script>
			
			<script type="text/javascript">
			
			/* $('input[name="num"]').keypress(function() {
			    if (this.value.length >= 5) {
			        return true;
			    }
			}); */
			 
			</script>
</body>
</html>
