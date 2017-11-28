zoneApp.factory('SignupService',['$http','$q', function ($http,$q){
	
			
			var factory = {
					
					createSignup : createSignup,
					updateSignup : updateSignup,
					deleteSignup :  deleteSignup,
					fetchAllSignup : fetchAllSignup,
					checkUsername : checkUsername
			};
			
			return factory;
			
			function createSignup(signup) {
				var deferred = $q.defer();
				/*var headers = getCsrfHeader();*/
				
				$http({
							
						method : 'POST',						
						url : 'signup_creation',
						data :signup
						/*headers : headers*/			
			        
				})
				
				.then (
						
							function (response) {
								deferred.resolve(response.data);
								console.log("service right");
							}, function (errResponse) {
								deferred.reject(errResponse);
								console.log("service wrong");
							}
				       );
				return deferred.promise;
			}
			
			function fetchAllSignup() {
				var deferred = $q.defer();
				$http.get('signupreg/')
					.then(
							function (response) {
								deferred.resolve(response.data);
								console.log(response);
							}, function (errResponse) {
								console.log('EEE');
								deferred.resolve(errResponse);
							}
						  );
				return deferred.promise;
			}
			
			function checkUsername(username) {
				var deferred = $q.defer();
				
				$http({
						method : 'POST',
						url    : 'checkUsername',
						data   : username
				})
				
						.then(
								function (response) {
									console.log(response.status+"response");
									deferred.resolve(response.status);
								}, function (errResponse) {
									deferred.reject(errResponse);
								}
							 );
					return deferred.promise;
			}
			
			
			/*function updateSignup (id) {
				var deferred = $q.defer();
				
				$http({
						method : 'PUT',
						url : 'update_signup/'+id
				})
				.then(
						function (response) {
							deferred.resolve(response.data);
							console.log("s r "+response.data);
						}, function (errResponse) {
							deferred.reject(errResponse);
						}
				      );
				return deferred.promise;
			}*/
			
			function updateSignup(signup) {
				var deferred = $q.defer();
				
				$http({
					
					method : 'POST',
					url : 'update_signup',
					data : signup
				})	
				
				.then(
						function(response){
							console.log("1");
							deferred.resolve(response.data);
						}, function(errResponse){
							deferred.reject(errResponse);
							console.log("2");
						}
						);
				return deferred.promise;
			}
			
			
			function deleteSignup(id) {
				var deferred = $q.defer();
				
				$http({
							method : 'DELETE',
							url : 'delete_signup/'+id
							
				})
				
					.then(
							function(response){
								console.log("3");
								deferred.resolve(response.data);
							}, function(errResponse){
								console.log("4");
								deferred.reject(errResponse);
							}
					);
				return deferred.promise;
			}
			
}]);