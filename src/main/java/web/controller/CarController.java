package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.service.CarService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CarController {

    CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String printCar(HttpServletRequest request, Model model) {
        String count = request.getParameter("count");
        if (count == null) {
            model.addAttribute("cars", carService.getListCars(carService.getCount()));
        } else if (Integer.parseInt(count) >= 5) {
            model.addAttribute("cars", carService.getListCars(carService.getCount()));
        } else {
            model.addAttribute("cars", carService.getListCars(Integer.parseInt(count)));
        }
        return "cars";
    }
}