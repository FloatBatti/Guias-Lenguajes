class Fraccion:

    def __init__(self, arriba, abajo):

        comunDiv = mcd(arriba, abajo, 1)

        if comunDiv == 0:
            self.num = 0
            self.den = 0
        else:
            self.num = arriba // comunDiv
            self.den = abajo // comunDiv

    def __str__(self):  # Convierte un objeto en una cadena de caracteres para que pueda ser impreso

        string1 = "0"

        if self.num != 0:
            string1 = str(self.num) + "/" + str(self.den)

        if self.num == 1 and self.den == 1:
            string1 = "1"

        return string1

    def __add__(self, otraFraccion):  # Le da la propiedad de la suma al objeto, es decir, puede ser sumado con otro objeto de la misma clase
        
        nuevoDen = self.den * otraFraccion.den
        nuevoNum = (nuevoDen * self.num) + (nuevoDen * otraFraccion.num)

        return Fraccion(nuevoNum, nuevoDen)

    def __sub__(self, otraFraccion):  # Le da la propiedad de la resta al objeto, es decir, puede ser restado con otro objeto de la misma clase

        nuevoDen = self.den * otraFraccion.den
        nuevoNum = nuevoDen * self.num - nuevoDen * otraFraccion.num

        return Fraccion(nuevoNum, nuevoDen)

    def __mul__(self, otraFraccion):  # Le da la propiedad de la multiplicacion al objeto, es decir, ahora puede ser multiplicado con otro objeto de la misma clase

        nuevoNum = self.num * otraFraccion.num
        nuevoDen = self.den * otraFraccion.den

        return Fraccion(nuevoNum, nuevoDen)

    def __truediv__(self, otraFraccion):  # Le da la propiedad de la division al objeto, es decir, ahora puede ser dividido por otro objeto de la misma clase

        fraccRevez = Fraccion(otraFraccion.den, otraFraccion.num)
        rta = self * fraccRevez

        return rta

    def __eq__(self, otraFraccion):  # Compara dos objetos y devuelve True si sus valores son iguales, False de lo contrario.

        condition = False
        if self.num == otraFraccion.num and self.den == otraFraccion.den:
            condition = True

        return condition
    


"""
El algoritmo de Euclides para encontrar MCD(A,B) es como sigue:

Si A = 0 entonces MCD(A,B)=B, ya que el MCD(0,B)=B, y podemos detenernos.  
Si B = 0 entonces MCD(A,B)=A, ya que el MCD(A,0)=A, y podemos detenernos.  
Escribe A en la forma cociente y residuo (A = B ⋅Q + R).
Encuentra MCD(B,R) al usar el algoritmo de Euclides, ya que MCD(A,B) = MCD(B,R).

"""


def mcd(a, b, default):
    div = default

    if a == 0:
        div = b
    elif b == 0:
        div = a

    if a != 0 and b != 0:
        resto = a % b
        div = mcd(b, resto, div)

    return div


""" Herencia """ 

class Decimal(Fraccion):

    def decimal(self):
        return self.num / self.den




