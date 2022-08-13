package lt.autoservis.u5.controller;

import lt.autoservis.u5.model.repository.VartotojasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VartotojasControler {

    @Autowired
    VartotojasRepository vartotojasRepository;

//    @GetMapping("test/greeting")
//    String testinisEndVartotojas() {
//        return  "puslapis veikia";
//    }
}
