package lt.autoservis.u5.controller;


import lt.autoservis.u5.model.entity.Meistrai;
import lt.autoservis.u5.model.repository.AutoservisaiRepository;
import lt.autoservis.u5.model.repository.MeistraiRepository;
import lt.autoservis.u5.model.repository.SpecializacijaRepository;
import lt.autoservis.u5.model.repository.VertinimasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        Meistrai meistras = meistraiRepository.findById(id);
        model.addAttribute("vardas_pavarde", meistras.getVardas_pavarde());
        model.addAttribute("specializacijaMeistro", meistras.getSpecializacijaMeistro());
        model.addAttribute("meistroVertinimas", meistras.getMeistroVertinimas());
        model.addAttribute("meistroAutoservisas", meistras.getMeistroAutoservisas());
        return "duomenys_meistrai.html";

    }


}

//       http://localhost:8080/meistrai/visi_meistrai