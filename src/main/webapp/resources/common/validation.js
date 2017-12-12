$(document).ready(function() {
	

	 $(".disabled").css("tabindex", "-1");
	
		
	$('.char').keyup(function() {
		console.log("f");
	    this.value = this.value.replace(/[^a-zA-Z]/,'');
	});
	
	$('.charspace').keyup(function(){
		this.value = this.value.replace(/[^a-zA-Z\-\s]/,'');
	});
	
	$('.charnumeric').keyup(function(){
		this.value = this.value.replace(/[^a-zA-Z0-9]/,'');
	});
	
	$('.charnumspace').keyup(function(){
		this.value = this.value.replace(/[^a-zA-Z0-9\-\s]/,'');
	});
	
	$('.numeric').keyup(function(){
		this.value = this.value.replace(/[^0-9]/,'');
	})
	
	var parseInput = function(val) {
    var floatValue = parseFloat(val);
    return isNaN(floatValue) ? '' : floatValue;
	}
	
	$('.float').keyup(function(){
	    var value = $(this).val()+'';
	    if (value[value.length-1] !== '.') {
	        $(this).val(parseInput(value));
	    }
	}).focusout(function(){
	    $(this).val(parseInput($(this).val()+''));
	});
	
	$('.numberhyphen').keyup(function(){
		this.value = this.value.replace(/[^0-9\-]/, '');
	});


});
  