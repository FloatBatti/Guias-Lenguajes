<?php

require_once "Config/Autoload.php";

use Controlador\Student;

$student1 = new Student($_POST["nombre"], $_POST["apellido"], $_POST["dni"], $_POST["legajo"]);

$student1->mostrarEstudiante();

?>