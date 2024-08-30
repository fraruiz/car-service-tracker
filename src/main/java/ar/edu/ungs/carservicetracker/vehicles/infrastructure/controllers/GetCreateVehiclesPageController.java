package ar.edu.ungs.carservicetracker.vehicles.infrastructure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetCreateVehiclesPageController {
    @GetMapping("/vehicles/add")
    public String handle() {
        return "vehicles/create/index";
    }
}
