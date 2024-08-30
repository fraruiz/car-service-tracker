package ar.edu.ungs.carservicetracker.customers.infrastructure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetCreateCustomersPageController {
    @GetMapping("/customers/create")
    public String handle() {
        return "customers/create/index";
    }
}
