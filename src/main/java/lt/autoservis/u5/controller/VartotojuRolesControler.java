package lt.autoservis.u5.controller;

import lt.autoservis.u5.model.repository.VartotojuRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VartotojuRolesControler {

    @Autowired
    VartotojuRolesRepository vartotojuRolesRepository;

    @GetMapping("test/vartotojuRoles")
    String testinisVartotojuRoles() {
        return "puslapis vartotoju roles veikia";
    }
}
