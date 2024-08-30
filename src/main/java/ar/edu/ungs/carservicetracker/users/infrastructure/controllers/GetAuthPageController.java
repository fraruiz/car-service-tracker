package ar.edu.ungs.carservicetracker.users.infrastructure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetAuthPageController {
    @GetMapping("/auth")
    public String handle() {
        return "auth/index";
    }
}
