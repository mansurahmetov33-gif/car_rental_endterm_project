package org.carrental.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class CarRequestDTO {

    @NotBlank(message = "Name must not be empty")
    private String name;

    @Min(value = 1, message = "Price must be greater than 0")
    private double pricePerDay;

    public String getName() {
        return name;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}
