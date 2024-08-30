package ar.edu.ungs.carservicetracker.users.infrastructure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetCreateUserPageController {
    @GetMapping("/users/create")
    public String handle() {
        return "users/create/index";
    }
}
