package lt.autoservis.u5.controller;


import lt.autoservis.u5.model.repository.TelefonaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TelefonaiControler {

    @Autowired
    TelefonaiRepository telefonaiRepository;

    @GetMapping ("/test/telefonai")
    String testinisTelefonai() {
        return "telefonai puslapis veikia";
    }
}
