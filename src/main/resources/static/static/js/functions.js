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



function pesquisaPrincipal() {
	var param = document.querySelector("#pesquisaNome").value;
	var tipoBusca = document.querySelector("#tipo-busca").value;
		
	$.ajax({
        type: "GET",
        url: "/" + tipoBusca + "/"+ param,
        contentType: "application/json",
        success: function(data) {
      		carregarTelaInicial(data);
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


function createAndSendProduct(){
	var product = "";
	product += "{\"name\":\"" + document.getElementById("name").value + "\",";
	product += "\"descrition\":\"" + document.getElementById("descrition").value + "\","; 
	product += "\"value\":\"" + document.getElementById("value").value + "\","; 
	product += "\"picture\":\"" + document.getElementById("picture").value + "\","; 
	product += "\"serial\":\"" + document.getElementById("serial").value + "\","; 
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
