package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImp implements CarService {
    List<Car> listCars = new ArrayList<>();

    {
        listCars.add(new Car("Bugatti", "Chiron Super Sport", 490));
        listCars.add(new Car("Lamborghini", "Aventador SVJ", 350));
        listCars.add(new Car("Ferrari", "Daytona SP3", 350));
        listCars.add(new Car("McLaren", "F1 GTR", 349));
        listCars.add(new Car("Maserati", "MC20", 325));
    }

    @Override
    public List<Car> getListCars(int count) {
        return listCars.stream().limit(count).toList();
    }
}