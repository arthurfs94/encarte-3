function converteFormEmJSON(form) {
    var array = jQuery("#" + form).serializeArray();
    var json = {};
    jQuery.each(array, function () {
        if (this.value != "") {
            json[this.name] = this.value;
        } else {
            alert("Todos os campos são obrigatórios!");
            json = null;
            return false;
        }
    });
    json = JSON.stringify(json);

    return json;
}

function success() {
    alert("Ação feita com sucesso!");
}

function error(x, e) {
    console.log(x);
    console.log(e);
    alert("Erro!");
}

function create(param, form) {

    json = converteFormEmJSON(form);
    console.log(json);
    /*if (json != "null") {
        $.ajax({
            type: "POST",
            url: param,
            data: json,
            contentType: "application/json",
            success: function(data) {
	      		alert("einta"); 
	    	},
	    	err: function(data) {
	      		alert("ein?"); 
	    	}
        });
    }*/
}

function read(param, id, form) {
    $.ajax({
        type: "GET",
        url: "/encarte/" + param + "/" + jQuery("#" + id).val(),
        data: null,
        contentType: "application/json"
    }).done(function (data) {
        jQuery.each(data, function (k, v) {
            if (k != "type")
                $("input[name=" + k + "]").val(v);
            else
            	$("input[value=" + v + "]").prop("checked",true);
        });
    });
}


function pesquisaTodosProdutos() {

	document.querySelector("#tipo-busca").value = "product";
	$.ajax({
        type: "GET",
        url: window.location.href + "/productname/",
        contentType: "application/json",
        success: function(data) {
      		carregarTelaInicial(data);
      		return; 
    	}
        
    });
}


function pesquisaPrincipal() {
	var param = document.querySelector("#pesquisaNome").value;
	var tipoBusca = document.querySelector("#tipo-busca").value;
		
	$.ajax({
        type: "GET",
        url: window.location.href + "/" + tipoBusca + "name/" + param,
        contentType: "application/json",
        success: function(data) {
      		carregarTelaInicial(data);
      		return; 
    	}
        
    });
}

function pesquisaPrincipalGeral() {
	var param = document.querySelector("#pesquisaNome").value;
	var tipoBusca = document.querySelector("#tipo-busca").value;
	$.ajax({
        type: "GET",
        url: window.location.href + "/" + tipoBusca + "name/" + param,
        contentType: "application/json",
        success: function(data) {
      		carregarTelaPrincipal(data);
      		return; 
    	}
    });
}

function pesquisaPrincipalGeralEncarte(idEncarte) {
	$.ajax({
        type: "GET",
        url: window.location.href + "/encarte/" + idEncarte,
        contentType: "application/json",
        success: function(data) {
        	document.querySelector("#tipo-busca").value = "product";
      		carregarTelaPrincipal(data);
      		return; 
    	}
        
    });
}

function updatePrincipal(param, form) {
    json = converteFormEmJSON(form);
    if (json != "null") {
        $.ajax({
            type: "PUT",
            url: "/Principal/" + param,
            data: json,
            contentType: "application/json"
        });
    success();
    }
}




function update(param, form) {
    json = converteFormEmJSON(form);
    if (json != "null") {
        $.ajax({
            type: "PUT",
            url: "/encarte/" + param,
            data: json,
            contentType: "application/json"
        });
    success();
    }
}

function delete_(param, id, form) {
    json = converteFormEmJSON(form);
    if(json != "null") {
        $.ajax({
            type: "DELETE",
            url: "/encarte/" + param + "/" + jQuery("#" + id).val(),
            data: null,
            contentType: "application/json"
        });
        success();
    }
}


function carregarTelaInicial(obj) {
    
	var tipoBusca = document.querySelector("#tipo-busca").value;
	
	var str = "";
	for (var i = 0; i < obj.length; i++) {

		if (i % 3 == 0) {
			str += "<div class='row'>";
		}
		
		str += "<div class='col-sm-4' ";
		
		if(tipoBusca == 'encarte'){
			str += "onclick='window.location=\"" + window.location + "/encarte/" + obj[i].id  +  "\"'";
		}
		
		str += ">";

		str += "<dl>";
		str += "</dd>";
		
		str += "<img class='card-img-top' src='" + obj[i].picture
				+ "' alt='Card image' style='width:60%'>";

		str += "<dl>";
		str += "</dd>";
		
		if(tipoBusca == 'product'){
			document.querySelector("titulo").innerHTML = "<h1>Produtos Filtrados!</h1>";
			
			str += "<strong> Nome do produto: </strong>"
					+ obj[i].name;

			str += "<dl>";
			str += "</dd>";
		
			str += "<dl>";
			str += "</dd>";
			
			str += "<strong> valor do produto: </strong>"
					+ obj[i].value;
			
			
		}else if(tipoBusca == 'market'){
			str += "<strong> Nome do Mercado: </strong>"
					+ obj[i].name;
		
			str += "<dl>";
			str += "</dd>";
		
			str += "<dl>";
			str += "</dd>";
			
			str += "<strong> Localidade: </strong>"
					+ obj[i].localidade;
			
		}else if(tipoBusca == 'encarte'){
			document.querySelector("titulo").innerHTML = "<h1>Encartes Filtrados!</h1>";
			
			str += "<strong>Nome do Encarte: </strong>" + obj[i].name;
			str += "<dl>";
			str += "</dd>";
			str += "<strong>Status: </strong>" + obj[i].status;
			str += "<dl>";
			str += "</dd>";
			str += "<strong>Descrição do Encarte: </strong>"
					+ obj[i].description;
			str += "<dl>";
			str += "</dd>";
			str += "<strong>Data de Validade: </strong> " + obj[i].data;
			str += "<dl>";
			str += "</dd>";
			str += "<strong>Id do Encarte: </strong> " + obj[i].id;
			str += "<dl>";
			str += "</dd>";
			str += "<strong>Categoria: </strong> " + obj[i].type;
		}
		
		str += "<dl>";
		str += "</dd>";

		str += "<dl>";
		str += "</dl>";

		str += "</div>";

		if (i % 3 == 2) {
			str += "</div>";
		}
	}

	document.querySelector("main5").innerHTML = str;

}


function carregarTelaPrincipal(obj) {
    
	var tipoBusca = document.querySelector("#tipo-busca").value;
	
	var str = "";
	for (var i = 0; i < obj.length; i++) {

		if (i % 3 == 0) {
			str += "<div class='row'>";
		}
		
		str += "<div class='col-sm-4' ";
		
		if(tipoBusca == 'encarte'){
			str += 'onclick="pesquisaPrincipalGeralEncarte(' + obj[i].id + ')"';
		}else if(tipoBusca == 'market'){
			str += 'onclick="window.location=\'/paginamercado/' + obj[i].id + "'\"";
		}
		
		str += ">";

		str += "<dl>";
		str += "</dd>";
		
		str += "<img class='card-img-top' src='" + obj[i].picture
				+ "' alt='Card image' style='width:60%'>";

		str += "<dl>";
		str += "</dd>";
		
		if(tipoBusca == 'product'){
			str += "<strong> Nome do produto: </strong>"
					+ obj[i].name;

			str += "<dl>";
			str += "</dd>";
		
			str += "<dl>";
			str += "</dd>";
			
			str += "<strong> valor do produto: </strong>"
					+ obj[i].value;
			
			
		}else if(tipoBusca == 'market'){
			str += "<strong> Nome do Mercado: </strong>"
					+ obj[i].name;
		
			str += "<dl>";
			str += "</dd>";
		
			str += "<dl>";
			str += "</dd>";
			
			str += "<strong> Localidade: </strong>"
					+ obj[i].localidade;
			
		}else if(tipoBusca == 'encarte'){
			str += "<strong>Nome do Encarte: </strong>" + obj[i].name;
			str += "<dl>";
			str += "</dd>";
			str += "<strong>Nome do Estabelecimento: </strong>" + obj[i].marketName;
			str += "<dl>";
			str += "</dd>";
			str += "<strong>Status: </strong>" + obj[i].status;
			str += "<dl>";
			str += "</dd>";
			str += "<strong>Descrição do Encarte: </strong>"
					+ obj[i].description;
			str += "<dl>";
			str += "</dd>";
			str += "<strong>Data de Validade: </strong> " + obj[i].data;
			str += "<dl>";
			str += "</dd>";
			str += "<strong>Id do Encarte: </strong> " + obj[i].id;
			str += "<dl>";
			str += "</dd>";
			str += "<strong>Categoria: </strong> " + obj[i].type;
		}
		
		str += "<dl>";
		str += "</dd>";

		str += "<dl>";
		str += "</dl>";

		str += "</div>";

		if (i % 3 == 2) {
			str += "</div>";
		}
	}

	document.querySelector("main5").innerHTML = str;

}

function getCookie(name) {
	var value = "; " + document.cookie;
	var parts = value.split("; " + name + "=");
	if (parts.length == 2) return parts.pop().split(";").shift();
}

function carregarBuscaItem(obj, tipo) {
    
	var tipoBusca = tipo;
	
	var str = "";
	for (var i = 0; i < obj.length; i++) {

		if (i % 3 == 0) {
			str += "<div class='row'>";
		}
		str += "<div class='col-sm-4'>";

		str += "<dl>";
		str += "</dd>";
		
		str += "<img class='card-img-top' src='" + obj[i].picture
				+ "' alt='Card image' style='width:60%'>";

		str += "<dl>";
		str += "</dd>";
		
		if(tipoBusca == 'product'){
			str += "<strong> Nome do produto: </strong>"
					+ obj[i].name;

			str += "<dl>";
			str += "</dd>";
		
			str += "<dl>";
			str += "</dd>";
			
			str += "<strong> valor do produto: </strong>"
					+ obj[i].value;
			
			
		}else if(tipoBusca == 'market'){
			str += "<strong> Nome do Mercado: </strong>"
					+ obj[i].name;
		
			str += "<dl>";
			str += "</dd>";
		
			str += "<dl>";
			str += "</dd>";
			
			str += "<strong> Localidade: </strong>"
					+ obj[i].localidade;
			
		}else if(tipoBusca == 'encarte'){
			str += "<strong>Nome do Encarte: </strong>" + obj[i].name;
			str += "<dl>";
			str += "</dd>";
			str += "<strong>Status: </strong>" + obj[i].status;
			str += "<dl>";
			str += "</dd>";
			str += "<strong>Descrição do Encarte: </strong>"
					+ obj[i].description;
			str += "<dl>";
			str += "</dd>";
			str += "<strong>Data de Validade: </strong> " + obj[i].data;
			str += "<dl>";
			str += "</dd>";
			str += "<strong>Id do Encarte: </strong> " + obj[i].id;
			str += "<dl>";
			str += "</dd>";
			str += "<strong>Categoria: </strong> " + obj[i].type;
		}
		
		str += "<dl>";
		str += "</dd>";

		str += "<dl>";
		str += "</dl>";

		str += "</div>";

		if (i % 3 == 2) {
			str += "</div>";
		}
	}

	document.querySelector("main5").innerHTML = str;

}

function createAndSendProduct(){
	var product = "";
	product += "{\"name\":\"" + document.getElementById("name").value + "\",";
	product += "\"descrition\":\"" + document.getElementById("descrition").value + "\","; 
	product += "\"value\":\"" + document.getElementById("value").value + "\","; 
	product += "\"picture\":\"" + document.getElementById("picture").value + "\","; 
	product += "\"serial\":\"" + document.getElementById("serial").value + "\","; 
	product += "\"type\":\"" + $('input[name=type]:checked').val() + "\","; 
	product += "\"idMarket\":\"" + getCookie("id_market") + "\"}"; 
	
	console.log(product);


        $.ajax({
            type: "POST",
            url: "/product/cadastrar" ,
            data: product,
            contentType: "application/json",
            success: function(data) {
    			success();
    			
    			document.getElementById("name").value = "";
				document.getElementById("descrition").value = ""; 
				document.getElementById("value").value = ""; 
				document.getElementById("picture").value = ""; 
				document.getElementById("serial").value = "";
    			
      			return; 
    		}
        });



}

function createAndSendEncarte(){
	var encarte = "";
	encarte += "{\"name\":\"" + document.getElementById("name").value + "\",";
	encarte += "\"description\":\"" + document.getElementById("description").value + "\","; 
	encarte += "\"data\":\"" + document.getElementById("data").value + "\",";
	encarte += "\"type\":\"" + $('input[name=type]:checked').val() + "\","; 
	encarte += "\"picture\":\"" + document.getElementById("picture").value + "\","; 
	encarte += "\"status\":\"" + $('input[name=status]:checked').val() + "\","; 
	encarte += "\"idMarket\":\"" + getCookie("id_market") + "\"}"; 
	
	console.log(encarte);


        $.ajax({
            type: "POST",
            url: "/encarte/cadastrar" ,
            data: encarte,
            contentType: "application/json",
            success: function(data) {
    			success();
    			
    			document.getElementById("name").value = "";
				document.getElementById("description").value = ""; 
				document.getElementById("data").value = "";
				document.getElementById("picture").value = "";
				
				$("input:radio[name='status']").each(function(i) {
				       this.checked = false;
				}); 
				
				$("input:radio[name='type']").each(function(i) {
				       this.checked = false;
				}); 
    			
      			return; 
    		}
        });
}



function carregarBuscaEncarteEdit(obj) {
    

	var str = "";
	for (var i = 0; i < obj.length; i++) {

		if (i % 3 == 0) {
			str += "<div class='row'>";
		}
		str += "<div class='col-sm-4' onclick='carregarProdutosEncarte(" + obj[i].id +")' >";

		str += "<dl>";
		str += "</dd>";
		
		str += "<img class='card-img-top' src='" + obj[i].picture
				+ "' alt='Card image' style='width:60%'>";

		str += "<dl>";
		str += "</dd>";
		
		str += "<strong>Nome do Encarte: </strong>" + obj[i].name;
		str += "<dl>";
		str += "</dd>";
		str += "<strong>Status: </strong>" + obj[i].status;
		str += "<dl>";
		str += "</dd>";
		str += "<strong>Descrição do Encarte: </strong>"
				+ obj[i].description;
		str += "<dl>";
		str += "</dd>";
		str += "<strong>Data de Validade: </strong> " + obj[i].data;
		str += "<dl>";
		str += "</dd>";
		str += "<strong>Id do Encarte: </strong> " + obj[i].id;
		str += "<dl>";
		str += "</dd>";
		str += "<strong>Categoria: </strong> " + obj[i].type;
		
		str += "<dl>";
		str += "</dd>";

		str += "<dl>";
		str += "</dl>";

		str += "</div>";

		if (i % 3 == 2) {
			str += "</div>";
		}
	}

	document.querySelector("main5").innerHTML = str;

}

function carregarProdutosEncarte(idEncarte){
	document.cookie= "id_encarte=" + idEncarte;
    window.location.href = '/listaproductsencarte/' + idEncarte;
}

function salvarProdutos(){
	
	var str='{"id":"' + getCookie("id_encarte") + '", "products":[';
	
	$("input:checkbox[name=productBound]:checked").each(function () {
            str += '{"id":"' + $(this).val() + '"},';
    });
    
    str = str.substring(0, str.length-1);
	
	str += ']}';
	

	$.ajax({
        type: "POST",
        url: "/productsencarte" ,
        data: str,
        contentType: "application/json",
        success: function(data) {
			success();
			
			/*document.getElementById("name").value = "";
			document.getElementById("description").value = ""; 
			document.getElementById("data").value = "";
			document.getElementById("picture").value = "";
			
			$("input:radio[name='status']").each(function(i) {
			       this.checked = false;
			}); 
			
			$("input:radio[name='type']").each(function(i) {
			       this.checked = false;
			}); 
			
  			return; */ 
		}
    });	
	
	
	console.log(str);
	
}


