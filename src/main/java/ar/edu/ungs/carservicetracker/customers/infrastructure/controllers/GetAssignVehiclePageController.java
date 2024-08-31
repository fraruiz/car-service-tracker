package ar.edu.ungs.carservicetracker.customers.infrastructure.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetAssignVehiclePageController {
    @GetMapping("/customers/assignVehicle")
    public String handle(HttpSession session) {
        if (session.getAttribute("user_id") == null) {
            return "redirect:/auth";
        }

        return "customers/assign/index";
    }


}
