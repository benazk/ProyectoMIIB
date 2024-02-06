function mostrarGaleria() { // Funcion para mostrar la galeria al hacer click en el boton
    var galeria = document.querySelector(".galeria");
    var gris = document.getElementById("gris");

    if (galeria.style.display === "none") {
        galeria.style.display = "block";
        gris.style.display = "block";
    } else {
        galeria.style.display = "none";
        gris.style.display = "none";
    }
}
function ocultarGaleria() { // Funcion para ocultar la galeria al hacer click en la X
    var galeria = document.querySelector(".galeria");
    var gris = document.getElementById("gris");

    if (galeria.style.display === "block") {
        galeria.style.display = "none";
        gris.style.display = "none";
    } else {
        galeria.style.display = "block";
        gris.style.display = "block";
    }
}
function mostrarBarra() { // Funcion para mostrar el menu al hacer click en el menu tipo hamburguesa
    var barra_lateral = document.querySelector(".barra_lateral");
    var gris = document.getElementById("gris");

    if (barra_lateral.style.display === "none") {
        barra_lateral.style.display = "block";
        gris.style.display = "block";
    } else {
        barra_lateral.style.display = "none";
        gris.style.display = "none";
    }
}
function ocultarBarra() { // Funcion para ocultar el menu al hacer click en la X
    var barra_lateral = document.querySelector(".barra_lateral");
    var gris = document.getElementById("gris");

    if (barra_lateral.style.display === "block") {
        barra_lateral.style.display = "none";
        gris.style.display = "none";
    } else {
        barra_lateral.style.display = "block";
        gris.style.display = "block";
    }
}


