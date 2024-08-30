package ar.edu.ungs.carservicetracker.vehicles.infrastructure.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetCreateVehiclesPageController {
    @GetMapping("/vehicles/add")
    public String handle(HttpSession session) {
        if (session.getAttribute("user_id") == null) {
            return "redirect:/auth";
        }

        return "vehicles/create/index";
    }
}
