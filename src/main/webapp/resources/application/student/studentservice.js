
zoneApp.factory('StudentService',['$http','$q', function($http,$q){
	
		var factory = {
					createStudent : createStudent
		};
		
		return factory;
		
		function createStudent(page) {
			var deferred = $q.defer();
			
			$http({
				
					method : 'POST',
					url : 'student_creation',
					data : page
			})
			.then(
					function(response) {
						deferred.resolve(response.data);
						console.log("s right");
					}, function (errResponse) {
						deferred.reject(errResponse);
						console.log("s wrong");
					}
				  );
			return deferred.promise;
		}
	
}]);