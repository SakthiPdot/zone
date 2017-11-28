zoneApp.factory('UserService',['$http','$q', function($http,$q){
			
		var factory = {
				
				createUser : createUser
		};
		
		return factory;
		
		function createUser(user) {
			var deferred = $q.defer();
			
			$http({
				method : 'POST',
				url : 'create_user',
				data : user
			})
			
			.then(
					function(response) {
						deferred.resolve(response.data);
						console.log("right"+response.data);
					}, function (errResponse) {
						deferred.reject(errResponse);
						console.log("rr"+errResponse);
					}
			     );
			return deferred.promise;
		}
	
}]);