package ar.edu.ungs.carservicetracker.services.infrastructure.controllers;

import ar.edu.ungs.carservicetracker.services.application.find.ServiceFinder;
import ar.edu.ungs.carservicetracker.services.application.search.ServiceSearcher;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetServicesPageController {
    private final ServiceSearcher serviceSearcher;


    public GetServicesPageController(ServiceSearcher serviceSearcher) {
        this.serviceSearcher = serviceSearcher;
    }

    @GetMapping("/services")
    public String handle(Model model, HttpSession session) {
        if (session.getAttribute("user_id") == null) {
            return "redirect:/auth";
        }

        return "services/index";
    }
}
