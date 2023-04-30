
from datetime import datetime
from os import lseek
from Models.Consultorio import *
from Models.Doctor import *
from Models.Paciente import *
from Models.Turno import *


consultorio1 = Consultorio(1, True)
consultorio2 = Consultorio(2, False)

doctor1 = Doctor("Pablo", "1231321", "223656564", "pabdoctor@gmail.com", "Pediatra")

paciente1 = Paciente("Juan", "400155451", "223659898", "juancitocapo@gmail.com", "123545")

doctor1.agregarPaciente(paciente1)

turno1 = Turno(datetime.now(), doctor1, consultorio1)

paciente1.agregarTurno(turno1)


print(paciente1.mostrarTurnos())