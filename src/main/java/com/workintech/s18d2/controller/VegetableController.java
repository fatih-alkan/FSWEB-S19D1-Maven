package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.payload.ApiResponse;
import com.workintech.s18d2.services.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech/vegetables")
public class VegetableController {

    private final VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public List<Vegetable> getAllVegetablesAsc() {
        return vegetableService.getByPriceAsc();
    }

    @GetMapping("/desc")
    public List<Vegetable> getAllVegetablesDesc() {
        return vegetableService.getByPriceDesc();
    }

    @GetMapping("/{id}")
    public Vegetable getVegetableById(@PathVariable Long id) {
        return vegetableService.getById(id);
    }

    @PostMapping
    public ApiResponse<Vegetable> saveVegetable(@RequestBody Vegetable vegetable) {
        Vegetable saved = vegetableService.save(vegetable);
        return new ApiResponse<>("Vegetable saved successfully", saved);
    }

    @PostMapping("/{name}")
    public List<Vegetable> searchVegetablesByName(@PathVariable String name) {
        return vegetableService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Vegetable> deleteVegetable(@PathVariable Long id) {
        Vegetable deleted = vegetableService.deleteById(id);
        return new ApiResponse<>("Vegetable deleted successfully", deleted);
    }
}
