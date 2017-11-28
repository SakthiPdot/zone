
zoneApp.controller('UserController',['$scope','UserService','ConfirmDialogService', function($scope,UserService,ConfirmDialogService) {
	
		
		var self = this;
		
		self.user ={};
		self.submit = submit;
		self.save = "saveclose";
		
		
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
									console.log(self.user);
									createUser(self.user);	
								}								
							);
			} else {
				console.log("else");
			}
		}
	
}]);