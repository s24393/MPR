package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
       carRepository.saveAll(List.of(new Car("BMW", "b4"), new Car("BMW", "b5"), new Car("Toyota", "b6")));
    }


    public Car getMake(String make) {
        return carRepository.findFirstByMake(make);
    }
    public Car getId(Long id)
    {
        return carRepository.findCarById(id);
    }
    public Car getRegistration(String registration)
    {
        return carRepository.findByRegistration(registration);
    }
    public void postCar(Car car)
    {
        carRepository.save(car);
    }
    public void updateCar(Car car,Long id)
    {   Car car1=getId(id);
        car.setMake(car1.getMake());
        car.setRegistration(car1.getRegistration());
    carRepository.save(car1);

    }
    public void deleteRecord(Long id)
    {
        carRepository.deleteById(id);
    }
}
