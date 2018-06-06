function converteFormEmJSON(form) {
    console.log('ConvertFormToJSON invoked!');
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
    console.log('JSON: ' + json);

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
    if (json != "null") {
        $.ajax({
            type: "POST",
            url: "/encarte/" + param,
            data: json,
            contentType: "application/json"
        });
    success();
    }
}

function read(param, id, form) {
    $.ajax({
        type: "GET",
        url: "/encarte/" + param + "/" + jQuery("#" + id).val(),
        data: null,
        contentType: "application/json"
    }).done(function (data) {
        console.log(data);
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
		
	$.ajax({
        type: "GET",
        //url: "/produtos/pesquisaFiltro?paramPesquisa="+ param,
        url: "/produtos/"+ param,
        contentType: "application/json",
        success: function(data) {
        	console.log(data);
      		carregarTelaInicial(data);
      		return; 
    	}
        
    });
}

function updatePrincipal(param, form) {
    json = converteFormEmJSON(form);
    console.log(json);
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
    console.log(json);
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
	var str = "";
	for (var i = 0; i < obj.length; i++) {
		console.log(obj[i])

		if (i % 3 == 0) {
			str += "<div class='row'>";
		}
		str += "<div class='col-sm-4'>";

		str += "<dl>";
		str += "</dd>";

		str += "<dl>";
		str += "</dd>";
		str += "<strong> Nome do produto: </strong>"
				+ obj[i].name;
		str += "<dl>";
		str += "</dd>";
		
		str += "<dl>";
		str += "</dd>";
		str += "<strong> valor do produto: </strong>"
				+ obj[i].value;
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