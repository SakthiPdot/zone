zoneApp.factory('LoginService',['$http','$q', function ($http,$q){
		
		var factory = {
				getLogin : getLogin	
		};
		
		return factory;
		
		function getLogin(login){
			
			var deferred = $q.defer();
			
			$http({
				
						method : 'POST',
						url : 'login',
						data : login
			})
			
			.then(
						function (response){
							console.log("users",response.data);
							console.log("users",response.data.username);
							deferred.resolve(response.data.result);
														
						}, function(errResponse) {
							console.log(errResponse.data);
						}
			      );		
			
			return deferred.promise;
		}
}]);