var password = document.getElementById("exampleInputPassword1");
var passwordConf = document.getElementById("exampleInputPassword2");

function validatePassword() { 
	if (password.value == passwordConf.value) {
		
	} else {
		alert("Mots de passe différents");
	}
}


passwordConf.onfocusout = validatePassword;