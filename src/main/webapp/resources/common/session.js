console.log("session");
function getCsrfHeader() {
	var csrfToken = $("input[name='_csrf']").val();
	
	var headers = {};
	headers["X-CSRF-TOKEN"] = csrfToken;
	headers["_csrf"] = csrfToken;
	return headers;
}