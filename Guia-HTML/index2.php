<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Segunda parte</title>
    <link rel='stylesheet' href="estilos.css">
</head>
<body>
                                 
    <h1>Uso del iFrame</h1>

    <iframe src="iFrame.php" class="marcoiFrame" name="iFrame"></iframe>

    <div style="text-align: center;">
        <a href="https://campus.mdp.utn.edu.ar/pluginfile.php/102570/mod_resource/content/1/Laboratorio%20IV.pdf" target="iFrame" class="botoniFrame" style="text-decoration: none;" >Cargar PDF de la UTN</a>
    </div>

 
    <p class="tituloForm">Formularios</p>

    <form method="POST">

        <fieldset>
        
            <legend>Formularios  (fieldset) </legend>
            <label for="nombre">Nombre: </label><br>
            <input type="text" id="nombre" name="nombre" placeholder="Escribir nombre" required="true"><br>

            <label for="apellido">Apellido: </label><br>
            <input type="text" id="apellido" name="apellido" placeholder="Escribir apellido" required="true"><br>

            <label for="password">Contraseña: </label><br>
            <input type="password" id="password" name="password" placeholder="Escribir contraseña" required="true"><br>

            <label for="email">Email: </label><br>
            <input type="email" id="email" name="email" placeholder="Ingrese su mail" required="true"><br>

            <label for="edad">Edad: </label><br>
            <input type="number" id="edad" name="edad" placeholder="Ingrese su edad" required="true"><br>

            <label for="altura">Altura: </label><br>
            <input type="number" id="altura" name="altura" placeholder="Ingrese su altura" required="true" step="any"><br><br>

            <input type="submit" value="Enviar"> <br><br>
            <input type="submit" formnovalidate="formnovalidate" value="Enviar sin validar">

        </fieldset>

    </form>

</body>
</html>