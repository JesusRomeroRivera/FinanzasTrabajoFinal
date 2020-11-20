const $backButton = document.querySelector(".terminos-back");
const $enterButton = document.querySelector(".principal-button");
const $enterButton2 = document.querySelector(".principal-button2");
const $terminos = document.querySelector(".terminos");
$backButton.addEventListener("click", hideTerminos);
$enterButton.addEventListener("click", showTerminos);
$enterButton2.addEventListener("click", showTerminos);

function hideTerminos() {
    $terminos.classList.remove("is-active");
    $terminos.classList.add("not-active");
}

function showTerminos() {
    $terminos.classList.add("is-active");
    $terminos.classList.remove("not-active");
}

const $estableButton = document.querySelector(".btn-estable");
const $clienteButton = document.querySelector(".btn-cliente");
const $formEstable = document.querySelector(".establecimiento");
const $formCliente = document.querySelector(".clientes");

$estableButton.addEventListener("click", showEstable);
$clienteButton.addEventListener("click", showCliente);

function showEstable(){
    $formEstable.classList.add("is-active");
    $formEstable.classList.remove("not-active");
    if($formCliente.classList.contains("is-active")) $formCliente.classList.add("not-active");
    $formCliente.classList.remove("is-active");
}

function showCliente(){
    $formCliente.classList.add("is-active");
    $formCliente.classList.remove("not-active");
    if($formEstable.classList.contains("is-active")) $formEstable.classList.add("not-active");
    $formEstable.classList.remove("is-active");
}