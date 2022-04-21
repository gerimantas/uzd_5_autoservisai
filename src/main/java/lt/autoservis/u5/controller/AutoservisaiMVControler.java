package lt.autoservis.u5.controller;

import lt.autoservis.u5.model.entity.Autoservisai;
import lt.autoservis.u5.model.entity.Meistrai;
import lt.autoservis.u5.model.repository.AutoservisaiRepository;
import lt.autoservis.u5.model.repository.MiestaiRepository;
import lt.autoservis.u5.model.repository.SpecializacijaRepository;
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

    @Autowired
    SpecializacijaRepository specializacijaRepository;

    @Autowired
    MiestaiRepository miestaiRepository;





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
        model.addAttribute("specializacija", specializacijaRepository.findAll());
        model.addAttribute("miestai", miestaiRepository.findAll());
        return "ideti_autoservisa.html";

    }

    @GetMapping("/autoservisas/redagavimas")
    String autoservisoRedagavimas(Model model){
        Autoservisai autoservisas = autoservisaiRepository.findById(1);
        model.addAttribute("autoservisai", autoservisas);
        model.addAttribute("specialist", specializacijaRepository.findAll());
        model.addAttribute("miestai", miestaiRepository.findAll());
        return "autoserviso_redagavimas.html";

    }

    @PostMapping("/ideti/idejo_autoservisa")
    String pridetiAutoservisa(@ModelAttribute Autoservisai ivedamasAutoservisas) {
        autoservisaiRepository.save(ivedamasAutoservisas);
        return "idetas_autoservisas.html";
    }





//    http://localhost:8080/autoservisas/idejimas
//    http://localhost:8080/autoservisas/redagavimas




}
