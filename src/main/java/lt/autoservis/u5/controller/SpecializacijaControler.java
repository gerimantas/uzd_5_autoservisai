package lt.autoservis.u5.controller;

import lt.autoservis.u5.model.entity.Specializacija;
import lt.autoservis.u5.model.repository.SpecializacijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SpecializacijaControler {

    @Autowired
    SpecializacijaRepository specializacijaRepository;

    @PostMapping ("/specializacija/ideti")
    String idetiSpecializacija(@RequestBody Specializacija naujaSpecializacija) {
//        Specializacija naujaSpecializacija = new Specializacija();
//        naujaSpecializacija.setPavadinimas(pavadinimas);
        specializacijaRepository.save(naujaSpecializacija);
        return "sekmingai ideta";
    }





    @GetMapping ("/gauti/specializacija")
    String kazkokiaSpec() {return "kazkokiaSpec";}

}
