package org.carrental.cache;

import org.carrental.model.Car;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarCache {

    private static CarCache instance;

    private final Map<String, List<Car>> cache = new HashMap<>();

    private CarCache() {}

    public static CarCache getInstance() {
        if (instance == null) {
            instance = new CarCache();
        }
        return instance;
    }

    public List<Car> get(String key) {
        return cache.get(key);
    }

    public void put(String key, List<Car> value) {
        cache.put(key, value);
    }

    public void clear() {
        cache.clear();
    }
}