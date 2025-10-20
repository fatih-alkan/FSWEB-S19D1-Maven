package com.workintech.s18d2.validations;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.InvalidDataException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidationUtils {

    public static void validateId(Long id) {
        if (id == null || id <= 0) {
            log.error("Invalid ID: {}", id);
            throw new InvalidDataException("ID must be greater than 0");
        }
    }

    public static void validateFruitData(Fruit fruit) {
        if (fruit == null || fruit.getName() == null || fruit.getPrice() == null) {
            log.error("Invalid fruit data: {}", fruit);
            throw new InvalidDataException("Fruit data is invalid");
        }
    }

    public static void validateVegetableData(Vegetable vegetable) {
        if (vegetable == null || vegetable.getName() == null || vegetable.getPrice() == null) {
            log.error("Invalid vegetable data: {}", vegetable);
            throw new InvalidDataException("Vegetable data is invalid");
        }
    }
}
