package lt.autoservis.u5.controller;

import lt.autoservis.u5.model.entity.Vertinimas;
import lt.autoservis.u5.model.repository.MeistraiRepository;
import lt.autoservis.u5.model.repository.VartotojasRepository;
import lt.autoservis.u5.model.repository.VertinimasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VertinimasControler {

    @Autowired
    VertinimasRepository vertinimasRepository;

    @Autowired
    MeistraiRepository meistraiRepository;

    @Autowired
    VartotojasRepository vartotojasRepository;



    @GetMapping("/meistru/vertinimas/{id}")
    String meistruVertinimas(Model model) {
        Vertinimas vertinimas  = new Vertinimas();
        model.addAttribute("vertinimas", vertinimas);
        model.addAttribute("meistrai", meistraiRepository.findAll());
        return "ideti_vertinima.html";
    }

    @PostMapping("/idejo_vertinima")
    String pridetiVertinima(@ModelAttribute Vertinimas ivedamasVertinimas) {
        vertinimasRepository.save(ivedamasVertinimas);
        return "idetas_vertinimas.html";
    }

}


