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


    @GetMapping("/th/rec/ideti")
    String autoservisoIdejimoPuslapis(Model model, @RequestParam String autoservisai) {
        Autoservisai autoservisai = new Autoservisai();
        model.addAttribute("autoservisai", autoservisai);
        return "ideti autoservisa.html";
    }

//    http://localhost:8080/th/rec/ideti


}
