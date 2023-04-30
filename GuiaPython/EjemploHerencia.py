

class Persona:
    
    #Nombre
    #Apellido
    #Edad
    #dni
    
    def __init__ (self,nombre, apellido, edad, dni):
        
        self._nombre = nombre
        self._apellido = apellido
        self._edad = edad
        self._dni = dni
        
    #Getter -> Me devuelve el valor del atributo del objeto
    @property
    def dni(self):
        return self._dni
    
    #Setter -> Asigna un nuevo valor al atributo de mi objeto
    @dni.setter
    def dni(self, dni):
        
        if (type(dni) != str): 
            
            print("El valor no puede ser numerico")
            
        elif (len(dni) != 8):
            
            print(" Tiene que tener 8 digitos")

        else:
            
            self._dni = dni
        
        
    def __str__ (self):
        
        return f"Nombre: {self._nombre} \nApellido: {self._apellido} \nEdad: {self._edad} \nDNI: {self._dni}"
  
    
    def __eq__(self, otraPersona):
        
        if (self._dni == otraPersona._dni):
            return True
        else:
            return False
        
  
class Estudiante(Persona):
    
    def __init__(self, nombre, apellido, edad, dni, *notas):
        
        super().__init__(nombre, apellido, edad, dni)
        self._listaNotas = list(notas)
        
    def agregarNota(self, notaNueva):
        
        if(notaNueva > 0 and notaNueva < 10):
            self._listaNotas.append(notaNueva)
        else:
            print("Nota fuera de rango")
        
    def borrarNota(self, numeroExamen):
        self._listaNotas.pop(numeroExamen)
        
    def __str__(self):
        return super().__str__() + f"\nNotas: {self._listaNotas}"
    
    
alumno1 = Estudiante("Juan", "Lopez", 23, "12345678", 10, 8, 5, 3, 7)

alumno1.borrarNota(1)
alumno1.agregarNota(50)

print(alumno1)

