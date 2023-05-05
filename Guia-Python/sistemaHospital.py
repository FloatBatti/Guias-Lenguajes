from mimetypes import init
from re import T


class Usuario: 
    
    def __init__(self, nombre, mail, dni, telefono ):
        self._nombre= nombre 
        self._mail= mail 
        self._dni= dni 
        self._telefono= telefono 
        
    @property 
    def mail (self): 
        return self._mail 
    
    @mail.setter
    def mail (self, nuevoMail): 
        self._mail=nuevoMail 
        
    def __eq__(self, otroUsuario):
        
        if (self._dni == otroUsuario._dni):
            return True
        else:
            return False
        
        
    def __str__(self): 
        return f"Nombre: {self._nombre} \nMail: {self._mail} \nDni: {self._dni} \nTelefono: {self._telefono}"
    
 
#########################################################################################################################
 
class Turno:
    
    def __init__(self, fecha, hora, tipoEstudio, doctor):
        
        self._fecha = fecha
        self._hora = hora
        self._tipoEstudio = tipoEstudio
        self._doctor= doctor
        
    def __str__(self): 
           
        return f"Fecha: {self._fecha} \nHora: {self._hora} \ntipoEstudio: {self._tipoEstudio} \nDoctor: {self._doctor}"
    

#########################################################################################################################

class Paciente(Usuario):
    
    def __init__(self, nombre:str, mail:str, dni:str, telefono:str, numObraSocial:str):
        
        super().__init__(nombre, mail, dni, telefono)
        self._numObraSocial = numObraSocial
        self._listaTurnos = []
        
    def __str__(self):
        return super().__str__() + f"\nNumero Obra Social: {self._numObraSocial}"
    
    
    def agregarTurno(self):
         
        fecha = input("Ingrese fecha del turno: ")
        hora = input("Ingrese la hora del turno: ")
        tipoEstudio = input("Ingrese el tipo de estuduo: ")
        doctor = input("Ingrese nombre del doctor: ")
        
        turno = Turno(fecha, hora, tipoEstudio, doctor)
        
        self._listaTurnos.append(turno)    
        
    
#########################################################################################################################
 
class Doctor(Usuario):
    
    def __init__(self, nombre, mail, dni, telefono, numObraSocial, listaPacientes):
        
        super().__init__(nombre, mail, dni, telefono)
        self._especialidad = numObraSocial
        self._listaPacientes = listaPacientes
        


