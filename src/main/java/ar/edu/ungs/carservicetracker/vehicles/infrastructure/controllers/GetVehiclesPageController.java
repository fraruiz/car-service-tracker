package ar.edu.ungs.carservicetracker.vehicles.infrastructure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetVehiclesPageController {
    @GetMapping("/vehicles")
    public String handle() {
        return "vehicles/index";
    }
}
