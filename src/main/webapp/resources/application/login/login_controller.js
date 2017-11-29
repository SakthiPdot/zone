zoneApp.controller('LoginController',['$scope','LoginService', function ($scope,LoginService){
	
			var self = this;
			self.login = {};
			self.alllogin = [];
			
						
			self.submit = function () {
			
				LoginService.getLogin(self.login)
					.then(
								function(login){
									
									console.log("nj ",login ," c");
									if(login == "null"){
										console.log("if");
									} else {
										console.log("else");										
										window.location.replace("dashboard");
									}
																	
								},function(errResponse){
									console.log("errorr");
								}
						  );
			}
			
}]);