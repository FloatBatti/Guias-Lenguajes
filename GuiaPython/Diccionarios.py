# El identificador apunta a cada Key y esta accede a su Value (valor). No hay indices, solo claves

dicc = {"age": 35, "name": "Juan"}  # Crea un diccionario. "clave (key)": valor (value)

dicc = dict(age = 35, name="Juan")

print(dicc)

print(dicc["age"])  # Devuelve el valor de la clave elegida. <diccionario>[<clave>]

print(dicc.get("name"))  # Devuelve el valor de la clave elegida. <diccionario>.get(<clave>)

print(dicc.get("nombre", "nada"))  # Devuelve el valor de la clave elegida. Si no se encuentra devuelve el otro valor ingresado como parametro

dicc["age"] = 40  # Cambio el valor de una clave

dicc["altura"] = 1.71  # Si no existe la clave se crea una nueva con su respectivo valor

dicc["peso"] = 90

print(f"El nuevo diccionario: {dicc}")

dicc.pop("peso")  # Se borra la clave

del dicc["altura"]  # Otra forma de borrar una clave

print("name esta en dicc?", "name" in dicc)  # Devuelve True o false si una clave se encuentra en el diccionario

print(dicc.keys())  # Devuelve las claves del diccionario

print(dicc.values())  # Devuelve los valores del diccionario

print(dicc.items())  # Devuelve las parejas clave-valor del diccionario

dicc2 = {"age":24}

dicc.update(dicc2)  # Actualiza los datos del diccionario teniendo en cuenta los elementos del que es pasado como parametro. La clave tiene que ser la misma

print(dicc)

dicc.clear()  # Vacia el diccionario

del dicc  # Elimina la variable de la memoria

