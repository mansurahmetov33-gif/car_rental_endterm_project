package org.carrental.service;

import org.carrental.cache.CarCache;
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
        Car saved = carRepository.save(car);

        // очищаем кэш после добавления
        CarCache.getInstance().clear();

        return saved;
    }

    public Car updateFromDto(Long id, CarRequestDTO dto) {
        Car car = findById(id);
        car.setName(dto.getName());
        car.setPricePerDay(dto.getPricePerDay());

        Car updated = carRepository.save(car);

        // очищаем кэш после обновления
        CarCache.getInstance().clear();

        return updated;
    }

    public List<Car> findAll() {

        CarCache cache = CarCache.getInstance();

        // проверяем есть ли данные в кэше
        List<Car> cachedCars = cache.get("allCars");

        if (cachedCars != null) {
            System.out.println("Returning cars from CACHE");
            return cachedCars;
        }

        System.out.println("Fetching cars from DATABASE");

        List<Car> cars = carRepository.findAll();

        cache.put("allCars", cars);

        return cars;
    }

    public Car findById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id));
    }

    public void delete(Long id) {
        carRepository.deleteById(id);

        // очищаем кэш после удаления
        CarCache.getInstance().clear();
    }
}