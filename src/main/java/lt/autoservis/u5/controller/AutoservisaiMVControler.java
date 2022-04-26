package lt.autoservis.u5.controller;

import lt.autoservis.u5.model.entity.Autoservisai;
import lt.autoservis.u5.model.entity.Meistrai;
import lt.autoservis.u5.model.entity.Specializacija;
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

import java.util.List;

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

    @GetMapping ("/rodyti/visi_autoservisai")
    String rodytiAutoservisus(Model model) {
        List<Autoservisai> visiAutoservisai = autoservisaiRepository.findAll();
        model.addAttribute("visiAutoservisai", visiAutoservisai);
        return "visi_autoservisai.html";
    }

    @GetMapping ("/autoservisas/rodyti_specializacijas")
    String rodytiSpecializacijasAutoservisuose(Model model, @RequestParam long id) {
        Autoservisai autoservisas = autoservisaiRepository.findById(id);
        model.addAttribute("autoservisoSpecializacija", autoservisas.getAutoservisoSpecializacija());
        model.addAttribute("specializacijosPavadinimas", autoservisas.getPavadinimas());
        return "autoservisai_specializacijos.html";

    }



    @GetMapping("/autoservisas/idejimas")
    String pridetiAutoservisa(Model model) {
        Autoservisai autoservisas = new Autoservisai();
        model.addAttribute("autoservisai", autoservisas);
        model.addAttribute("specializacijos", specializacijaRepository.findAll());
        model.addAttribute("miestas", miestaiRepository.findAll());
        return "ideti_autoservisa.html";

    }

    @GetMapping("/autoservisas/redagavimas")
    String autoservisoRedagavimas(Model model){
        Autoservisai autoservisas = autoservisaiRepository.findById(1);
        model.addAttribute("autoservisai", autoservisas);
        model.addAttribute("specializacijos", specializacijaRepository.findAll());
        model.addAttribute("miestas", miestaiRepository.findAll());
        return "autoserviso_redagavimas.html";

    }

    @PostMapping("/ideti/idejo_autoservisa")
    String pridetiAutoservisa(@ModelAttribute Autoservisai ivedamasAutoservisas) {
        autoservisaiRepository.save(ivedamasAutoservisas);
        return "idetas_autoservisas.html";
    }



//    http://localhost:8080/rodyti/visi_autoservisai

//    http://localhost:8080/autoservisas/idejimas
//    http://localhost:8080/autoservisas/redagavimas




}
