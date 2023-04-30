# El ciclo for se declara de la siguiente manera ---> for <control var> in range (<inicio>, <fin>)
# La variable de control va tomando los valores de los numeros dentro del rango, ya se de forma incremental o al revez

for i in range(4):  # Range es una funcion que se utiliza para obtener una secuencia de numeros enteros
    print(i)    # Si se pone un solo valor en range, la secuencia empieza de cero y termina en fin-1, es decir 3
                
print("----------------------------")

for i in range(5, 10):  # Si se ponen dos valores se interpreta el primero como numero de inicio
    print(i)
            
print("----------------------------")

for i in range(0, 10, 2):  # Podemos agregar un tercer parametro que indica el paso. Por defecto es 1
    print(i)

# Otro tipo de ciclo for ---> for <control var> in <itreable>. Los iterables son strings, listas, tuplas, diccionarios, etc.

print("----------------------------")

for i in range(0, 10):
    if i % 2 != 0:
        continue  #  Evita que se ejecute el codigo que le sigue, saltando a la siguiente iteracion
    print(i)

print("----------------------------")

for char in "Agustin":  # Va iterando la posición del string
    print(char)

print("----------------------------")

for num in [5, 6, 7, 8]:  # Va iterando la posición del arreglo
    print(num)

print("----------------------------")

print("Tupla toda junta: ", end="")# Con end indico que va a haber al final de la instruccion print, por default hay un '\n' (salto de linea)
 
for num in (1,2,3):
   
    print(f"{num} - ", end="") 

print("\n----------------------------")

# El ciclo for para los diccionarios cambia
# Se puede iterar sobre las claves, valores o por los pares

dicc = {"age": 35, "name": "Juan"}

for dato in dicc.keys():  # Va iterando sobre las claves del diccionario
    print(dato)

print("----------------------------")
    
for persona in dicc.values():  # Va iterando sobre los valores del diccionario
    print(persona)

print("----------------------------")
         
for dato, persona in dicc.items():  # Va iterando sobre los pares del diccionario
    print(f"{dato} : {persona}")    # Primero va la clave y luego el valor


# El ciclo while se declara de la siguiente manera ---> while <condition>

x = 20

while x < 35:
    print(x)
    x += 2
    
frase = "Quiero dormir"
letra = iter(frase)  # Crea un iterador de el string indicado


print(letra.__next__())
print(letra.__next__())
print(letra.__next__())

