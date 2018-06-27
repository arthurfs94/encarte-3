function success() {
    alert("Ação feita com sucesso!");
}

function error(x, e) {
    console.log(x);
    console.log(e);
    alert("Erro!");
}


/*function getCookie(name) {
	var value = "; " + document.cookie;
	var parts = value.split("; " + name + "=");
	if (parts.length == 2) return parts.pop().split(";").shift();
}*/

(function(open) {
    XMLHttpRequest.prototype.open = function(method, url, async, user, pass) {
        this.addEventListener("readystatechange", function() {
			if (this.readyState == 4) 
            { 
			}
        }, false);
        open.call(this, method, url, async, user, pass);
		this.setRequestHeader("Authorization", getCookie('Authorization'))
    };
})(XMLHttpRequest.prototype.open);


function getCookie(name) {
    function escape(s) { return s.replace(/([.*+?\^${}()|\[\]\/\\])/g, '\\$1'); };
    var match = document.cookie.match(RegExp('(?:^|;\\s*)' + escape(name) + '=([^;]*)'));
    return match ? match[1] : null;
}

function createAndSendMarket(){
	var market = "{";
	
	market += "\"name\":\"" + document.getElementById("name").value + "\",";
	market += "\"username\":\"" + document.getElementById("username").value + "\","; 
	market += "\"password\":\"" + document.getElementById("password").value + "\","; 
	market += "\"loja\":\"" + document.getElementById("loja").value + "\","; 
	market += "\"cnpj\":\"" + document.getElementById("cnpj").value + "\","; 
	market += "\"picture\":\"" + document.getElementById("picture").value + "\","; 
	market += "\"localidade\":\"" + $('input[name=localidade]:checked').val() + "\""; 
	
	market += "}"; 
	
	$.ajax({
	    type: "POST",
	    url: "/market/cadastrar" ,
	    data: market,
	    contentType: "application/json",
	    success: function(data) {
			success();
			
			document.getElementById("name").value = "";
			document.getElementById("username").value = ""; 
			document.getElementById("password").value = ""; 
			document.getElementById("loja").value = ""; 
			document.getElementById("cnpj").value = "";
			document.getElementById("picture").value = "";
			$("input:radio[name='localidade']").each(function(i) {
			       this.checked = false;
			});
			
			return; 
		}
	});
}


function logout(){

	document.cookie = "Authorization=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
	document.cookie = "id_market=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
	window.location.href = '/signinmercado';

}