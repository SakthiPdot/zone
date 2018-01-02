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
	
	<style type="text/css">
	
		.errorMsg{
			color : red;
		}
		
	</style>
	
	</head>
	
	<body data-ng-app="zoneApp" data-ng-controller="UserController as userctrl">
			
			<table border="1" style="width:100%;"> 
				<thead>
					<tr>
						<th>S.No</th>
						<th data-ng-click="orderTable('name')">Name</th>
						<th data-ng-click="orderTable('username')">Username</th>
						<th>Role</th>
						<th>Email</th>
						<th>Mobile No</th>
					</tr>
				</thead>
				
				<tbody>
					<tr data-ng-dblclick="userctrl.updateUser(user)" data-ng-repeat = "user in userctrl.userall | orderBy:Table">
						<td>{{$index+1}}</td>
					    <td>{{user.name}}</td>
						<td>{{user.username}}</td>
						<td>{{user.role.role_name}}</td>
						<td>{{user.email}}</td>
						<td>{{user.mobileno}}</td>
					</tr>
			    </tbody>
			</table>
			
			<form data-ng-submit="userctrl.submit()" name = "userForm">
				
				<input type="hidden" data-ng-model="userctrl.user.user_id">
				<br>
				Name<input type="text" data-ng-model="userctrl.user.name">
				<br>
				Username<input type="text" data-ng-blur="userctrl.checkUsername(userctrl.user.username)" data-ng-model="userctrl.user.username">
				<span class="errorMsg" data-ng-show="nameWrong"> This Username Already Choose Someone..! </span>
				<br>
				Password<input type="text" data-ng-model="userctrl.user.password">
				<br>
				 Role<select data-ng-options="role.role_id as role.role_name for role in userctrl.roles" data-ng-model="userctrl.user.role_id">
							<option value="">-- Select --</option>
					</select>
				<br> 
				Email <input type="text" data-ng-model="userctrl.user.email">
				<br>
				Mobile No <input type="text" data-ng-model="userctrl.user.mobileno">
				<br>
				<button data-ng-click="save($event)" type="submit">Save</button>
				<button type="button" onclick="location.href='User List'; valid = true">Excel</button>
			</form>
			<br>
			
			
					
			
			
			<script type="text/javascript" src="resources/angular/js/jquery-1.11.1.min.js"></script>
			<script type="text/javascript" src="resources/common/bootstrap.min.js"></script>
			<script type="text/javascript" src="resources/application/user/user_controller.js"></script>
			<script type="text/javascript" src="resources/application/user/user_service.js"></script>			
			<script type="text/javascript" src="resources/angular/js/confirmDialog.js"></script>
			<script type="text/javascript" src="resources/angular/js/bootstrap-dialog.min.js"></script>	
	</body>
</html>