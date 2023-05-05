# A modo de ejemplo un error es cuando dos numero son iguales

class NumeroNegativo(Exception):
    
    def __init__(self, mensaje):
        self.mensaje = mensaje
        


def verificarNumero(num):
    
    if num < 0:
        raise NumeroNegativo("Numeros identicos")  # Arroja una execption si ocurre una condicion
        

