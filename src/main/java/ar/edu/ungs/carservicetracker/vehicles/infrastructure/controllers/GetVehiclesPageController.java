package ar.edu.ungs.carservicetracker.vehicles.infrastructure.controllers;

import ar.edu.ungs.carservicetracker.vehicles.application.VehicleResponse;
import ar.edu.ungs.carservicetracker.vehicles.application.search.VehicleSearcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GetVehiclesPageController {
    private final VehicleSearcher vehicleSearcher;

    public GetVehiclesPageController(VehicleSearcher vehicleSearcher) {
        this.vehicleSearcher = vehicleSearcher;
    }

    @GetMapping("/vehicles")
    public String handle(Model model) {
        List<VehicleResponse> responses = this.vehicleSearcher.execute();

        model.addAttribute("values", responses);

        return "vehicles/index";
    }
}
