package com.springcurso.Controllers;

import com.springcurso.Models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller // Esta anotación indica que esta clase es un controlador
@RequestMapping("/app") // Esta anotación indica que la ruta de este controlador será /app, por lo que
// para acceder a este controlador se debe anteponer /app a la ruta.
public class IndexController {

    @GetMapping({"/index", "/", "/home", "/app"}) // Esta anotación indica que este método se ejecutará
    // cuando se haga una petición GET a la ruta /index, / , /home o /app.
    // Model es una interfaz que permite pasar datos a la vista.
    // Este método se suele llamar handler.
    public String index(Model model) {
        model.addAttribute("titulo", "Guia Java Spring");
        return "index";
    }

    @RequestMapping(value = "/perfil", method = RequestMethod.GET) // Igual que @GetMapping
    public String perfil(Model model) {
        Usuario usuario = new Usuario("Juan", "Perez");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil de ".concat(usuario.getNombre()));
        return "perfil";
    }

    @RequestMapping("/lista") // Si no se especifica el método, por defecto es GET
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de usuarios");
        return "lista";
    }

    @ModelAttribute("usuarios") // Esta anotación permite pasar datos a la vista. Los métodos anotados con @ModelAttribute
    // se ejecutan antes que los métodos anotados con @RequestMapping. Los métodos deben retornar un objeto.
    public List<Usuario> poblarUsuarios() {
        return List.of(
                new Usuario("Juan", "Perez"),
                new Usuario("Pedro", "Gomez"),
                new Usuario("Maria", "Diaz"),
                new Usuario("Laura", "Gonzalez")
        );
    }
}
