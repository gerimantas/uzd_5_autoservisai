package lt.autoservis.u5.controller;

import lt.autoservis.u5.model.entity.Adresai;
import lt.autoservis.u5.model.entity.Autoservisai;
import lt.autoservis.u5.model.entity.Meistrai;
import lt.autoservis.u5.model.entity.Specializacija;
import lt.autoservis.u5.model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AutoservisaiMVControler {

    @Autowired
    AutoservisaiRepository autoservisaiRepository;

    @Autowired
    SpecializacijaRepository specializacijaRepository;

    @Autowired
    MiestaiRepository miestaiRepository;

    @Autowired
    AdresaiRepository adresaiRepository;

    @Autowired
    TelefonaiRepository telefonaiRepository;

    @Autowired
    MeistraiRepository meistraiRepository;



    @GetMapping("/duomenys/autoservisai")
    String autoservisuDuomenys(Model model, @RequestParam long id) {
        Autoservisai autoservisai = autoservisaiRepository.findById(id);
        model.addAttribute("id", autoservisai.getId());
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

    @GetMapping("/autoservisas/redagavimas/{id}")
    String redaguotiAutoservisa(Model model, @PathVariable long id) {
        Autoservisai autoservisas = autoservisaiRepository.findById(id);
        model.addAttribute("autoservisai", autoservisas);
        model.addAttribute("specializacijos", specializacijaRepository.findAll());
        model.addAttribute("meistrai", meistraiRepository.findAll());
        model.addAttribute("miestai", miestaiRepository.findAll());
        model.addAttribute("adresai", adresaiRepository.findAll());
        model.addAttribute("telefonai", telefonaiRepository.findAll());
        return "autoserviso_redagavimas.html";

    }

    @PostMapping("/redagavo_autoservisa")
    String redaguotiAutoservisa(@ModelAttribute Autoservisai redaguojamasAutoservisas) {
        autoservisaiRepository.save(redaguojamasAutoservisas);
        return "redaguotas_autoservisas.html";
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
