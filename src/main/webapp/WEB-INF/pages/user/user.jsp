<!DOCTYPE html>
<%@ page isELIgnored = "false" %>
<html lang="en">
	<head>
		
			<meta charset="utf-8">
			<title>User</title>
			<link href="resources/common/css/bootstrap.css">
			<link href="resources/angular/css/bootstrap-dialog.min.css">
			<script type="text/javascript" src="resources/angular/js/angular.min.js"></script>
			<script type="text/javascript" src="resources/angular/js/app.js"></script>
	</head>
	
	<body data-ng-app="zoneApp" data-ng-controller="UserController as userctrl">
			
			<form data-ng-submit="userctrl.submit()" name = "userForm">
				<input type="text" data-ng-model="userctrl.user.user_id">
				Name<input type="text" data-ng-model="userctrl.user.name">
				<br>
				Username<input type="text" data-ng-model="userctrl.user.username">
				<br>
				Password<input type="text" data-ng-model="userctrl.user.password">
				<br>
				Email <input type="text" data-ng-model="userctrl.user.email">
				<br>
				Mobile No <input type="text" data-ng-model="userctrl.user.mobileno">
				<br>
				<button data-ng-click="save($event)" type="submit">Save</button>
			</form>
			
			<script type="text/javascript" src="resources/angular/js/jquery-1.11.1.min.js"></script>
			<script type="text/javascript" src="resources/common/bootstrap.min.js"></script>
			<script type="text/javascript" src="resources/application/user/user_controller.js"></script>
			<script type="text/javascript" src="resources/application/user/user_service.js"></script>			
			<script type="text/javascript" src="resources/angular/js/confirmDialog.js"></script>
			<script type="text/javascript" src="resources/angular/js/bootstrap-dialog.min.js"></script>	
	</body>
</html>