class Persona:
    
    def __init__ (self,nombre, dni, mail, telefono):
        
        self._nombre = nombre
        self._dni = dni
        self._telefono = telefono
        self._mail = mail
        
    def getNombre(self):
        return self._nombre
    
    def getDni(self):
        return self._dni
    
    def getTelefono(self):
        return self._telefono
    
    def getMail(self):
        return self._mail
    
    def __str__(self):
        
        return f"Nombre: {self._nombre}\nDNI: {self._dni}\nTelefono: {self._telefono}\nMail: {self._mail}"
    
        
        
