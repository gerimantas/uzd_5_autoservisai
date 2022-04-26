package lt.autoservis.u5.controller;

import lt.autoservis.u5.model.repository.VertinimasRepository;
import lt.autoservis.u5.model.repository.VertinimasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class VertinimasControler {

    @Autowired
    VertinimasRepository vertinimasRepository;

    @GetMapping ("/test/vertinimas")
    String testinisVertinimas() {
        return "puslapis veikia";
    }
}
