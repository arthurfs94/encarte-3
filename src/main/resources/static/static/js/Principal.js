//
//var qs = (function(a) {
//  if (a == "") return {};
//  var b = {};
//  for (var i = 0; i < a.length; ++i)
//  {
//  var p=a[i].split('=', 2);
//  if (p.length == 1)
//  b[p[0]] = "";
//  else
//  b[p[0]] = decodeURIComponent(p[1].replace(/\+/g, " "));
//  }
//  return b;
//})(window.location.search.substr(1).split('&'));

//var varGet1 = qs["codigo1"]; // 123
//var varGet2 = qs["codigo2"]; // 456

// Initialize Firebase

window.onload = function() {
	// setInterval(carregar,1000);
	carregar();
	// getLocation();
}

function carregar() {
	 //buscaUsuario();
	//buscaProduto();
	//buscaMercado();
	//buscaEncarte();
	//buscaEncarte2();
	//buscaEncarte3();
	//buscaCliente();
	//buscaProdutoPrincipal();
	//buscaProduct2();
	//pesquisaPrincipal();

}

function buscaUsuario() {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			// alert(this.responseText);
			var encarte = JSON.parse(this.responseText);
			//carregaUsuario(encarte);
			// carregaProduto(encarte);
		}
	}

	xhttp.open("GET", "/encarte/client", true);
	// xhttp.open("GET","http://localhost:8080/encarte/product",true);
	xhttp.send();
}

function carregaUsuario(client) {
	var str = "";
	for (var i = 0; i < client.length; i++) {

		if (i % 3 == 0) {
			str += "<div class='row'>";
		}
		str += "<div class='col-sm-4'>";
		str += "<dl>";
		str += "</dd>";
		str += "<img class='card-img-top' src='" + client[i].picture
				+ "' alt='Card image' style='width:60%'>";
		str += "<dl>";
		str += "</dd>";
		str += "<strong> Nome do Usuário: </strong>" + client[i].name;
		str += "<dl>";
		str += "</dd>";
		// str += "<p>"+"localidade"+" </p>";
		str += "<dl>";
		str += "</dd>";
		str += "<strong> Login Usuário: </strong>" + client[i].username;
		str += "<dl>";
		str += "</dd>";
		str += "<strong> Senha: </strong> " + client[i].password;
		str += "<dl>";
		str += "</dd>";
		str += "<strong> Mercado: </strong>" + client[i].mercado;
		str += "<dl>";
		str += "</dd>";
		str += "<strong> Id do Cliente: </strong>" + client[i].id;
		str += "<dl>";
		str += "</dl>";

		str += "</div>";

		if (i % 3 == 2) {
			str += "</div>";
		}
	}
	document.querySelector("main").innerHTML = str;
	// var main = document.getElementsByTagName("main");
	// main[0].innerHTML = motores[0].nome;

}


function buscaProduto() {

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			// alert(this.responseText);
			var encarte = JSON.parse(this.responseText);
			// carregaMercado(encarte);
			//carregaProduto(encarte);

		}
	}

	// xhttp.open("GET","http://localhost:8080/encarte/client",true);
	xhttp.open("GET", "/product", true);
	xhttp.send();
}

function carregaProduto(product) {
	var str = "";
	for (var i = 0; i < product.length; i++) {

		if (i % 3 == 0) {
			str += "<div class='row'>";
		}
		str += "<div class='col-sm-4'>";

		// str += "<div class= 'container'>";
		// str += "<table class='table'>";
		// str += "<th>";
		// str += "<thead>";
		// str += "<tr>";
		// str += "</th>";
		str += "<img class='card-img-top' src='" + product[i].picture
				+ "' alt='Card image' style='width:60%'>";
		// str += "<div class='card style'>";
		// str += "<th>";
		str += "<h2 class='text-secondary'>" + "<h4 class='card-title'>"
				+ product[i].name + "</h4>";
		// str += "</th>";
		// str += "</tr>";

		// str += "</thead>";
		// str += "<tr>";
		// str += "<thead>";
		// str += "<tbody>";
		// str += "</tr>";
		str += "<th>";

		str += "</th>";
		// str += "</thead>";
		str += "<th>";
		str += "<h2 class='text-danger'>R$ " + product[i].value;
		str += "</th>";
		str += "<th>";
		str += "<h5 class='card-text'>" + product[i].descrition;
		str += "</th>";
		str += "<th>";
		str += "<h6 class='card-text'>Categoria " + product[i].type;
		str += "</th>";
		str += "<th>";
		str += "<h6 class='card-text'>Id: " + product[i].id;
		str += "</th>";
		str += "<th>";
		str += "<h6 class='card-text'>Cod. Barra: " + product[i].serial;
		str += "</th>";
		str += "</th>";
		// str += "</table>";
		str += "</div>";

		if (i % 3 == 2) {
			str += "</div>";
		}

	}

	// var main = document.getElementsByTagName("main");
	// main[0].innerHTML = motores[0].nome;
	document.querySelector("main2").innerHTML = str;

}

function buscaMercado() {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			// alert(this.responseText);
			var encarte = JSON.parse(this.responseText);
			//carregaMercado(encarte);
			// carregaMercado(encarte);
		}
	}

	xhttp.open("GET", "http://localhost:8080/encarte/market", true);
	// xhttp.open("GET","http://localhost:8080/encarte/market",true);
	xhttp.send();
}

function carregaMercado(market) {
	var str = "";
	for (var i = 0; i < market.length; i++) {

		if (i % 3 == 0) {
			str += "<div class='row'>";
		}
		str += "<div class='col-sm-4'>";

		str += "<dl>";
		str += "</dd>";
		str += "<img class='card-img-top' src='" + market[i].picture
				+ "' alt='Card image' style='width:60%'>";
		str += "<dl>";
		str += "</dd>";
		str += "<strong> Nome do Usuário: </strong>" + market[i].name;
		str += "<dl>";
		str += "</dd>";
		// str += "<p>"+"localidade"+" </p>";
		str += "<dl>";
		str += "</dd>";
		str += "<strong> Login Mercado: </strong>" + market[i].username;
		str += "<dl>";
		str += "</dd>";
		str += "<strong> Senha: </strong> " + market[i].password;
		str += "<dl>";
		str += "</dd>";
		str += "<strong> Loja: </strong>" + market[i].loja;
		str += "<dl>";
		str += "</dd>";
		str += "<strong> CNPJ: </strong>" + market[i].cnpj;
		str += "<dl>";
		str += "</dd>";
		str += "<strong> Id do Mercado: </strong>" + market[i].id;
		str += "<dl>";
		str += "</dd>";
		str += "<strong> Id do Mercado: </strong>" + market[i].localidade;
		str += "<dl>";
		str += "</dl>";
		str += "</div>";

		if (i % 3 == 2) {
			str += "</div>";
		}
	}
	document.querySelector("main3").innerHTML = str;
	// var main = document.getElementsByTagName("main");
	// main[0].innerHTML = motores[0].nome;

}

function buscaEncarte() {

	if(getCookie("Authorization") == null) window.location.href = '/signinmercado'; 

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var encarte = JSON.parse(this.responseText);
			carregaEncarte(encarte);
		}else if (this.status == 403){
			window.location.href = '/signinmercado';
		}
	}
	
	xhttp.open("GET", "/market/" + getCookie("id_market") + "/encarte", true);
	xhttp.send();
}

function buscaEncartePrincipal() {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var encarte = JSON.parse(this.responseText);
			carregaEncartePrincipal(encarte);
		}
	}

	xhttp.open("GET", "/encarte", true);
	xhttp.send();
}



function carregaEncarte(encarte) {
	var str = "";
	for (var i = 0; i < encarte.length; i++) {

		if (i % 3 == 0) {
			str += "<div class='row'>";
		}
		str += "<div class='col-sm-4'>";
		str += "<br>";
		str += "<dl>";
		str += "<img class='card-img-top' src='" + encarte[i].picture
				+ "' alt='Card image' style='width:60%'>";
		str += "<dl>";
		str += "</dd>";
		str += "<strong>Nome do Encarte: </strong>" + encarte[i].name;
		str += "<dl>";
		str += "</dd>";
		str += "<strong>Status: </strong>" + encarte[i].status;
		str += "<dl>";
		str += "</dd>";
		str += "<strong>Descrição do Encarte: </strong>"
				+ encarte[i].description;
		str += "<dl>";
		str += "</dd>";
		str += "<strong>Data de Validade: </strong> " + encarte[i].data;
		str += "<dl>";
		str += "</dd>";
		str += "<strong>Id do Encarte: </strong> " + encarte[i].id;
		str += "<dl>";
		str += "</dd>";
		str += "<strong>Categoria: </strong> " + encarte[i].type;
		str += "<td>";

		str += "<th>";
		str += "</div>";

		if (i % 3 == 2) {
			str += "</div>";
		}

	}
	document.querySelector("main5").innerHTML = str;
}

function carregaEncartePrincipal(encarte) {
console.log("daddsd");
	var str = "";
	for (var i = 0; i < encarte.length; i++) {

		if (i % 3 == 0) {
			str += "<div class='row'>";
		}
		str += "<div class='col-sm-4'>";
		str += "<br>";
		str += "<dl>";
		str += "<img class='card-img-top' src='" + encarte[i].picture
				+ "' alt='Card image' style='width:60%'>";
		str += "<dl>";
		str += "</dd>";
		str += "<strong>Nome do Encarte: </strong>" + encarte[i].name;
		str += "<dl>";
		str += "</dd>";
		str += "<strong>Status: </strong>" + encarte[i].status;
		str += "<dl>";
		str += "</dd>";
		str += "<strong>Descrição do Encarte: </strong>"
				+ encarte[i].description;
		str += "<dl>";
		str += "</dd>";
		str += "<strong>Data de Validade: </strong> " + encarte[i].data;
		str += "<dl>";
		str += "</dd>";
		str += "<strong>Id do Encarte: </strong> " + encarte[i].id;
		str += "<dl>";
		str += "</dd>";
		str += "<strong>Categoria: </strong> " + encarte[i].type;
		str += "<td>";

		str += "<th>";
		str += "</div>";

		if (i % 3 == 2) {
			str += "</div>";
		}

	}
	document.querySelector("main5").innerHTML = str;
}

function buscaEncarte2() {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			// alert(this.responseText);
			var encarte = JSON.parse(this.responseText);
			carregaEncarte2(encarte);
			// carregaProduto(encarte);
		}
	}

	xhttp.open("GET", "http://localhost:8080/encarte/encarte", true);
	// xhttp.open("GET","http://localhost:8080/encarte/product",true);
	xhttp.send();
}

function carregaEncarte2(encarte) {
	var str = "";
	var inicio = true;
	for (var i = 0; i < encarte.length; i++) {

		if (inicio) {
			str += "<div class=\"item active\">";
			inicio = false
		} else {
			str += "<div class=\"item\">";
		}

		str += "<img src='" + encarte[i].picture + "' alt='" + encarte[i].name
				+ "'>";
		str += "<h1>" + encarte[i].name + "</h1>";
		str += "<h3>" + encarte[i].description + "</h3>";
		str += "<h4>Valido até: " + encarte[i].data + "</h4>";
		str += "</div>";

	}
	document.querySelector("#principal-encarte").innerHTML = str;
	// var main = document.getElementsByTagName("main");
	// main[0].innerHTML = motores[0].nome;

}

function buscaCliente() {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			// alert(this.responseText);
			var encarte = JSON.parse(this.responseText);
			carregaCliente(encarte);
			// carregaProduto(encarte);
		}
	}
}

function carregaCliente(client) {
	var str = "";
	for (var i = 0; i < client.length; i++) {
		str += "<strong> Nome do Usuário: </strong>" + client[i].name;
	}
	document.querySelector("main6").innerHTML = str;
	// var main = document.getElementsByTagName("main");
	// main[0].innerHTML = motores[0].nome;

}

function buscaProdutoPrincipal() {

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			// alert(this.responseText);
			var encarte = JSON.parse(this.responseText);
			// carregaMercado(encarte);
			carregaProdutoPrincipal(encarte);

		}
	}

	// xhttp.open("GET","http://localhost:8080/encarte/client",true);
	xhttp.open("GET", "http://localhost:8080/encarte/product", true);
	xhttp.send();
}

function carregaProdutoPrincipal(product) {
	var str = "";
	for (var i = 0; i < product.length; i++) {

		if (i % 3 == 0) {
			str += "<div class='row'>";
		}
		str += "<div class='col-sm-4'>";
		str += "<dl>";
		str += "</dd>";
		str += "<img class='card-img-top' src='" + product[i].picture
				+ "' alt='Card image' style='width:60%'>";
		// str += "<img src='"+product[i].picture+ "'>";
		str += "<dl>";
		str += "</dd>";
		str += "<strong> Nome do produto: </strong>" + product[i].name;
		str += "<dl>";
		str += "</dd>";
		// str += "<strong>Setor: </strong>"+product[i].type;
		str += "<dl>";
		str += "</dd>";
		str += "<strong> valor do produto: </strong>" + product[i].value;
		str += "<dl>";
		str += "</dd>";
		str += "<strong> Descrição:  </strong> " + product[i].descrition;
		str += "<dl>";
		str += "</dd>";
		// str += "<strong> Id do Produto: </strong>"+product[i].id;
		str += "<dl>";
		str += "</dl>";
		str += "</div>";

		if (i % 3 == 2) {
			str += "</div>";
		}

		// str += "<div class=''>";
		// str += "<div class='row'>";
		// str += "<div class='col-sm-6'>";
		// str += "<div class='if(ct % 3 == 0)'>";
		//                
		// str += "<div class='if(ct % 3 == 2)'>";
		//                
		// str += "</div>";

	}

	// var main = document.getElementsByTagName("main");
	// main[0].innerHTML = motores[0].nome;
	document.querySelector("main7").innerHTML = str;

}
function buscaEncarte3() {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			// alert(this.responseText);
			var encarte = JSON.parse(this.responseText);
			carregaEncarte3(encarte);
			// carregaProduto(encarte);
		}
	}

	xhttp.open("GET", "http://localhost:8080/encarte/encarte", true);
	// xhttp.open("GET","http://localhost:8080/encarte/product",true);
	xhttp.send();
}

function carregaEncarte3(encarte) {
	var str = "";
	for (var i = 0; i < encarte.length; i++) {

		if (i % 3 == 0) {
			str += "<div class='row'>";
		}
		str += "<div class='col-sm-4'>";
		str += "<dl>";
		str += "<dd>";
		str += "<img class='card-img-top' src='" + encarte[i].picture
				+ "' alt='Card image' style='width:50%'>";
		str += "<dl>";
		str += "</dd>";
		str += "<strong>Nome do Encarte: </strong>" + encarte[i].name;
		str += "<dl>";
		str += "</dd>";
		str += "<strong>Status: </strong>" + encarte[i].status;
		str += "<dl>";
		str += "</dd>";
		str += "<strong>Descrição do Encarte: </strong>"
				+ encarte[i].description;
		str += "<dl>";
		str += "</dd>";
		str += "<strong>Data de Validade: </strong> " + encarte[i].data;
		str += "<dl>";
		str += "</dd>";
		str += "<strong>Id do Encarte: </strong> " + encarte[i].id;
		str += "<dl>";
		str += "</dd>";
		str += "<strong>Categoria: </strong> " + encarte[i].type;

		str += "<dl>";
		str += "</dl>";
		str += "</div>";
		if (i % 3 == 2) {
			str += "</div>";
		}

	}
	document.querySelector("main5").innerHTML = str;
	// var main = document.getElementsByTagName("main");
	// main[0].innerHTML = motores[0].nome;

}

function buscaProduct2() {

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			// alert(this.responseText);
			var encarte = JSON.parse(this.responseText);
			// carregaMercado(encarte);
			carregaProduto2(encarte);

		}
	}

	// xhttp.open("GET","http://localhost:8080/encarte/client",true);
	xhttp.open("GET", "http://localhost:8080/encarte/product", true);
	xhttp.send();
}

function carregaProduto2(product) {
	var str = "";
	for (var i = 0; i < product.length; i++) {

		if (i % 3 == 0) {
			str += "<div class='row'>";
		}
		str += "<div class='col-sm-4'>";

		str += "<dl>";
		str += "</dd>";
		str += "<img class='card-img-top' src='" + product[i].picture
				+ "' alt='Card image' style='width:30%'>";
		// str += "<img src='"+product[i].picture+ "'>";
		str += "<dl>";
		str += "</dd>";
		str += "<strong> Nome do produto: </strong>" + product[i].name;
		str += "<dl>";
		str += "</dd>";
		str += "<strong>Setor: </strong>" + product[i].type;
		str += "<dl>";
		str += "</dd>";
		str += "<strong> valor do produto: </strong>" + product[i].value;
		str += "<dl>";
		str += "</dd>";
		str += "<strong> Descrição:  </strong> " + product[i].descrition;
		str += "<dl>";
		str += "</dd>";
		str += "<strong> Id do Produto: </strong>" + product[i].id;
		str += "<dl>";
		str += "</dd>";
		str += "<strong> Codigo de barra: </strong>" + product[i].serial;
		str += "<dl>";
		str += "</dl>";

		str += "</div>";

		if (i % 3 == 2) {
			str += "</div>";
		}
	}

	// var main = document.getElementsByTagName("main");
	// main[0].innerHTML = motores[0].nome;
	//document.querySelector("product").innerHTML = str;

}
/*function pesquisaPrincipal() {
	
	var pesquisaNome = document.getElementById("pesquisaNome").value;
	
	if (document.getElementById("pesquisaCategoria") != null) {
		var pesquisaCategoria = document.getElementById("pesquisaCategoria").value;
	}
	
	if (document.getElementById("pesquisaLocalidade") != null) {
		var pesquisaLocalidade = document.getElementById("pesquisaLocalidade").value;
	}
	
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
	
			var encarte = JSON.parse(this.responseText);
			carregaPesquisaPrincipal(encarte);

		}
	}
			xhttp.open("GET","http://localhost:8080/produtos/pesquisaFiltro?paramPesquisa="+ pesquisaNome + "&filtro=" + pesquisaCategoria+ "&localidade=" + pesquisaLocalidade, true);
			xhttp.send();*/

function carregaPesquisaPrincipal(pesquisaFiltro) {
	var str = "";
	for (var i = 0; i < pesquisaFiltro.length; i++) {

		if (i % 3 == 0) {
			str += "<div class='row'>";
		}
		str += "<div class='col-sm-4'>";

		str += "<dl>";
		str += "</dd>";
		// str += "<img class='card-img-top'
		// src='"+paramPesquisa[i].pesquisaNome+ "' alt='Card image'
		// style='width:30%'>";
		// str += "<img src='"+product[i].picture+ "'>";
		str += "<dl>";
		str += "</dd>";
		str += "<strong> Nome do produto: </strong>"
				+ pesquisaFiltro[i].pesquisaCategoria;
		str += "<dl>";
		str += "</dd>";
		str += "<strong>Setor: </strong>"
				+ pesquisaFiltro[i].pesquisaLocalidade;
		str += "<dl>";
		str += "</dd>";
		str += "<strong> valor do produto: </strong>"
				+ pesquisaFiltro[i].pesquisaNome;
		str += "<dl>";
		str += "</dd>";
		// str += "<strong> Descrição: </strong> "+product[i].descrition;
		// str += "<dl>";
		// str += "</dd>";
		// str += "<strong> Id do Produto: </strong>"+product[i].id;
		// str += "<dl>";
		// str += "</dd>";
		// str += "<strong> Codigo de barra: </strong>"+product[i].serial;
		str += "<dl>";
		str += "</dl>";

		str += "</div>";

		if (i % 3 == 2) {
			str += "</div>";
		}
	}

	// var main = document.getElementsByTagName("main");
	// main[0].innerHTML = motores[0].nome;
	document.querySelector("pesquisaPrincipal").innerHTML = str;

}

function redirect(link){
	    	
	$.ajax({
	    //url: "/market/" + getCookie("id_market") + link ,
	    url: link,
	    type: 'GET',
	    contentType: 'application/json',
	    success: function(data){
	    	
	    	document.open();
	        document.write(data);
	        document.close();
	    
	    }
	});
	
}

function buscarMercado(link){
	    	
	$.ajax({
	    url: "/market/" + getCookie("id_market") + link ,
	    type: 'GET',
	    contentType: 'application/json',
	    success: function(data){
	    	
	    	document.open();
	        document.write(data);
	        document.close();
	    
	    }
	});
}

function buscarItemMercado(nome, tipo){
	    	
	$.ajax({
	    url: "/market/" + getCookie("id_market") + "/" + tipo + "/" + nome ,
	    type: 'GET',
	    contentType: 'application/json',
	    success: function(data){
			carregarBuscaItem(data, tipo);    	
	    
	    }
	});
}

function buscarEncartesEdit(nome){
	    	
	$.ajax({
	    url: "/market/" + getCookie("id_market") + "/encarte/" + nome ,
	    type: 'GET',
	    contentType: 'application/json',
	    success: function(data){
			carregarBuscaEncarteEdit(data);    	
	    
	    }
	});
}



