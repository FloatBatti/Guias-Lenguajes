<?php

$name = 'Agustin';
$number = 123;
$boolean = true;
$text = "Esto es una prueba con PHP";

$array = array("Agustin", "Juan", $number);
$arrayKV = array("Nombre" => "Agustin", "Años" => 24);
$arrayKV["Altura"] = 1.70;
$arrayKV[] = "Barbi";



define('PI', 3.14);

function mostrarDatos($param1, $param2, $param3){

    echo $param1 . "-" . $param2 . "-" . $param3;
}

function sumar($param1, $param2){

    return $param1 + $param2;
}

?>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Scripts</title>
    <link rel='stylesheet' href="estilos.css">
</head>



<body>


    <?php

/* 

    Comentario multilinea

*/

// Se concatena con el punto .

echo count($array);
echo("<pre>");
var_dump($array);
echo("</pre>");
echo("<hr>");

echo "Mi nombre es: " . $name . "<br>";
echo ("La suma es: " . sumar(3,$number) . "<hr>");

$nuevoArray = explode(" ", $text);
echo("<pre>");
var_dump($nuevoArray);
echo("</pre> <hr>");
$nuevoString = implode(" ", $nuevoArray);
echo $nuevoString . "<hr>";

foreach ($arrayKV as $key => $value){

    echo $key . " " . $value . "<br>";
}

echo("<hr>");

echo call_user_func("sumar", 10, 10); echo("<br>");

echo call_user_func_array("mostrarDatos", $array);

echo("<hr>");

?>

    <a href="clases.php" target="iFrame" class="botoniFrame"">Ir a clases</a>
    
</body>
</html>