
zoneApp.controller('UserController',['$scope','UserService','ConfirmDialogService', function($scope,UserService,ConfirmDialogService) {
	
		
		$scope.nameWrong = false;
		
		var self = this;
		self.userall = [];
		self.user ={};
		self.submit = submit;
		self.save = "saveclose";
		/*self.user.role = {};*/
		
		fetchAllUser();
		fetchAllUserRoles();
		
		$scope.orderTable = function(user) {
			console.log('k');
			console.log(user);
			$scope.Table = user;
		}
		
		function fetchAllUserRoles() {
			UserService.fetchAllUserRoles()
			 .then(
					 	function(roles) {
					 		self.roles = roles;
					 		console.log('g');
					 	}, function(errResponse) {
					 		console.log('Err');
					 	}
				   );
		}
		
		$scope.save = function(event) {
			console.log("save button");
			self.save = event.target.id;
		}
		
		function createUser(user) {
			UserService.createUser(user)
				.then(
						function() {
							console.log("success");
						},
						function(errResponse) {
							console.log("failure");
						}
				      );
		}
		
		function submit() {
			if(self.user.user_id == null) {
				self.confirm_title = 'Save';
				self.confirm_type = BootstrapDialog.TYPE_SUCCESS;
				self.confirm_msg = self.confirm_title + ' ' + self.user.user + 'created?';
				self.confirm_btnclass = 'btn-success';
				
				ConfirmDialogService.confirmBox(self.confirm_title,self.confirm_type,self.confirm_msg,self.confirm_btnclass)
						.then(
								function(res) {
									console.log("if");
									/*self.user.role.role_id = self.user.role_id;
									delete self.user.role_id;
									console.log(self.user.role.role_id);*/
									console.log(self.user);
									createUser(self.user);	
								}								
							);
			} else {
				console.log("else");
			}
		}
		
		//==== Get Register Process ======//
		function fetchAllUser(){
			UserService.fetchAllUser()
				.then(
						function(user) {
							self.userall = user;
							console.log(user);
						},
						function(errResponse) {
							console.log("Err")
						}
				      );
		}
		
		//======== Check Username =========//
		
		self.checkUsername = function checkUsername(username) {
			UserService.checkUsername(username)
				.then(
						function(response) {
							if(response == "204") {
								$scope.nameWrong = true;
								self.user.username = null;
								console.log('right');
							} else {
								$scope.nameWrong = false;
							}
				         }, function(errResponse) {
				        	 $scope.nameWrong = false;
				        	 self.user.username = null;
				        	 console.log('err');
				         }
					);
		}
	
}]);