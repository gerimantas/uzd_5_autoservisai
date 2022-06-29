package lt.autoservis.u5.controller;

import lt.autoservis.u5.model.entity.Autoservisai;
import lt.autoservis.u5.model.repository.AutoservisaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


    @RestController
    public class AutoservisaiController {

        @Autowired
        AutoservisaiRepository autoservisasRepository;

        @GetMapping("/test/greeting")
        String testinisEndpoint() {
            return "šis puslapis veikia";
        }

        @GetMapping("/autoservisai/visi")
        Autoservisai gautiPagalPavadinima (@RequestParam String pavadinimas){
            Autoservisai autoservisai = autoservisasRepository.findByPavadinimas(pavadinimas);
            return autoservisai;

        }

//        @GetMapping("/superadmin/vienas")
//        @GetMapping("/superadmin/kazkoks/kitas")
//        @GetMapping("/superadmin/meistras/add")
//        @GetMapping("/superadmin/meistras/delet")


}
