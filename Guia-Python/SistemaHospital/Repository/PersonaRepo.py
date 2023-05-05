
#JSON: JavaScript Object Notation
from ..Models.Persona import Persona


class PersonaRepo:
    
    
    def __init__(self):
        
        self.fileName = "Data/Personas.json"
        self.listaPersonas=[]
    
    
    def GetAll(self):
        pass
    
    def SaveData(self):
        pass
    
    def RetriveData(self):
        
        with open (self.fileName, "r", encoding="utf8") as archivo:
            
            pass
            
    
    def Add(self, persona:Persona):
        pass
    

