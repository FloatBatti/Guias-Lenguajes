# El caracter '*' sirve para empaquetar y desempaquetar elementos

valores = 1,2,3  # Se empaquetan los datos en un tupla

print(type(valores))

valor1, valor2, valor3 = 1, 2, 3
print(valor1, valor2, valor3, sep=" - ")

valor1, valor2, *valor3 = 1, 2, 3, 4, 5, 6, 7, 8, 9, 10  # la variable con aterisco toma todos los valores restantes y los empaqueta en una lista
print(valor1, valor2, valor3, sep=" - ")

valor1, valor2, *valor3, valor4, valor5 = 1, 2, 3, 4, 5, 6, 7, 8, 9, 10  # la variable con aterisco toma todos los valores restantes pero deja disponible la cantidad exacta para los que la siguen
print(valor1, valor2, valor3, valor4, valor5, sep=" - ")

lista= [1,2,3]
lista2= [4,5,6]
a,b,c = lista  # Se desempaqueta

print(*lista, sep=" - ")  # Desempaqueta cada elemento de la lista 

print(a,b,c, sep= " ")

print(f"Nueva lista unificada{[*lista, *lista2]}")
