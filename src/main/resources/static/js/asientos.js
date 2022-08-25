/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */
const container = document.querySelector(".mb-container");
const seats = document.querySelectorAll(".seat-row .seat:not(.occupied)");
var count = 0;
const total = document.getElementById("total");
const enlace = document.getElementById("boton_pagar").href;


//function update total and count
function updateSelectedCount() {
    if (count === 0) {
        const selectedSeats = document.querySelectorAll(".seat-row .seat.selected");
        const seatsIndex = [...selectedSeats].map((seat) => [...seats].indexOf(seat));
        localStorage.setItem("selectesSeats", JSON.stringify(seatsIndex));
        count += selectedSeats.length;
    }
}

//funcion para seleccionar si no hay uno seleccionado deja seleccionar, hasta que selccionas muestra el boton de continuar 
container.addEventListener("click", function (e) {
    if (
            e.target.classList.contains("seat") &&
            !e.target.classList.contains("occupied") && count === 0
            ) {
        var pagar = document.getElementById("boton_pagar");
        pagar.href = enlace + "/"+ e.target.innerText;
        pagar.classList.toggle("visually-hidden");
        e.target.classList.toggle("selected");
        updateSelectedCount();

    }else if (
            e.target.classList.contains("seat") &&
            e.target.classList.contains("selected") && count === 1
            ) {
        count = 0;
        console.log("selected seat " + e.target.innerText);
         var pagar = document.getElementById("boton_pagar");
        pagar.href = enlace;
        pagar.classList.toggle("visually-hidden");
        e.target.classList.toggle("selected");
        updateSelectedCount();

    }
});




