# Las funciones de definen de la siguiente manera ---> def <nombre funcion> (<parametros>):
# No se pueden pasar valores por referencia, solo las colecciones

def sumarNumeros(x, y):
    
    numero = x + y
    
    return numero
    
 
def sumarDefault(x = 5, y = 7):  # Se pueden poner valores por default para optar no poner argumentos
    
    numero = x+y
    
    return numero
    
def devuelveStr (palabra) -> str:  # Agrega una pista del tipo de valor que devuelve. No es obligatorio
    
    return palabra + " Mundo"

def arregloCambiado(array):  # Las estructuras de datos siempre se pasan por referencia
    array *= 3 
    

""" Argumentos Variables """  # Se desconoce la cantidad de argumentos que pueden ingresarse
   
def multiplicarNumeros (*numeros):  # El argumento se itera como si fuera una Tupla, ya que no se puede modificar, sino tomar sus valores
    
    result = 1
    
    for num in numeros:
        
        result *= num
    
    return result



""" Argumentos Variables Key-Value """

def listarTerminos (**terminos):  # El argumento se itera como si fuese un diccionario
    
    for llave, valor in terminos.items():
        print(f"{llave}: {valor}")
        

""" Funciones recursivas """


def calcularFactorial(numero):
    
    if (numero == 1):
        return numero
    else:
        return numero * calcularFactorial(numero-1)
    
    
    
def main():
    
    arreglo = [1,2,3,4]

    arregloCambiado(arreglo)

    num = sumarNumeros(5, 7)

    num2 = sumarDefault(x=7)  # Puedo cambiar el valor de la variable por default

    palabra = devuelveStr("Hola")

    print(num)
    print(num2)
    print(palabra)
    print(f"Arreglo cambiado: {arreglo}") 
    
    print(" Argumentos Variables ".center(50, "-"))
    
    print(multiplicarNumeros(1,2,3,4,5,6,7,8,9,10,11,12,13,15,16))
    
    print(" Argumentos Variables Key-Value ".center(50, "-"))

    listarTerminos(Edad= 24, Altura= 1.70 , Peso= 60)  # La Key no lleva comillas y puede ser cualquier tipo de datos

    print(" Funciones recursivas ".center(50, "-"))
    
    print(calcularFactorial(5))

if __name__ == "__main__":
    main()
