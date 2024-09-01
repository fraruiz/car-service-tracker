package ar.edu.ungs.carservicetracker.services.infrastructure.controllers.update;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetUpdateServicePageController {
    @GetMapping("/services/update")
    public String handle(HttpSession session) {
        if (session.getAttribute("user_id") == null) {
            return "redirect:/auth";
        }

        return "services/update/index";
    }
}
