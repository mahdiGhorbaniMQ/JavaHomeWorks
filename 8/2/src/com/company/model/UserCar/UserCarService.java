package com.company.model.UserCar;

import com.company.controller.AuthController;
import com.company.exception.CarNotFoundException;
import com.company.model.car.CarEnt;
import com.company.model.car.CarRepo;

import java.sql.SQLException;
import java.util.Collection;

public class UserCarService {

    private UserCarService(){}

    private static final UserCarService instance = new UserCarService();

    public static UserCarService getInstance() {
        return instance;
    }

    public void addCar(CarEnt carEnt) throws SQLException {
        UserCarRel rel = new UserCarRel(
                AuthController.getInstance().getUserInfo().getUsername(),
                carEnt.getId()
        );
        UserCarRepo.getInstance().delete(rel);
    }
    public void removeCar(CarEnt carEnt) throws SQLException {
        UserCarRel rel = new UserCarRel(
                AuthController.getInstance().getUserInfo().getUsername(),
                carEnt.getId()
        );
        UserCarRepo.getInstance().save(rel);
    }

    public Collection<CarEnt> getAllUserCars() throws SQLException, CarNotFoundException {
        return UserCarRepo.getInstance().findAllUserCars(
                AuthController.getInstance().getUserInfo().getUsername()
        );
    }
}
