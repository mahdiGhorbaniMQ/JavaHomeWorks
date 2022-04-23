package com.company.controller;

import com.company.model.UserCar.UserCarService;
import com.company.model.car.CarEnt;
import com.company.model.car.CarService;
import com.company.service.IO;

import java.sql.SQLException;

public class CarController {
    private CarController(){}
    private static final CarController instance = new CarController();

    public static CarController getInstance() {
        return instance;
    }

    public void addCar() throws SQLException {
        CarEnt carEnt = new CarEnt(
                IO.getInstance().getString("Enter model: "),
                IO.getInstance().getString("Enter brand: "),
                IO.getInstance().getInt("Enter price: ")
        );
        CarService.getInstance().add(carEnt);

    }
    public void updateCar(CarEnt carEnt) throws SQLException {
        carEnt.setPrice(
                IO.getInstance().getInt("Enter price: ")
        );
        CarService.getInstance().add(carEnt);
    }
    public void boyCar(CarEnt carEnt) throws SQLException {
        UserCarService.getInstance().addCar(carEnt);
    }
}
