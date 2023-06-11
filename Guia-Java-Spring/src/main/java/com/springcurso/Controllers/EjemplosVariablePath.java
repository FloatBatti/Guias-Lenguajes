package com.springcurso.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemplosVariablePath {

    @GetMapping("/string/{texto}") // {texto} es una variable de path, se puede cambiar por cualquier nombre.
    // El nombre de la variable de path debe ser el mismo que se pasa en el @PathVariable. Pasa lo mismo con
    // la notación @RequestParam. Si la variable del patch es igual que el parámetro del método, no es necesario
    // poner el name en @PathVariable.
    // La diferencia entre un path variable y un request
    public String variables(@PathVariable(name="texto") String text, Model model) {
        model.addAttribute("titulo", "Recibir parámetros de la ruta (@PathVariable)");
        model.addAttribute("resultado", "El texto enviado en la ruta es: " + text);
        return "variables/ver";
    }
}
