package com.agusbatti.repoGenerico;

import java.util.ArrayList;
import java.util.List;

import com.agusbatti.clases.Mascota;

public class Cuidador<T extends Mascota> {  // Extiendo de mascota para heredar sus métodos 
    
    private List<T> enEspera = new ArrayList<>();
    
    public Cuidador(){}

    public void cuidar(T mascota){

        System.out.println("La mascota " + mascota.getNombre() + " se está cuidando");
    }

    public void agregarEspera(T mascota){

        this.enEspera.add(mascota);
        System.out.println(mascota.getNombre() + " se agregó a la lista de espera");
    }

}
