package lt.autoservis.u5.controller;

import lt.autoservis.u5.model.entity.Autoservisai;
import lt.autoservis.u5.model.repository.AutoservisaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AutoservisaiMVControler {

    @Autowired
    AutoservisaiRepository autoservisaiRepository;


    @GetMapping("/test/autoservisai")
    String autoservisuPuslapis(Model model, @RequestParam String pavadinimas) {
        Autoservisai autoservisai = autoservisaiRepository.findByPavadinimas(pavadinimas);
        model.addAttribute("pavadinimas", autoservisai.getPavadinimas());
        return "testas_autoservisai.html";
    }

//    http://localhost:8080//test/autoservisai


}
