package lt.autoservis.u5.controller;

import lt.autoservis.u5.model.repository.MiestaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiestaiControler {

    @Autowired
    MiestaiRepository miestaiRepository;

    @GetMapping("test/miestai")
    String testinisMiestai() {
        return "puslapis miestai veikia";
    }
}
