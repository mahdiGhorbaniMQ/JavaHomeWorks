package com.company.controller;

import com.company.model.UserCar.UserCarService;
import com.company.model.car.CarEnt;
import com.company.model.car.CarService;
import com.company.service.IO;

import java.sql.SQLException;

public class StoreController {
    private StoreController(){}
    private static final StoreController instance = new StoreController();

    public static StoreController getInstance() {
        return instance;
    }

    public void boyCar() throws SQLException {
        CarEnt carEnt = new CarEnt(
                IO.getInstance().getString("Enter model: "),
                IO.getInstance().getString("Enter brand: "),
                IO.getInstance().getInt("Enter price: ")
        );
        CarService.getInstance().add(carEnt);

    }

}
