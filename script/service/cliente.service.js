import { Cliente } from "./../model/cliente.js";

class clienteService{
    constructor(){
        this.url = HOST + '/Clientes';
    }

    listar(){
        var response = httpGet(this.url);
        var json = response.responseText;
        var jsonParsed = JSON.parse(json);

        for (var e in jsonParsed){
            var tempCliente = new Cliente();
            tempCliente.loadFromParsedJson(jsonParsed[e]);
            jsonParsed[e] = tempCliente;
        }

        return jsonParsed;
    }

    registrar(cliente){
        return httpPost(this.url, cliente.stringify());
    }

    login(cliente){
        var response = httpPost(this.url + "/login", cliente.stringify());

        if(response.status != 200 && response.status != 201){
            showError(response.responseText);   
            return null;
        }

        var cliente = new Cliente();
        cliente.loadFromJson(response.responseText);

        if(response.status == 200){
            var ref = document.getElementById("siIniciaSesion");
            ref.href = "principalPageUser.html";
        }

        return cliente;
    }
}

export { clienteService };