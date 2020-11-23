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

        return cliente;
    }
}

service = new clienteService();
service.listar();

const $btn = document.querySelector('.button-login');
$btn.addEventListener('click', () => {
    var correo = document.getElementById("correo_login").value;
    var contraseña = document.getElementById("contraseña_login").value;

    cliente = new Cliente();
    cliente.correo = correo;
    cliente.password = contraseña;
    console.log(cliente);
    console.log(service.login(cliente));
})