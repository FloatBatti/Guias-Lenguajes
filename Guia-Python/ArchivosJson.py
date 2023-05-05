import json#Los Json guardan diccionarios, por ende los objetos tienen que ser transformados en estos
from SistemaHospital.Models.Consultorio import Consultorio 
from datetime import datetime
from SistemaHospital.Models.Doctor import Doctor
from SistemaHospital.Models.Paciente import Paciente
from SistemaHospital.Models.Turno import Turno
from Serializacion import *

fileName= "Data/Personas.json"
data=[]

consultorio1 = Consultorio(1, True)
doctor1 = Doctor("Pablo", "87654321","thebestdoctor@gmail.com", "2239874154", "Clinico")
turno1 = Turno("17/10/2022", doctor1, consultorio1)
paciente1 = Paciente("Cosme Fulanito", "12345678","mailfake@gmail.com", "2237654321", "00000789" , turno1)

"""
with open (fileName, "r", encoding="utf8") as archivo:
            
    contenido = archivo.read()
    jsonContent = json.loads(contenido)
    
    print(jsonContent[0])
    
    persona= Persona(
        
        jsonContent[0]["_nombre"],
        jsonContent[0]["_dni"],
        jsonContent[0]["_telefono"],
        jsonContent[0]["_mail"]
        
        )
    
    print(type(jsonContent))
    
    print(persona)
"""

#DES-SERIALIZACIÓN
with open (fileName, "r", encoding="utf8") as archivo:  # Lo abro en modo lectura
    
    try:
        data = json.load(archivo) #Mejor opcion para manipular. Devuelvo todo el json como una lista
        print(data)
        
    except:
        print("Archivo vacio")
        data=[]
    

#SERIALIZACIÓN  

with open (fileName, "w", encoding="utf8") as archivo:  # Lo abro en modo escritura

    objectDict = serializarPaciente(paciente1)  # Le doy formato de diccionario al objeto
      
    data.append(objectDict)# Agrego el objeto a la lista
    
    json.dump(data, archivo, indent= 4, separators=(", ", " : "))  # Cargo la lista nueva al Json, es decir, actualice mi archivo



    