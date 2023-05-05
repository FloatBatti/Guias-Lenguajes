from SistemaHospital.Models.Persona import Persona
from SistemaHospital.Models.Turno import Turno

""""""
class Paciente(Persona):
    
    def __init__(self, nombre:str, dni:str, mail:str, telefono:str,  obraSocial:str, turno:Turno):
        
        super().__init__(nombre, dni, mail, telefono)    
        self._obraSocial = obraSocial
        self._turno = turno
        
        
    def getObraSocial(self):
        return self._obraSocial
    
    def gerTurno(self):
        return self._turno
        
     
