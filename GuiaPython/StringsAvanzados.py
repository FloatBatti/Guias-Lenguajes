# RECORDEMOS: Los Strings son Inmutables, es decir, cuando devolvemos un String formateado por un método, la variable que lo almacena, apunta a otra direccion de memoria. No se cambia el String original, sino que se crea uno nuevo


nombre = "Agustin"
myStr = "Este es un curso de Python"
stripp = "       Soy un Texto #&$ "
edad = 24
flotante = 57.14542454714514
dicc = {"Nombre" : "Juan", "Edad" : "35", "Sueldo" : 20000.0508}

""" VER EN EL MODULO ArchivosWith.py EL USO DEL METODO COUNT"""

print(" Metodo Join ".center(50, "-"))
nuevoString = " <delimitador> ".join([myStr, nombre])  # El caracter entre comillas indica el delimitador. El metodo recibe un iterable como parametro, por eso creamos una lista poniendo los corchetes

print(nuevoString, " de tipo ", type(nuevoString))

print(" Metodo Split ".center(50, "-"))

print("String hecho un arreglo: ", nuevoString.split(" ") ) # Devuelve el String hecho un arreglo/lista

print("Cantidad de elementos de nuevoString: ", len(nuevoString.split(" ")))

print(nuevoString.split(" ", 4))  # El primer parametro indica el elemento separador que se toma como referencia para tomar los grupos de elementos y el segundo, el numero de grupos que son tomados empezando por el indice 0.

print("Cantidad de elementos de nuevoString: ", len(nuevoString.split(" ", 4)))

print(" Metodo Strip ".center(50, "-"))

print(stripp.strip())  # Este método nos permite eliminar espacios al inicio y al final de la cadena de texto, y los caracteres especiales
print(stripp.strip("o # & $"))

print(" Formato de str con parametros posicionales ".center(75, "-"))

print("Mi nombre es %s, tengo %i y esto es un numero flotante %.3f" %(nombre, edad, flotante))

print(" Metodo Format ".center(75, "-"))

print("Hello, my name is {}, I'm {} years old and this is a float number: {:.3f}".format(nombre,edad,flotante))  # Se imprime con el orden de aparición que le damos en los parametros de format

print("I'm {1} years old, this is a float number: {2:.3f} and my name is {0}".format(nombre,edad,flotante))  # Se utiliza el indice como si fuese un arreglo 

print("This is a float number: {a:.3f}, my name is {b} and I'm {c} years old".format(b=nombre, c=edad, a=flotante))


""" Metodo format en Diccionarios """

print(" Metodo format en Diccionarios ".center(75, "-"))

print("Nombre: {persona[Nombre]}, Edad: {persona[Edad]}, Sueldo: {persona[Sueldo]: .2f}".format(persona = dicc))  # Indicamos que se toma como persona al diccionario que definimos

