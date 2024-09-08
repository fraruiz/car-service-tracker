package ar.edu.ungs.carservicetracker.services.infrastructure.controllers.update;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GetUpdateServicePageController {
    @GetMapping("/services/update/{id}")
    public String handle(HttpSession session, @PathVariable String id, Model model) {
        if (session.getAttribute("user_id") == null) {
            return "redirect:/auth";
        }

        model.addAttribute("id", id);

        return "services/update/index";
    }
}
