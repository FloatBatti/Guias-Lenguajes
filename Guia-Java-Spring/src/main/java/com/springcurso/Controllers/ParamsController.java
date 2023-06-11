package com.springcurso.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsController {

    @GetMapping("/")
    public String index() {
        return "params/index";
    }

    @GetMapping("/string")
    // @RequestParam permite recibir parámetros de la petición GET.
    public String param(@RequestParam String texto, Model model) {
        model.addAttribute("resultado", "El texto enviado es: " + texto);
        return "params/ver";
    }

    @GetMapping("/mix-params")
    // @RequestParam permite recibir parámetros de la petición GET.
    public String param(@RequestParam String texto, @RequestParam int numero, Model model) {
        model.addAttribute("resultado", "El texto enviado es: " +
                texto + " y el número enviado en el path es: " + numero);
        return "params/ver";
    }

    @GetMapping("/httpservlet")
    // @RequestParam permite recibir parámetros de la petición GET.
    public String param(HttpServletRequest request, Model model) {
        model.addAttribute("resultado", "El texto enviado es: " +
                request.getParameter("texto") +
                " y el número enviado en el path es: " +
                request.getParameter("numero"));
        return "params/ver";
    }
}
