package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public ResponseEntity<Car> getMake(@PathVariable("make") String make) throws CarNotFoundException, MyExceptionHandler {
        Optional<Car> optional = Optional.ofNullable(carRepository.findByRegistration(make));
        if (!optional.isPresent())
            throw new CarNotFoundException("Car Make not found");
        else return new ResponseEntity<>(optional.get(), HttpStatus.OK);
    }

    @GetMapping({"/id/{id}"})
    public ResponseEntity<Car> getId(@PathVariable("id") Long id) throws CarNotFoundException, MyExceptionHandler {
        Optional<Car> optional = carRepository.findById(id);
        if (!optional.isPresent())
            throw new CarNotFoundException("Car id not found");
        else return new ResponseEntity<>(optional.get(), HttpStatus.OK);

    }

    @GetMapping({"/registration/{registration}"})
    public ResponseEntity<Car> getRegistration(@PathVariable("registration") String registration) throws CarNotFoundException, MyExceptionHandler {
        Optional<Car> optional = Optional.ofNullable(carRepository.findByRegistration(registration));
        if (!optional.isPresent())
            throw new CarNotFoundException("Car Registration not found");
        else return new ResponseEntity<>(optional.get(), HttpStatus.OK);
    }

    @PostMapping({"/post"})
    public ResponseEntity<String> addCar(@RequestBody Car car) throws CarValidation, MyExceptionHandler {
        if (car.getRegistration().length() < 5 ) {
            throw new CarValidation("Wrong registration format");
        } else if (car.getMake() == null) {
            throw new CarValidation("Make cannot be null");
        }else
        carService.postCar(car);
        return new ResponseEntity<>("Car added",HttpStatus.OK);
    }
    @PatchMapping({"/patch/{id}"}) public void patchCar(@PathVariable("id") Long id,@RequestBody Car car) {carService.updateCar(car,id);}
    @DeleteMapping({"/delete/{id}"}) public void deleteCar(@PathVariable("id") Long id){carService.deleteRecord(id);}


}


