package com.agusbatti.anotaciones;

import java.lang.annotation.*;


@Target({ElementType.FIELD, ElementType.METHOD})
//@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER, ElementType.CONSTRUCTOR})

// FIELD indica que la anotación se puede aplicar sobre un atributo.
// METHOD indica que la anotación se puede aplicar sobre un método.
// TYPE indica que la anotación se puede aplicar sobre una clase.
// PARAMETER indica que la anotación se puede aplicar sobre un parámetro.
// CONSTRUCTOR indica que la anotación se puede aplicar sobre un constructor.

// Solo puede haber una anotación de tipo Retention por anotación.
@Retention(RetentionPolicy.RUNTIME) // Indica que la anotación se puede utilizar en tiempo de ejecución.
//@Retention(RetentionPolicy.CLASS) // Indica que la anotación se puede utilizar en tiempo de compilación.
//@Retention(RetentionPolicy.SOURCE) // Indica que la anotación se puede utilizar en tiempo de desarrollo.

@Inherited // Indica que la anotación se puede heredar a las subclases.
@Documented // Indica que la anotación se puede documentar.

public @interface Anotaciones { // Es es una forma de agregar metadatos a una clase, método, variable u otra estructura
                                // del programa. Estos metadatos proporcionan información adicional que puede ser
                                // utilizada por herramientas de desarrollo, frameworks y bibliotecas para generar código,
                                // aplicar restricciones de tiempo de ejecución o realizar otras tareas.
                                // Es una alernativa a usar XML para la configuración de metadatos.
                                // Las anotaciones pueden tener atributos, los cuales se definen como métodos sin cuerpo.

    String nombre() default "Sin anotación"; // Indica que el atributo nombre, por defecto, es "".
    boolean capitalizar() default false; // Indica que el atributo capitalizar, por defecto, es false.

}
