

zoneApp.controller('SignupController',['$scope','SignupService','ConfirmDialogService',function($scope,SignupService,ConfirmDialogService){
		
		$scope.nameWrong = false;
	
			
			
		var self = this;
		self.signupall = [];
	
		self.signup = {};
		self.submit = submit;
		self.save = "saveclose";
		self.updateSignup = updateSignup;
		self.deleteSignup = deleteSignup;
		
		
		fetchAllSignup();
		fetchAllRoles();
		
		function fetchAllRoles() {
			SignupService.fetchAllRoles()
				.then(
						function(roles) {
							self.roles = roles;
							console.log('ri');
						}, function(errResponse) {
							console.log("error");
						}
				      );
		}
		
		$scope.save = function(event) {
			console.log("save button");
			self.save = event.target.id;			
		}
		
		function createSignup(signup) {
			SignupService.createSignup(signup)
				.then(
							function (response) {
																
								
								console.log(response);								
								window.location.replace("dashboard");
							},
							function(errResponse) {
								console.log("failure");
								alert("signup error");
							}
				      );
		}
		
		function submit() {
			if(self.signup.client_id == null ) {
				//self.signup.role.role_id = self.signup.role_id;
				/*delete self.signup.role_id;*/
				//console.log(self.signup.role.role_id)
				console.log(self.signup);
				createSignup(self.signup);
				
				/*self.confirm_title = 'Save';
				self.confirm_type = BootstrapDialog.TYPE_SUCCESS;
				self.confirm_msg = self.confirm_title + ' ' + self.signup.username + 'created?';
				self.confirm_btnclass = 'btn-success';				
				ConfirmDialogService.confirmBox(self.confirm_title,self.confirm_type,self.confirm_msg,self.confirm_btnclass)
						
				.then(
									function (res) {
										console.log("Save");
										console.log(self.signup);
										createSignup(self.signup);
										
									}
						     );*/
			} else {
				
				self.confirm_title = 'Update';
				self.confirm_type = BootstrapDialog.TYPE_SUCCESS;
				self.confirm_msg = self.confirm_title + ' ' + self.signup.username ;
				self.confirm_btnclass = 'btn-success';
				ConfirmDialogService.confirmBox(self.confirm_title,self.confirm_type,self.confirm_msg,self.confirm_btnclass)
					.then(
							function(response){
								self.signup.role.role_id = self.signup.role_id;
								delete self.signup.role_id;
								editSignup(self.signup);
								console.log("submit success======>"+self.signup);
							}, function(errResponse){
								console.log("submit error");
							}
						 );
			}
		}
		
		function fetchAllSignup() {
			SignupService.fetchAllSignup()
				.then(
							function (signup) {
								self.signupall = signup;
								
								console.log(signup);
							}, function (errResponse) {
								console.log('Err');
							}
					  );
		}
		
		//=====Username Check ========//
		
		self.checkUsername = function checkUsername(username) {
			                   
					
						SignupService.checkUsername(username)
							.then(function (response){
								if(response == "204") {
									$scope.nameWrong = true;
									self.signup.username = null;
									console.log("right");
								} else {
									$scope.nameWrong = false;
								}								
							}, function (errResponse){
								$scope.nameWrong = false;
								self.signup.username = null;
								console.log("error");
							});					
			
		}
		
		//=====Update Signup Begin =======//
		function updateSignup(signup) {			
			self.signup = signup;			
		}
		
		function editSignup(signup) {
			SignupService.updateSignup(signup)
				.then(
						function(){
							fetchAllSignup();
							console.log("s c");
						}, function(errResponse) {
							console.log("s error");
						}						
				     );
		}
		
		function deleteSignup(){
			console.log("g");
			self.confirm_title = 'Delete';
			self.confirm_type = BootstrapDialog.TYPE_DANGER;
			self.confirm_msg = self.confirm_title+ ' ' + self.signup.username ;
			self.confirm_btnclass = 'btn-danger';
			ConfirmDialogService.confirmBox(self.confirm_title,self.confirm_type, self.confirm_msg, self.confirm_btnclass)
				.then(
						function (res){
							SignupService.deleteSignup(self.signup.client_id)
								.then(
										function(msg){
											console.log("msg deleted");
										}, function(errResponse){
											console.log("msg not deleted");
										}
								     );
						}
				      );
			
		}

}]);