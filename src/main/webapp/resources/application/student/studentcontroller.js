
zoneApp.controller('StudentController',['$scope','StudentService','ConfirmDialogService', function ($scope,StudentService,ConfirmDialogService){
	
	var self = this;
	
	self.page={};
	self.submit = submit;
	self.save = "saveclose";
	
	$scope.save = function(event) {
		console.log("save button");
		self.save = event.target.id;
	}
	
	function createStudent(page) {
		StudentService.createStudent(page)
			.then(
					function() {
						console.log("success");
					}, function(errResponse) {
						console.log("failure");
					}
			     );
	}
	
	function submit() {
		if(self.page.stu_id == null ) {
			self.confirm_title = 'Save';
			self.confirm_type = BootstrapDialog.TYPE_SUCCESS;
			self.confirm_msg = self.confirm_title + ' ' + self.page.name + 'created?';
			self.confirm_btnclass = 'btn-success';
			
			ConfirmDialogService.confirmBox(self.confirm_title,self.confirm_type,self.confirm_msg,self.confirm_btnclass)
					.then(
								function (res) {
									console.log(self.page);
									createStudent(self.page);
									
								}
					     );
		} else {
			console.log("sakthi");
		}
	
	}
	
}]);