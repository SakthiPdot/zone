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
            
            <title>Entry</title>
            
            <link href="resources/common/css/bootstrap.css">
			<link href="resources/angular/css/bootstrap-dialog.min.css">
			<script type="text/javascript" src="resources/angular/js/angular.min.js"></script>
			<script type="text/javascript" src="resources/angular/js/app.js"></script>
            
            
</head>


			
<body data-ng-app = "zoneApp" data-ng-controller = "StudentController as ctrl">
			
		Enter	
		
		<form data-ng-submit = "ctrl.submit()" name="pageForm">
			<input type="hidden" data-ng-model = "ctrl.page.stu_id">
			Name <input type="text" class="form-control" data-ng-model = "ctrl.page.name">
			
			Roll No <input type = "text" class="form-control" data-ng-model = "ctrl.page.rollno">
			
			Address <input type="text" class="form-control" data-ng-model = "ctrl.page.address">
			
			Mobile No <input type="text" class="form-control" data-ng-model="ctrl.page.mobileno">
			
			<button data-ng-click="save($event)" type="submit">Save</button>
		</form>
			
			
		<script type="text/javascript" src="resources/angular/js/jquery-1.11.1.min.js"></script>
		<script type="text/javascript" src="resources/common/bootstrap.min.js"></script>
		<script type="text/javascript" src="resources/angular/js/confirmDialog.js"></script>
		<script type="text/javascript" src="resources/angular/js/bootstrap-dialog.min.js"></script>	
		<script type="text/javascript" src="resources/application/student/studentcontroller.js"></script>
		<script type="text/javascript" src="resources/application/student/studentservice.js"></script>
</body>
</html>