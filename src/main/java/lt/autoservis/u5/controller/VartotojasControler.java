package lt.autoservis.u5.controller;

import lt.autoservis.u5.model.entity.Vartotojas;
import lt.autoservis.u5.model.repository.VartotojasRepository;
import lt.autoservis.u5.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VartotojasControler {

    @Autowired
    VartotojasRepository vartotojasRepository;

    @Autowired
    private UserDetailsServiceImpl;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userDetailsServiceImpl.findAll());

        return "userList";
    }

//    @GetMapping("test/greeting")
//    String testinisEndVartotojas() {
//        return  "puslapis veikia";
//    }
}
