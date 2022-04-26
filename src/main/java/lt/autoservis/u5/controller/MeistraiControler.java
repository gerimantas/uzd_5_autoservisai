package lt.autoservis.u5.controller;


import lt.autoservis.u5.model.entity.Autoservisai;
import lt.autoservis.u5.model.entity.Meistrai;
import lt.autoservis.u5.model.entity.Specializacija;
import lt.autoservis.u5.model.repository.AutoservisaiRepository;
import lt.autoservis.u5.model.repository.MeistraiRepository;
import lt.autoservis.u5.model.repository.SpecializacijaRepository;
import lt.autoservis.u5.model.repository.VertinimasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class MeistraiControler {

    @Autowired
    MeistraiRepository meistraiRepository;

    @Autowired
    SpecializacijaRepository specializacijaRepository;

    @Autowired
    AutoservisaiRepository autoservisaiRepository;

    @Autowired
    VertinimasRepository vertinimasRepository;



    @GetMapping ("/meistrai/visi_meistrai")
    String rodytiVisusMeistrus(Model model) {
        List<Meistrai> visiMeistrai = meistraiRepository.findAll();
        model.addAttribute("visiMeistrai", visiMeistrai);
        return "visi_meistrai.html";
    }

    @GetMapping("/duomenys/meistrai")
    String meistruDuomenys(Model model, @RequestParam long id) {
        Meistrai meistrai = meistraiRepository.findById(id);
        model.addAttribute("vardas_pavarde", meistrai.getVardas_pavarde());
        model.addAttribute("specializacijaMeistro", meistrai.getSpecializacijaMeistro());
//        model.addAttribute("autoservisoMeistrai", meistrai.getAutoservisoMeistrai());
        model.addAttribute("meistroVertinimas", meistrai.getMeistroVertinimas());
        return "duomenys_meistrai.html";
    }



}

//       http://localhost:8080/meistrai/visi_meistrai