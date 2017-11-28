zoneApp.factory('LoginService',['$http','$q', function ($http,$q){
		
		var factory = {
				getUsername : getUsername	
		};
		
		return factory;
		
		function getUsername(login){
			
			var deferred = $q.defer();
			
			$http({
				
						method : 'POST',
						url : 'logins',
						data : login
			})
			
			.then(
						function (response){
							console.log("u "+!response.success);
							deferred.resolve(!response.success);
							/*if(!response.success){
								console.log("ff");								
								deferred.resolve(!response.success);
							}else{
								console.log("HHH");
							}*/
							
							
						}, function(errResponse) {
							console.log(errResponse);
						}
			      );
			
			
			return deferred.promise;
		}
}]);