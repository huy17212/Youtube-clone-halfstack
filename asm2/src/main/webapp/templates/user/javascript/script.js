var menuIcon = document.querySelector(".menu-icon");
var slideBar = document.querySelector(".slidebar");
var container = document.querySelector(".container");

menuIcon.onclick = function(){
    slideBar.classList.toggle("small-sidebar");
    container.classList.toggle("large-container");
}

