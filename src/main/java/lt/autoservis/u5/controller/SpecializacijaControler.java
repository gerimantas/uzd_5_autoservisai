package lt.autoservis.u5.controller;

import lt.autoservis.u5.model.entity.Specializacija;
import lt.autoservis.u5.model.repository.SpecializacijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpecializacijaControler {

    @Autowired
    SpecializacijaRepository specializacijaRepository;

    @PostMapping ("/specializacija/ideti")
    String idetiSpecializacija(String pavadinimas) {
        Specializacija naujaSpecializacija = new Specializacija();
        naujaSpecializacija.setSpecializacijaAutoserviso(pavadinimas);
        specializacijaRepository.save(naujaSpecializacija);
        return "Specializacija" + pavadinimas + "sekmingai ideta";
    }





    @GetMapping ("/gauti/specializacija")
    String kazkokiaSpec() {return "kazkokiaSpec";}

}
