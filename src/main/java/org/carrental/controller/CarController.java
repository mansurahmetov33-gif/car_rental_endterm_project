package org.carrental.controller;

import jakarta.validation.Valid;
import org.carrental.DTO.CarRequestDTO;
import org.carrental.model.Car;
import org.carrental.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    // CREATE
    @PostMapping
    public Car create(@Valid @RequestBody CarRequestDTO dto) {
        return carService.saveFromDto(dto);
    }

    // READ ALL
    @GetMapping
    public List<Car> getAll() {
        return carService.findAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Car getById(@PathVariable Long id) {
        return carService.findById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Car update(
            @PathVariable Long id,
            @Valid @RequestBody CarRequestDTO dto
    ) {
        return carService.updateFromDto(id, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        carService.delete(id);
    }
}
