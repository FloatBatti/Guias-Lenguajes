# Para abrir un archivo y luego cerrarlo automaticamente se usa la sentencia with
# Se declara de la siguiente manera ---> with open("<nombre del archivo>.text", "<modo>") as <variablearchivo>:


arreglo = [1, 2, 3, 4]
nombre = "Agus"

""" ABRIMOS Y ESCRIBIMOS UN ARCHIVO """

try:
    
    archivo = open("Archivo.txt", "w", encoding="utf8")  # El ultimo parametro hace que se acepten acentos
    archivo.write("Hola, soy un archivo \n")
    archivo.write("Estoy programando en Python")

except Exception as e:
    
    print(e)
    
finally:
    
    archivo.close()
    
    
""" ABRIMOS Y ESCRIBIMOS UN ARCHIVO SIN SOBREESCRIBIR"""
    
try:
    
    archivo = open("Archivo.txt", "a", encoding="utf8")  # El ultimo parametro hace que se acepten acentos
    archivo.write("Gracias por no borrarme")

except Exception as e:
    
    print(e)
    
finally:
    
    archivo.close()



""" ABRIMOS Y LEEMOS UN ARCHIVO """

print("Se abre y lee un archivo con .read()".center(50, "-"))

try:
    
    archivo = open("Archivo.txt", "r", encoding="utf8")

    string = archivo.read()  # Se puede poner como parametro la cantidad de caracteres a leer, sino lee todo el texto
    
    print(string)

except Exception as e:
    
    print(e)
    
finally:
        
    archivo.close()
    

print("Se abre y lee archivo con .readline()".center(70, "-"))

try:
    
    archivo = open("Archivo.txt", "r", encoding="utf8")

    string = (archivo.readline())  # Lee una sola linea.
    
    print(string)

except Exception as e:
    
    print(e)
    
finally:
    
    archivo.close()


print("Se abre y lee un archivo con .readlines()".center(70, "-"))

try:
    
    archivo = open("Archivo.txt", "r", encoding="utf8")

    listString = archivo.readlines()  # Lee todas las lineas y devuelve una lista con ellas
    
    print(listString)
    print(type(listString))


except Exception as e:
    
    print(e)
    
finally:
    
    archivo.close()

print("Se abre y lee un archivo con .readlines()[<indice>]".center(70, "-"))

try:
    
    archivo = open("Archivo.txt", "r", encoding="utf8")

    list2 = archivo.readlines()[1]  # Lee la linea en la posicion que le indicamos (arriba del todo es el indice 0). Tambien lo devulve como lista
    
    print(list2)
    print(type(list2))
    

except Exception as e:
    
    print(e)
    
finally:
    
    archivo.close()
