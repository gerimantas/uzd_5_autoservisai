package lt.autoservis.u5.controller;

import lt.autoservis.u5.model.repository.AdresaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdresaiControler {
    @Autowired
    AdresaiRepository adresasRepository;

    @GetMapping("/test/adreasai")
    String testinisAdresai() {
        return "puslapis veikia";
    }
}
