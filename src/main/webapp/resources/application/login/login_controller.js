
zoneApp.controller('LoginController',['$scope','LoginService', function ($scope,LoginService){
	
			var self = this;
			self.login = {};
			self.alllogin = [];
			
						
			self.submit = function () {
			
				LoginService.getUsername(self.login)
					.then(
								function(login){
									if(login == true) {
										self.alllogin = login;
										console.log(login+"if");
										window.location.replace("dashboard");
									} else {
										console.log(login + "else");
									}
									
									/*window.location.replace("dashboard");*/
									/*
									if(login.data == true) {
										self.alllogin = login;
										console.log(login.data+"if");
										window.location.replace("dashboard");
										
									} else {
										console.log(login.data + "else");
									}*/
									
									
								},function(errResponse){
									console.log("errorr");
								}
						  );
			}
			
}]);