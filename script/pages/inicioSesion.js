import { Cliente } from "./../model/cliente.js";
import { clienteService } from "./../service/cliente.service.js";
import { Tienda } from "./../model/tienda.js";
import { tiendaService } from "./../service/tienda.service.js";

var $btnLoginGeneral = document.querySelector('.button-login');
if($btnLoginGeneral != null) $btnLoginGeneral.addEventListener('click', function(){
  localStorage.setItem('loggedUser',iniciarSesionFunction().stringify());
}, false);

function iniciarSesionFunction(){
  var correo = document.getElementById("correo_login").value;
  var contraseña = document.getElementById("contraseña_login").value;

  var cliente = new Cliente();
  var tienda = new Tienda();
  cliente.correo = correo;
  cliente.password = contraseña;
  tienda.correo = correo;
  tienda.password = contraseña;
  var serviceTienda = new tiendaService();
  var serviceCliente = new clienteService();

  cliente = serviceCliente.login(cliente);
  tienda = serviceTienda.login(tienda);

  if(cliente != null){
    return cliente;
  }
  else if(tienda != null){
    return tienda;
  }

  alert("Datos ingresados incorrectos");

  return null;
}