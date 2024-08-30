package ar.edu.ungs.carservicetracker.services.infrastructure.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetCreateServicePageController {
    @GetMapping("/services/create")
    public String handle(HttpSession session) {
        if (session.getAttribute("user_id") == null) {
            return "redirect:/auth";
        }

        return "services/create/index";
    }
}
