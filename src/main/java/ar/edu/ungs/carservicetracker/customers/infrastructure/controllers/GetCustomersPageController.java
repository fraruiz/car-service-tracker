package ar.edu.ungs.carservicetracker.customers.infrastructure.controllers;

import ar.edu.ungs.carservicetracker.customers.application.search.CustomersSearcher;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetCustomersPageController {

    private final CustomersSearcher searcher;

    public GetCustomersPageController(CustomersSearcher searcher) {
        this.searcher = searcher;
    }

    @GetMapping("/customers")
    public String handle(Model model, HttpSession session) {
        if (session.getAttribute("user_id") == null) {
            return "redirect:/auth";
        }

        var values = this.searcher.execute();

        model.addAttribute("values", values);

        return "customers/index";
    }
}
