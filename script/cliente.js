const $buttonActua = document.querySelector('.header2-actualiza');
const $actualiza = document.querySelector('.actualiza');

const $backButton = document.querySelector(".actualiza-back");

let aux = true;

$buttonActua.addEventListener('click', () => { 
  if(aux) {
    $actualiza.classList.add('is-active'); 
    aux = false;
  }else{
    $actualiza.classList.toggle('not-active');
    $actualiza.classList.toggle('is-active');
  }
});
$backButton.addEventListener('click', () => {
  $actualiza.classList.toggle('not-active');
  $actualiza.classList.toggle('is-active');
})

const $actual = document.querySelector(".actual-tbody");
const $datosCliente = document.querySelector(".datosCliente");

let aux2 = true;
$actual.addEventListener('click', () => { 
  if(aux2) {
    $datosCliente.classList.add('is-active'); 
    aux2 = false;
  }else{
    $datosCliente.classList.toggle('not-active');
    $datosCliente.classList.toggle('is-active');
  }
});

const $otherBackButton = document.querySelector(".datosCliente-back");

$otherBackButton.addEventListener('click', () => {
  $datosCliente.classList.toggle('not-active');
  $datosCliente.classList.toggle('is-active');
})

const $buttonCobrar = document.querySelector(".credito-title-ancle");
const $cobrarSection = document.querySelector(".cobrar");

let aux3 = true;
$buttonCobrar.addEventListener('click', () => { 
  if(aux3) {
    $cobrarSection.classList.add('is-active'); 
    $datosCliente.classList.add('blur');
    aux3 = false;
  }else{
    $cobrarSection.classList.toggle('not-active');
    $cobrarSection.classList.toggle('is-active');
    $datosCliente.classList.toggle('blur');
  }
});

const $otherBackButton2 = document.querySelector(".cobrar-back");

$otherBackButton2.addEventListener('click', () => {
  $cobrarSection.classList.toggle('not-active');
  $cobrarSection.classList.toggle('is-active');
  $datosCliente.classList.toggle('blur');
})

const $guardarButton = document.querySelector(".guardar-button");
const $montoSection = document.querySelector(".monto");
const $cliente = document.querySelector(".cliente");

let aux4 = true;

$guardarButton.addEventListener('click', () => { 
  if(aux4) {
    $montoSection.classList.add('is-active'); 
    $cliente.classList.add('blur');
    aux4 = false;
  }else{
    $montoSection.classList.toggle('not-active');
    $montoSection.classList.toggle('is-active');
    $cliente.classList.toggle('blur');
  }
});

const $otherBackButton3 = document.querySelector(".monto-back");

$otherBackButton3.addEventListener('click', () => {
  $montoSection.classList.toggle('not-active');
  $montoSection.classList.toggle('is-active');
  $cliente.classList.toggle('blur');
})

let aux5 = true;
let aux6 = true;

const $seguridadButton = document.querySelector(".seguridad-button");
const $productosButton = document.querySelector(".productos-button");
const $seguridadSection = document.querySelector(".seguridad");
const $productosSection = document.querySelector(".productos");

$seguridadButton.addEventListener('click', () => { 
  if(aux5) {
    $seguridadSection.classList.add('is-active'); 
    $seguridadButton.classList.toggle('active');
    aux5 = false;
  }else{
    $seguridadSection.classList.toggle('not-active');
    $seguridadSection.classList.toggle('is-active');
    $seguridadButton.classList.toggle('active');
  }
  if($productosButton.classList.contains('active')){
    $productosSection.classList.toggle('not-active');
    $productosButton.classList.toggle('active');
    $productosSection.classList.toggle('is-active');
  }
});

$productosButton.addEventListener('click', () => { 
  if(aux6) {
    $productosSection.classList.add('is-active'); 
    $productosButton.classList.toggle('active');
    aux6 = false;
  }else{
    $productosSection.classList.toggle('not-active');
    $productosButton.classList.toggle('active');
    $productosSection.classList.toggle('is-active');
  }
  if($seguridadButton.classList.contains('active')){
    $seguridadSection.classList.toggle('not-active');
    $seguridadButton.classList.toggle('active');
    $seguridadSection.classList.toggle('is-active');
  }
});

const $otherBackButton4 = document.querySelector(".seguridad-back");

$otherBackButton4.addEventListener('click', () => {
  $seguridadSection.classList.toggle('not-active');
  $seguridadSection.classList.toggle('is-active');
  $seguridadButton.classList.remove('active');
})

const $otherBackButton5 = document.querySelector(".productos-back");

$otherBackButton5.addEventListener('click', () => {
  $productosSection.classList.toggle('not-active');
  $productosSection.classList.toggle('is-active');
  $productosButton.classList.remove('active');
})

const $menuBtn = document.querySelector('.menu-btn');
const $otherNav = document.querySelector('.header2-othernav'); 
let menuOpen = true;

$menuBtn.addEventListener('click', () => { 
  if(menuOpen) {
    $otherNav.classList.add('is-active'); 
    menuOpen = false;
  }else{
    $otherNav.classList.toggle('not-active');
    $otherNav.classList.toggle('is-active');
  }
  $menuBtn.classList.toggle('open');
  if(!$menuBtn.classList.contains('open')){
    $seguridadButton.classList.remove('active');
    $productosButton.classList.remove('active');
    if($seguridadSection.classList.contains('is-active')) $seguridadSection.classList.add('not-active');
    $seguridadSection.classList.remove('is-active');
    if($productosSection.classList.contains('is-active')) $productosSection.classList.add('not-active');
    $productosSection.classList.remove('is-active');
  }
});

const $agregarProducto = document.querySelector('.agregarProducto-button');
const $otherBackButton6 = document.querySelector('.agregarProducto-back-text');
const $agregarSection = document.querySelector('.agregarProducto');

let aux7 = true;

$agregarProducto.addEventListener('click', () => {
  $productosSection.classList.toggle('blur');
  if(aux7) {
    $agregarSection.classList.add('is-active'); 
    aux7 = false;
  }else{
    $agregarSection.classList.toggle('not-active');
    $agregarSection.classList.toggle('is-active');
  }
});

$otherBackButton6.addEventListener('click', () => {
  $productosSection.classList.toggle('blur');
  $agregarSection.classList.toggle('not-active');
  $agregarSection.classList.toggle('is-active');
});
