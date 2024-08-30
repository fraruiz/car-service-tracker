package ar.edu.ungs.carservicetracker.garages.infrastructure.controllers;

import ar.edu.ungs.carservicetracker.garages.application.search.GaragesSearcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetGaragesPageController {
    private final GaragesSearcher garagesSearcher;

    public GetGaragesPageController(GaragesSearcher garagesSearcher) {
        this.garagesSearcher = garagesSearcher;
    }

    @GetMapping("/garages")
    public String handle(Model model) {
        var values = garagesSearcher.execute();

        model.addAttribute("values", values);

        return "garages/index";
    }
}
