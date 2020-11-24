import { Cliente } from "./../model/cliente.js";

var user = new Cliente();
user.loadFromJson(localStorage.getItem('loggedUser'));
console.log(user);

document.getElementById("nombre_Cliente").innerHTML = user.nombre + " " + user.apellido;