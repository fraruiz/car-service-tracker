package ar.edu.ungs.carservicetracker.shared.infrastructure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetHomePageController {
    @GetMapping("/")
    public String handle() {
        return "shared/index";
    }
}
