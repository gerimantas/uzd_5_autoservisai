package lt.autoservis.u5.controller;

import lt.autoservis.u5.model.entity.Autoservisai;
import lt.autoservis.u5.model.entity.Meistrai;
import lt.autoservis.u5.model.repository.AutoservisaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AutoservisaiMVControler {

    @Autowired
    AutoservisaiRepository autoservisaiRepository;




    @GetMapping("/duomenys/autoservisai")
    String autoservisuDuomenys(Model model, @RequestParam long id) {
        Autoservisai autoservisai = autoservisaiRepository.findById(id);
        model.addAttribute("pavadinimas", autoservisai.getPavadinimas());
        model.addAttribute("vadovas", autoservisai.getVadovas());
        model.addAttribute("autoservisoSpecializacija", autoservisai.getAutoservisoSpecializacija());
        model.addAttribute("autoservisoMeistrai", autoservisai.getAutoservisoMeistrai());
        model.addAttribute("autoservisoTelefonas", autoservisai.getAutoservisoTelefonas());
        model.addAttribute("autoservisoMiestas", autoservisai.getAutoservisoMiestas());
        model.addAttribute("autoservisoAdresas", autoservisai.getAutoservisoAdresas());
        return "duomenys_autoservisai.html";
    }

//    @GetMapping("/ideti/autoservisa")
//    String autoservisoIdojimas(Model model) {
//
//        return "ideti_autoservisa.html";
//    }

    @GetMapping("/autoservisas/idejimas")
    String autoservisoIdejimas(Model model){
        Autoservisai autoservisas = new Autoservisai();
        model.addAttribute("autoservisai", autoservisas);
        return "ideti_autoservisa.html";

    }

    @PostMapping("/ideti/idejo_autoservisa")
    String pridetiAutoservisa(@ModelAttribute Autoservisai ivedamasAutoservisas) {
        autoservisaiRepository.save(ivedamasAutoservisas);
        return "idetas_autoservisas.html";
    }





//    http://localhost:8080/autoservisas/idejimas




}
