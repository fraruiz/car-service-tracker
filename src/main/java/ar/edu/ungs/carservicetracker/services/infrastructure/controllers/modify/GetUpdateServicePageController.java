package ar.edu.ungs.carservicetracker.services.infrastructure.controllers.modify;

import ar.edu.ungs.carservicetracker.services.application.search.ServiceSearcher;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
