<?php

namespace  Controlador;

require_once "Config/Autoload.php";

use Modelos\Person;

class Student extends Person{

    private $fileNumber;

    public function __construct(string $firstName, string $secondName, string $dni, string $fileNumber)
    {
        $this->firstName= $firstName;
        $this->secondName= $secondName;
        $this->dni= $dni;
        $this->fileNumber= $fileNumber;
    }

    public function getFileNumer(){return $this->fileNumber;}
    public function setFileNumer($fileNumber){$this->fileNumber = $fileNumber;}

    public function mostrarEstudiante(){

        echo "Nombre: " . $this->firstName . "<br>";
        echo "Apellido: " . $this->secondName . "<br>";
        echo "DNI: " . $this->dni . "<br>";
        echo "Legajo: " . $this->fileNumber . "<br>";

    }

}

?>