from copy import*

a = 5
b = a  # b no es una copia, es una referencia a la misma instancia que a

nombres1 = ["Nicolas", "Rodrigo"]
nombres2 = nombres1

print("nombres1: ", nombres1, f" id {id(nombres1)}")
print("nombres2: ", nombres2, f" id {id(nombres2)}")

nombres2[1] = "Nahuel"  # Se esta trabajando con la misma isntancia que nombres1

print("nombres1: ", nombres1)

# Los siguientes metodos son importantes solo para los estructuras compuestas  


""" Metodo Copy (Shallow copy) """ # Realizo una copia superficial. Solo sirve en estructuras simples.

print("Metodo copy".center(50, "-"))

letras1 = ["a", "e", "i", "o", "u"]
letras2 = copy(letras1)   # Ahora "letras2" apunta a una direccion de memoria distinta, a una instancia nueva
listaCompuesta = ["a", "e", "i", ["o", "u"]]

letras2[1] = "z"

print("letras1: ", letras1, f" id {id(letras1)}")
print("letras2: ", letras2, f" id {id(letras2)}")

letras2 = copy(listaCompuesta)  # Aca solo va a crear una nueva instancia para los objetos simples, pero no para la estructura que esta dentro de arreglo, por eso se dice que es superficial. 

print("listaCompuesta: ", listaCompuesta)
print("alemento en la posicion 3 de listaCompuesta: ", listaCompuesta[3], f" id {id(listaCompuesta[3])}")

print("alemento en la posicion 3 de letras2: ", letras2[3], f" id {id(letras2[3])}")  # La direccion de memoria de la estructura dentreo de la estructura es la misma porque el copiado es superficial


""" Metodo deepcopy"""  # A diferencia de Copy hace un copiado mas profundo. Se utiliza para copiar variables que almacenen estructuras complejas

print("Metodo copy".center(50, "-"))

lista1 = [1,2,3, ["Gato", "Perro"]]

lista2 = deepcopy(lista1)

print("lista1: ", lista1)

print("alemento en la posicion 3 de lista1: ", lista1[3], f" id {id(lista1[3])}")

print("alemento en la posicion 3 de lista2: ", lista2[3], f" id {id(lista2[3])}")  # La direccion de memoria de la estructura dentreo de la estructura es diferente porque el copiado es profundo

