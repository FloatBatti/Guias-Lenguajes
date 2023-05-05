# Las clases mas especificas van arriba y la general abajo del todo. Si se pone arriba del todo se van a ignorar las excepciones contiguas

from ErrorFicticio import*

resultado = None
a = int (input("Ingrese un numero : "))
b = int (input("Ingrese otro numero : "))

try:
           
    verificarNumero(a)
    verificarNumero(b)
    
    resultado = a/b
    
except ZeroDivisionError as e:  # 'e' es la variable que guarda la exception (es un objeto)
    
    print(f"Error '{e}' capturado. No se puede dividir por cero")

except TypeError as e:
    
    print(f"Error {e} capturado. Los Strings no pueden ser operados aritmeticamente")

except NumeroNegativo as e:
    
    print("Se ingreso un numero negativo")
    
else:
    
    print("No se capturo ninguna exception")
    
finally: # Este bloque siempre se ejecuta. Es lo que ocurre luego del try-catch, haya error o no
    print("Se termino el bloque Try-Catch")
 
    
print(f"Resultado: {resultado}")
print(f"Continuamos . . .")


def verificarNumero(num):
    
    if num < 0:
        raise NumeroNegativo("Numeros identicos")  # Arroja una execption si ocurre una condicion