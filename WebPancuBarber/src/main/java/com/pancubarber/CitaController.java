package com.pancubarber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
public class CitaController {

    @Autowired
    private CitaRepository repository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("cita", new Cita());
        return "index";
    }

    @PostMapping("/agendar")
    public String agendarCita(@ModelAttribute Cita cita, Model model) {
        repository.save(cita);
        
        long totalCortes = repository.countByTelefono(cita.getTelefono());
        boolean esGratis = (totalCortes % 4 == 0);
        String premioMsg = esGratis ? "¡ESTE CORTE ES GRATIS!" : "Llevas " + (totalCortes % 4) + " de 4 para tu premio.";

        // Link de WhatsApp con el servicio seleccionado
        String msj = "¡Hola Luis! Soy " + cita.getNombre() + ". Confirmo mi cita para: " + cita.getServicio() + 
                     " el " + cita.getFecha() + " a las " + cita.getHora();
        String linkWa = "https://wa.me/50664007766?text=" + URLEncoder.encode(msj, StandardCharsets.UTF_8);

        model.addAttribute("cortes", totalCortes);
        model.addAttribute("premio", premioMsg);
        model.addAttribute("esGratis", esGratis);
        model.addAttribute("linkWa", linkWa);
        
        return "resultado";
    }
}