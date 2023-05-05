#  Esta clase funciona al implementar With
class ManejoArchivos:
    
    def __init__(self, nombreArchivo) -> None:
        
        self.nombre = nombreArchivo
        self.archi = None
        
    def __enter__ (self):
        
        print(" Se entra en el archivo ".center(50, "*"))
        self.archi = open(self.nombre, "r", encoding="utf8")
        return self.archi  #  Devuelve el archivo en la variable ubicada luego del "as"
    
    def __exit__ (self, tipoException, valorException, trazaError):  # Si o si se ponen estos parametros
        
        print(" Cerramos el archivo ".center(50,"*"))
        
        if self.archi: #  Devuelve True si esta apuntando a algun objeto. Quiere decir que el archivo esta abierto
            self.archi.close()
        
        