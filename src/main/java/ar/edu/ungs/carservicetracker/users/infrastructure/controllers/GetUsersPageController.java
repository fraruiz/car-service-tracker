package ar.edu.ungs.carservicetracker.users.infrastructure.controllers;


import ar.edu.ungs.carservicetracker.users.application.search.UserSearcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetUsersPageController {

    private final UserSearcher searcher;

    public GetUsersPageController(UserSearcher searcher) {
        this.searcher = searcher;
    }

    @GetMapping("/users")
    public String handle(Model model) {

        var values = this.searcher.execute();

        model.addAttribute("values", values);


        return "users/index";
    }
}
