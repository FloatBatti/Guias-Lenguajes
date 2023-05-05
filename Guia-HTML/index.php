<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página de prueba</title>
    <link rel='stylesheet' href="estilos.css">
</head>
<body>
 
    <h1 id = "Arriba" title="Titulo">My first Heading &copy</h1>
    

    <h2>My second Heading</h2>

    <p class="parrafo" style = "Margin: auto 300px;"><b>My first paragraph</b></p>

    <p class="parrafo" title="Parrafo Lorem" style="text-align: justify;">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quo, eaque, distinctio praesentium iusto vel nam laudantium veritatis aspernatur perferendis nesciunt nihil unde molestias ratione recusandae, aut dolorum amet hic sit!</p>

    <pre style="font-family: 'Roboto'"> 
        
    Parrafo 
    que respeta
    texto
        
    </pre>

    <a href="https://carontestudio.com/blog/listado-de-etiquetas-html/" target="_blank">Leer esto</a>

    <br> <br>

    <img src="https://us.123rf.com/450wm/objowl/objowl1209/objowl120900004/15031310-star-flower-imagen-abstracta-digital-con-un-dise%C3%B1o-estrella-flor-psicod%C3%A9lica-en-verde-azul-rosa-y-am.jpg" alt="Imagen de prueba" title="Random" height="100" width="100">

    <br> <br>

    <a href="/contacto.php" target="_blank" style="font-size: 20px; border: 5px solid #42032C; padding: 5px; background-color: #E6D2AA; display: inline-block;">Contacto</a>

    <div style="margin-top: 15px;">
 
        <table>

        <caption><b>Listado de Personas</b></caption>
            
            <tr>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Telefono</th>
            </tr>

            <tr>
                <td>Juan</td>
                <td>Perez</td>
                <td rowspan="2">2236598744</td>
            </tr>

            <tr>
                <td>Jose</td>
                <td>Maria</td>
            </tr>

            <tr>
                <td colspan="2">Anonimo</td>
                <td>223-------</td>
            </tr>

            <tr>
                <td>Agustin</td>
                <td>Battisti</td>
                <td>2236064588</td>
            </tr>

        </table>


    </div>

   <div>
        <ul style="list-style-type: square;">
        
        <li>Agustin</li>
            <ul style="list-style-type: square;">
                <li>tel. 223</li>
            </ul>  
        <li>Barbi</li>
        </ul>

   </div>

   <div>

        <ol type="I">
            <li>Comprar Curso</li>
            <li>Estudiar Curso</li>
            <li>Dar clases</li>
        </ol>

   </div>

   <div>
        <ul class="barraInicio">
            <li class="elementoInicio"><a class="elementoInicio" href="index.php" target="_blank">Inicio</a></li>
            <li class="elementoInicio"><a class="elementoInicio" href="contacto.php" target="_blank">Contacto</a></li>
        </ul>
   </div>

   <div>
        <dl>
            <dt>Java: </dt>
            <dd>Creador: James Gosling</dd>
            <dt>Python: </dt>
            <dd>Creador: Guido Van Rossum</dd>
        </dl>

    <h2>Elemento span (inline)</h2>

    <p>Texto donde vamos a
        <span style="color: red; border: 1px solid black">Enfatizar</span>
            y cambiar el
        <span style="color: blue; font-weight: bold;">color de algunos elementos</span>
    </p>

    <div id="bloqueDiv">
        <h3>Elemento block (div)</h3>
        <p>Texto dentro del div</p>
    </div>

    <p>Texto fuera del div</p>

    <a href="#Arriba" style="margin-bottom: 20px;">Ir para arriba</a><br>

    <a href="index2.php" target="_blank">Ir a la segunda parte</a><br>

    <a href="script.php" target="_blank">Ir a los scripts</a>


</body>
</html>

