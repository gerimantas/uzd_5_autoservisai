package lt.autoservis.u5.controller;

import lt.autoservis.u5.model.entity.Specializacija;
import lt.autoservis.u5.model.repository.SpecializacijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SpecializacijaMVControler {

    @Autowired
    SpecializacijaRepository specializacijaRepository;

    @GetMapping ("/test/visos_specializacijos")
    String rodytivisasSpecializacijas(Model model) {
        List<Specializacija> visosSpecializacijos = specializacijaRepository.findAll();
        model.addAttribute("visosSpecializacijos", visosSpecializacijos);
        return "visos_specializacijos.html";
    }


    @GetMapping ("/specializacija/rodyti_autoservisus")
    String rodytiAutoservisuSpecializacijas(Model model, @RequestParam long id) {
        Specializacija specializacija = specializacijaRepository.findById(id);
        model.addAttribute("specializacijaAutoserviso", specializacija.getSpecializacijaAutoserviso());
        model.addAttribute("specializacijosPavadinimas", specializacija.getPavadinimas());
        return "specializacijos_autoservisai.html";

    }



}

//       http://localhost:8080/test/visos_specializacijos

//       http://localhost:8080/specializacija/rodyti_autoservisus

//       http://localhost:8080/specializacija/rasti_autoservisus


