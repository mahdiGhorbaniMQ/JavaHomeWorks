package com.company.model.car;

import com.company.model.user.UserEnt;
import com.company.model.user.UserRepo;
import com.company.service.MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class CarRepo {
    protected Collection<CarEnt> findAll() throws SQLException {
        ResultSet result = MySQL.getInstance().executeQuery("select * from L7.car");
        Collection<CarEnt> cars = new ArrayList<>();
        while (result.next()) {
            CarEnt car = new CarEnt();
            car.setBrand(result.getString("brand"));
            car.setModel(result.getString("model"));
            car.setPrice(result.getInt("price"));
            car.setId(result.getInt("id"));
            cars.add(car);
        }
        return cars;
    }
    protected void save(CarEnt car) throws SQLException {
        ResultSet result = MySQL.getInstance()
                .executeQuery("select * from L7.car where" +
                        " brand = '" + car.getBrand() + "'" +
                        " and model = '" + car.getModel() + "'");

        if (result.next()) {
            PreparedStatement preparedStatement = MySQL.getInstance()
                    .prepareStatement("UPDATE L7.car\n" +
                            "SET price = ?\n" +
                            "WHERE brand = ?\n" +
                            "and model = ?");

            preparedStatement.setInt(1, car.getPrice());
            preparedStatement.setString(2, car.getBrand());
            preparedStatement.setString(3, car.getModel());
            preparedStatement.executeUpdate();
        }
        else {
            PreparedStatement preparedStatement = MySQL.getInstance()
                    .prepareStatement("insert into L7.car values (default, ?, ?, ?)");
            preparedStatement.setString(1, car.getBrand());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setInt(3, car.getPrice());
            preparedStatement.executeUpdate();
        }
        MySQL.getInstance().commit();
    }
    protected void delete(CarEnt car) throws SQLException {
        MySQL.getInstance()
                .prepareStatement("DELETE FROM L7.car where" +
                        " brand = '" + car.getBrand() + "'" +
                        " and model = '" + car.getModel() + "'")
                .executeUpdate();
    }


    private CarRepo(){}

    private static final CarRepo instance = new CarRepo();

    public static CarRepo getInstance() {
        return instance;
    }
}
