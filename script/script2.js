const $menuBtn = document.querySelector('.menu-btn');
const $otherNav = document.querySelector('.header2-othernav'); 
let menuOpen = false;

$menuBtn.addEventListener('click', () => { 
  $menuBtn.classList.toggle('open');
  $otherNav.classList.toggle('is-active');
});

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
