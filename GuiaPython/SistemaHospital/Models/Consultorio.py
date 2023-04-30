
class Consultorio:
    
    def __init__(self, numero:int, estado:bool):
        
        self._numero = numero
        self._estado = estado
        
    def getNumero(self):
        return self._numero
    
    def getEstado(self):
        return self._estado