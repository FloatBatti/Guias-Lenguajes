package com.agusbatti.repoGenerico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.agusbatti.clases.Persona;

import com.agusbatti.interfaces.IRepository;

public class PersonaRepo implements IRepository<Persona>{

    List<Persona> personaList = new ArrayList<Persona>();

    @Override
    public List<Persona> listar() {

        return this.personaList;
    }

    @Override
    public Persona devolverPorId(Integer dni) {

        Persona persona = null;

        for (Persona aux : this.personaList) {
            
            if(aux.getId() == dni){

                persona = aux;

            }
        }

        return persona;
    }

    @Override
    public void crear() {
        
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese su nombre: ");
        String nombre = scan.nextLine();

        System.out.println("Ingrese su apellido: ");
        String apellido= scan.nextLine();

        System.out.println("Ingrese su DNI: ");
        String dni= scan.nextLine();

        System.out.println("Ingrese su ciudad: ");
        String ciudad= scan.nextLine();

        System.out.println("Ingrese su cantidad de mascotas: ");
        Integer mascotas= Integer.parseInt(scan.nextLine());

        scan.close();

        Persona persona = new Persona(nombre, apellido, dni, ciudad, mascotas);

        this.personaList.add(persona);

    }

    @Override
    public void editar(Integer id) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese su nombre: ");
        String nombre = scan.nextLine();

        System.out.println("Ingrese su apellido: ");
        String apellido= scan.nextLine();

        System.out.println("Ingrese su DNI: ");
        String dni= scan.nextLine();

        System.out.println("Ingrese su ciudad: ");
        String ciudad= scan.nextLine();

        scan.close();

        for (Persona aux : this.personaList) {
            
            if(aux.getId() == id){

                aux.setNombre(nombre);
                aux.setApellido(apellido);
                aux.setDni(dni);
                aux.setCiudad(ciudad);

            }
        }


 
    }

    @Override
    public void eliminar() {
        
    }
    

}
