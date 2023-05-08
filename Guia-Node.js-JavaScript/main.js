
// * Movimiento boton

const boton = document.getElementById('btn');
const titulo = document.getElementById('titulo')

boton.onclick = ()=>{

    boton.style.padding = "20px 30px";
    boton.style.fontSize = "20px"

    titulo.innerHTML = "Haz ganado un premio de 1 millón de dolares";

    setTimeout(()=>{

        boton.style.padding = "10px 20px";
        boton.style.fontSize = "16px"
    }, 100);
}