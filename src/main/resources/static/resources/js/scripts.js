var password = document.getElementById(exampleInputPassword1);
var passwordConf = document.getElementById(exampleInputPassword2);

function validatePassword() { 
	if (password.value != passwordConf.value) {
		passwordConf.setCustomValidity("Pas de correspondance");
	} else {
		passwordConf.setCustomValidity('');
	}
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;