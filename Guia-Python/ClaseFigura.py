from abc import ABC, abstractmethod  # Necesario para poder utilizar clases abstractas

""" Herencia Multiple """

class FiguraGeometrica(ABC): # Lo hereda para implementar la clase abstracta
    
    def __init__(self, ancho, alto):
        
        self._ancho = ancho
        self._alto = alto
        
    @abstractmethod  # Indica que es un metodo abstracto
    def calcularArea(self):
        pass
        
        
class Color:
    
    def __init__(self,color):
        
        self._color = color  
        
        
class Cuadrado(FiguraGeometrica, Color):  # El orden es importante ya que el primer super es la primer clase que ponemos como parametro
    
    def __init__(self, ancho, alto, color):
        
        # Para tener una mejor sintaxis aclaramos de que clase padre llamamos el metodo __init__
        FiguraGeometrica.__init__(self, ancho, alto)
        Color.__init__(self, color)
        

    def calcularArea(self):  # Metodo Abstracto
        return self._alto * self._ancho
    
    def __str__(self):
        
        return f"Ancho: {self._ancho}, Alto: {self._alto}, Color: {self._color}"
    
    
"""
MRO = Method Resolution Order. Este metodo permite conocer la jerarquia de la clase que llama al mismo. El orden de aparicion se lo da el orden de los argumentos pasados en la clase hija
"""

print(Cuadrado.mro())