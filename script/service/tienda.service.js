import { Tienda } from "./../model/tienda.js";

class tiendaService{
    constructor(){
        this.url = HOST + '/Tiendas';
    }

    listar(){
        var response = httpGet(this.url);
        var json = response.responseText;
        var jsonParsed = JSON.parse(json);

        for (var e in jsonParsed){
            var temTienda = new Tienda();
            temTienda.loadFromParsedJson(jsonParsed[e]);
            jsonParsed[e] = temTienda;
        }

        return jsonParsed;
    }

    registrar(tienda){
        return httpPost(this.url, tienda.stringify());
    }

    login(tienda){
        var response = httpPost(this.url + "/login", tienda.stringify());

        if(response.status != 200 && response.status != 201){
            showError(response.responseText);
            return null;
        }

        var tienda = new Tienda();
        tienda.loadFromJson(response.responseText);

        if(response.status == 200){
            var ref = document.getElementById("siIniciaSesion");
            ref.href = "principal-page.html";
        }

        return tienda;
    }
}

export { tiendaService };