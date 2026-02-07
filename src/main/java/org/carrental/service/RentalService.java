package org.carrental.service;

import org.carrental.model.Rental;
import org.carrental.repository.RentalRepository;
import org.springframework.stereotype.Service;

@Service
public class RentalService {

    private final RentalRepository repository;

    public RentalService(RentalRepository repository) {
        this.repository = repository;
    }

    public Rental save(Rental rental) {
        return repository.save(rental);
    }
}
