package lt.autoservis.u5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestinisControler {

    @GetMapping("/test/sveikinimas")
    String testineFunkcija(Model model, @RequestParam String vardas) {
        model.addAttribute("vardas", vardas);
        return "testinis.html";
    }
}


//http://localhost:8080/test/sveikinimas?vardas=Gerimantas
