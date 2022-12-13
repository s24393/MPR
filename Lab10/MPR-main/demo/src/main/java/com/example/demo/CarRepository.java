package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car,Long> {
    Car findFirstByMake(String make);
    Car findCarById(Long id);
    Car findByRegistration(String registration);
}