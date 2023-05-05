
from SistemaHospital.Models.Persona import Persona


class Doctor(Persona):
    
    def __init__(self,nombre:str, dni:str, mail:str, telefono:str, especializacion:str):
        
        super().__init__(nombre, dni, mail, telefono)
        self._especializacion = especializacion
        
        
    def getEspecializacion(self):
        
        return self._especializacion


