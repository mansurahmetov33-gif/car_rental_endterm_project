package org.carrental.controller;

import org.carrental.model.Rental;
import org.carrental.service.RentalService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rentals")
public class RentalController {

    private final RentalService service;

    public RentalController(RentalService service) {
        this.service = service;
    }

    @PostMapping
    public Rental create(@RequestBody Rental rental) {
        return service.save(rental);
    }
}
