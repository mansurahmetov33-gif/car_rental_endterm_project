package org.carrental.service;

import org.carrental.dto.CarRequestDTO;
import org.carrental.exception.CarNotFoundException;
import org.carrental.model.Car;
import org.carrental.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car saveFromDto(CarRequestDTO dto) {
        Car car = new Car(dto.getName(), dto.getPricePerDay());
        return carRepository.save(car);
    }

    public Car updateFromDto(Long id, CarRequestDTO dto) {
        Car car = findById(id);
        car.setName(dto.getName());
        car.setPricePerDay(dto.getPricePerDay());
        return carRepository.save(car);
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car findById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id));
    }

    public void delete(Long id) {
        carRepository.deleteById(id);
    }
}
