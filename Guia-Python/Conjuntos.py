# Un conjunto es una colección no ordenada de cero o más objetos de datos de Python inmutables. Los conjuntos no permiten duplicaciones y se escriben como valores delimitados por comas encerrados entre llaves. Los conjuntos nos son secuenciales. Un conjunto vacio (sin elementos) se expresa como "set()"

conjunto = {3, 6, 5, "gato", "python", 4.5, False}  # Puede ser heterogeneo

otroConjunto = {2, 4, 5, "perro", "python", 3.5, True}

print(3 in conjunto)  # Devuelve true si el elemento esta en el conjunto o false de lo contrario
print(len(conjunto))  # Devuelve la cantidad de elementos del conjunto

print(conjunto | otroConjunto)  # Devuelve un nuevo conjunto con la union de los conjuntos

print(conjunto & otroConjunto)  # Devuelve un nuevo conjunto con la interseccion de los conjuntos

print(conjunto - otroConjunto)  # Devuelve un nuevo conjunto con todos los ítems del primer conjunto que no están en
# el segundo (diferencia)

print(conjunto <= otroConjunto)  # Evalua si todos los elementos del primer conjunto están en el segundo

print("Operaciones con Conjuntos".center(70, "-"))

""" Se puden realizar operaciones de conjuntos con metodos realacionados a las matematicas """

print(conjunto.union(otroConjunto))  # Union

print(conjunto.intersection(otroConjunto))  # Interseccion

print(conjunto.difference(otroConjunto))  # Diferencia

conjunto.add(42)  # Agrega un elemento al conjunto
print(conjunto)

conjunto.remove(42)  # Elimina un elemento al conjunto
print(conjunto)

conjunto.pop()  # Elimina un elemento de forma arbitraria, ya que no es secuencial
print(conjunto)

conjunto.clear()  # Elimina todos los elementos del conjunto
print(conjunto)
