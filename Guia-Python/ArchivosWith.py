from urllib.request import urlopen
from logging import Manager
from traceback import print_tb

from ClaseManejoArchivos import ManejoArchivos


""" MANEJO DE CONTEXTO WITH """

print("Se abre y lee archivo utilizando with".center(70, "-"))


with open ("Archivo.txt", "r", encoding="utf8") as archivo:  # With abre y cierra de forma automatica el archivo. No hace falta el poner un bloque Try-Catch

#Archivo puede funcionar como un iterable, cuyas posiciones indican una linea de texto

    print(archivo.read())
    
# Esta operacion hace uso de los metodos __enter__ (cuando se abre) y __exit__ (cuando se cierra). Ambos se pueden sobreescribir y personalizar 


""" UTILIZANDO LA CLASE PERSONALIZADA """

print("Se abre y lee archivo utilizando Context Manager".center(70, "-"))

with ManejoArchivos("Archivo.txt") as archivo:
    
    print(archivo.read())
    
    

""" RECIBIR INFORMACION LA WEB Y DARLE FORMATO UTF """

print("Se recibe la informacion de un sitio web y se le da formato utf-8".center(70, "-"))

with urlopen ("https://docs.python.org/3/") as mensaje: 
    
    contenido = str(mensaje.read().decode('utf-8')) # Al codificarlo en utf-8 se le da un formato sin errores ni caracteres extraños
    
    print(contenido)
    
    print(f"Veces que aparace 'div': {contenido.count('div')}")  # Me devuelve la cantidad de veces que aparace el string "div"