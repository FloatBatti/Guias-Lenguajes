
<?php

require_once "Modelos/Student.php";
require_once "Controlador/Student.php";


    class User{

        private $name;
        private $email;
        public static $des = "Esto es una clase de usuarios";

        
        public function __construct($name, $email)
        {
            
            $this->name = $name;
            $this->email = $email;  
        }

        public function setName($newName){

            $this->name = $newName;
        }

        public function getName(){

            return $this->name;
        }

        public static function funcionEstatica(){

            echo "Esto es una funcion estatica";
        }

        

    }

?>


<!DOCTYPE html>
<html lang="en">

<head>
    <title>Clases</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel='stylesheet' href="estilos.css">
</head>

<body>

<?php

$user = new User("Agustin", "agusbatti52@gmail.com");

echo $user->getName() . "<br>";

echo User::$des . "<br> ";

User::funcionEstatica();

echo "<hr>";




?>

<form method="POST" action="action.php">

    <label for="nombre">Nombre: </label><br>
    <input type="text" id="nombre" name="nombre" placeholder="Escribir nombre" required="true"><br>

    <label for="apellido">Apellido: </label><br>
    <input type="text" id="apellido" name="apellido" placeholder="Escribir apellido" required="true"><br>

    <label for="dni">DNI: </label><br>
    <input type="text" id="dni" name="dni" placeholder="Escribir dni" required="true"><br>

    <label for="legajo">Legajo: </label><br>
    <input type="text" id="legajo" name="legajo" placeholder="Escribir legajo" required="true"><br><br>

    <input type="submit" value="Enviar">

</form>

</body>

</html>