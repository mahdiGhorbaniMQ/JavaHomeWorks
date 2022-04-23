package com.company.model.car;

import com.company.exception.CarNotFoundException;

import java.sql.SQLException;
import java.util.Collection;

public class CarService {

    private CarService(){}
    private static final CarService instance = new CarService();
    public static CarService getInstance() {
        return instance;
    }

    public void add(CarEnt carEnt) throws SQLException {
        CarRepo.getInstance().save(carEnt);
    }

    public void update(CarEnt carEnt) throws SQLException {
        CarRepo.getInstance().save(carEnt);
    }

    public void showAll() throws SQLException {
        CarRepo.getInstance().findAll().forEach(car->{
            System.out.println(car.toString());
            System.out.println("___________________________________");
        });
    }

    public void showOne(String model, String brand) throws SQLException, CarNotFoundException {
        CarEnt car = CarRepo.getInstance().findAll()
                .stream().filter(carEnt -> {
                    return carEnt.getBrand().equals(brand) && carEnt.getModel().equals(model);
                }).findFirst().orElse(null);

        if (car != null) System.out.println(car.toString());
        else throw new CarNotFoundException();
    }

    public void remove(CarEnt carEnt) throws SQLException {
        CarRepo.getInstance().delete(carEnt);
    }

    public Collection<CarEnt> getAll() throws SQLException {
        return CarRepo.getInstance().findAll();
    }

    public CarEnt getOne(String model, String brand) throws SQLException, CarNotFoundException {
        CarEnt car = CarRepo.getInstance().findAll()
                .stream().filter(carEnt -> {
                    return carEnt.getBrand().equals(brand) && carEnt.getModel().equals(model);
                }).findFirst().orElse(null);

        if (car != null) return car;
        else throw new CarNotFoundException();
    }
}
