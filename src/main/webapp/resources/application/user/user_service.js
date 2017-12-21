zoneApp.factory('UserService',['$http','$q', function($http,$q){
			
		var factory = {
				
				createUser : createUser,
				fetchAllUser : fetchAllUser,
				fetchAllUserRoles : fetchAllUserRoles
		};
		
		return factory;
		
		function fetchAllUserRoles() {
			var deferred = $q.defer();
			$http.get('role/')
			 .then(
					 function(response) {
						 deferred.resolve(response.data);
						 console.log('hhh');
					 },
					 function(errResponse) {
						 console.log('sss');
					 }
				  );
			return deferred.promise;
			 
		}
		
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
		
		//====== Get Register Process ======//
		
		function fetchAllUser(){
			var deferred = $q.defer();
			$http.get('userreg/')
				.then(
						function(response){
							deferred.resolve(response.data);
							console.log(response.data);
						}, function(errResponse) {
							console.log("s error");
						}
				     );
			return deferred.promise;
		}
	
}]);