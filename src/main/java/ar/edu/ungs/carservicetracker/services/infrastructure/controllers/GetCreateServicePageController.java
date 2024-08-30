package ar.edu.ungs.carservicetracker.services.infrastructure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetCreateServicePageController {
    @GetMapping("/services/create")
    public String handle() {
        return "services/create/index";
    }
}
