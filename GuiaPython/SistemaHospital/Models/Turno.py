
from datetime import datetime

from SistemaHospital.Models.Consultorio import Consultorio
from SistemaHospital.Models.Doctor import Doctor


class Turno:
    
    def __init__(self, fecha, doctor:Doctor, consultorio:Consultorio):
        
        self._fecha = fecha
        self._doctor = doctor
        self._consultorio= consultorio
        

    def getDoctor(self):
        return self._doctor
    
    def getFecha(self):
        return self._fecha
    
    def getConsultorio(self):
        return self._consultorio