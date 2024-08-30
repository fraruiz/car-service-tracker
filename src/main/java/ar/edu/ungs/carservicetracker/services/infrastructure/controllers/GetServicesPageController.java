package ar.edu.ungs.carservicetracker.services.infrastructure.controllers;

import ar.edu.ungs.carservicetracker.services.application.find.ServiceFinder;
import ar.edu.ungs.carservicetracker.services.application.search.ServiceSearcher;
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
    public String handle(Model model) {
      //  var values = this.serviceSearcher.execute();

        //model.addAttribute("services", values);



        return "services/index";
    }
}
