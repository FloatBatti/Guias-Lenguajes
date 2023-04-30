<?php



class StudentCollection implements InStudentCollection{

    private $userList;

    public function __construct()
    {
        $this->userList = array();
    }

    public function addStudent(Student $student)
    {
        array_push($this->userList, $student);
        
    }

    public function getAll()
    {
        return $this->userList;
    }

}

?>