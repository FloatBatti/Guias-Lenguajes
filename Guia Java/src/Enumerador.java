public enum Enumerador {    // Enumerador es una clase especial que solo puede tener constantes.
                            // Cada constante es un objeto (instancia) de la clase Enumerador.
                            // Se usa para agrupar constantes que tienen algo en común.
                            // Las constantes se escriben en mayúscula y separadas por guiones bajos.
                            // Se puede agregar atributos a cada constante.
                            // Se puede agregar métodos a cada constante.
                            // Un tipo enumerado puede ser declarado dentro o fuera de una clase, pero no dentro de
                            // un método.


    MDP("Mar del Plata", "593.337"),
    BSAS("Buenos Aires", "3.075.646"),
    PIN("Pinamar", "25.397"),
    NEC("Necochea", "92.933"),
    MARCHI("Mar Chiquita", "487"),
    MIR("Miramar", "29.433 ");

    private final String ciudad;  // Acá se guarda el atributo de cada constante
    private final String habitantes;

    // Como cada constante es una isntancia de la clase Enumerador, se puede agregar un constructor
    // para que incialice dicha instancia.
    // Si no se crea un constructor, el compilador crea uno por defecto que no recibe parámetros.

    Enumerador(String ciudad, String habitantes) {  // Por defecto, el constructor es privado.

        this.ciudad = ciudad;
        this.habitantes = habitantes;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getHabitantes() {
        return habitantes;
    }

    @Override
    public String toString() {
        return ciudad + ", habitantes: " + habitantes;
    }


}
