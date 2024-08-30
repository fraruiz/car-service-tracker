package ar.edu.ungs.carservicetracker.garages.infrastructure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetCreateGaragePageController {
    @GetMapping("/garages/create")
    public String handle() {
        return "garages/create/index";
    }
}
