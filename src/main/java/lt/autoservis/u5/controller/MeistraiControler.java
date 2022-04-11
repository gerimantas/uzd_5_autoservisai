package lt.autoservis.u5.controller;


import lt.autoservis.u5.model.entity.Meistrai;
import lt.autoservis.u5.model.repository.MeistraiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeistraiControler {

    @Autowired
    MeistraiRepository meistrasRepository;

    @GetMapping("test?greeting")
    String testinisEndpoint() {
        return "sis puslapis veikia";
    }

//    @GetMapping("/meistrai/visi")
//    Meistrai gautiMeistrus (@RequestParam String vardas_pavarde){
//        Meistrai meistrai = meistrasRepository.findByspecializacijaMeistro(vardas_pavarde);
//        return meistrai;

//    }
}
