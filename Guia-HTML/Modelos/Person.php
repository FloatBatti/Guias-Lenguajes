<?php

namespace Modelos;

abstract class Person{

    protected $firstName;
    protected $secondName;
    protected $dni;

    public function setFirstName($firstName){$this->firstName = $firstName;}
    public function setSecondName($secondName){$this->secondName = $secondName;}
    public function setDni($dni){$this->dni = $dni;}
    public function getFirstName(){return $this->firstName;}
    public function getSecondName(){return $this->secondName;}
    public function getDni(){return $this->dni;}

}

?>