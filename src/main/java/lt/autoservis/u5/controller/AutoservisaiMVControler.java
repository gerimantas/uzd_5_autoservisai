package lt.autoservis.u5.controller;

import lt.autoservis.u5.model.entity.Autoservisai;
import lt.autoservis.u5.model.entity.Meistrai;
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
    String autoservisuPuslapis(Model model) {
        Autoservisai autoservisai = autoservisaiRepository.findById(1);
        model.addAttribute("pavadinimas", autoservisai.getPavadinimas());
        model.addAttribute("vadovas", autoservisai.getVadovas());
        model.addAttribute("autoservisoSpecializacija", autoservisai.getAutoservisoSpecializacija());
        model.addAttribute("autoservisoMeistrai", autoservisai.getAutoservisoMeistrai());
        model.addAttribute("autoservisoAdresas", autoservisai.getAutoservisoAdresas());
        return "testas_autoservisai.html";
    }

//    http://localhost:8080/test/autoservisai


}
