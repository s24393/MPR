package com.example.clientcar;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CarService {

  private final String URL="http://localhost:8081/";

//    @Autowired
//    public CarService(CarRepository carRepository) {
//        this.carRepository = carRepository;
//        carRepository.saveAll(List.of(new Car("BMW", "b4"), new Car("BMW", "b5"), new Car("Toyota", "b6")));
//    }


//    public Car getMake(String make) {
//        return carRepository.findFirstByMake(make);
//    }
    public Car getId(Long id)
    {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Car> response=restTemplate.getForEntity(URL+"/car/id/"+id,Car.class);
        return response.getBody();
    }
    public List<Car> getAll()
    {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Car[]> response=restTemplate.getForEntity(URL+"/show/car/",Car[].class);
        return Arrays.asList(response.getBody());
    }

}