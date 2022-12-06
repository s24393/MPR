package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {
    CarRepository carRepository;
    CarService carService;

    @Autowired
    public CarController(CarRepository carRepository, CarService carService) {
        this.carRepository = carRepository;
        this.carService = carService;
    }

    @GetMapping({"/make/{make}"})
    public Car getMake(@PathVariable("make") String make) {
        return this.carService.getMake(make);
    }
    @GetMapping({"/id/{id}"})
    public Car getId(@PathVariable("id") Long id){return this.carService.getId(id);}
    @GetMapping({"/registration/{registration}"})
    public Car getRegistration(@PathVariable("registration") String registration){return this.carService.getRegistration(registration);}
    @PostMapping({"/post"})
    public void addCar(@RequestBody Car car){carService.postCar(car);}
    @PatchMapping({"/patch/{id}"}) public void patchCar(@PathVariable("id") Long id,@RequestBody Car car) {carService.updateCar(car,id);}
    @DeleteMapping({"/delete/{id}"}) public void deleteCar(@PathVariable("id") Long id){carService.deleteRecord(id);}


}


