package com.company.model.UserCar;

import com.company.exception.CarNotFoundException;
import com.company.model.car.CarEnt;
import com.company.model.car.CarService;
import com.company.model.user.UserEnt;
import com.company.model.user.UserRepo;
import com.company.service.MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class UserCarRepo {


    protected Collection<CarEnt> findAllUserCars(String username) throws SQLException, CarNotFoundException {
        ResultSet result = MySQL.getInstance().executeQuery("select * from L7.user_car where username = '" + username + "'");
        Collection<CarEnt> cars = new ArrayList<>();
        while (result.next()) {
            cars.add(
                    CarService.getInstance().getOne(
                            result.getString("model"),
                            result.getString("brand")
                    )
            );
        }
        return cars;
    }
    protected void save(UserCarRel rel) throws SQLException {
        ResultSet result = MySQL.getInstance()
                .executeQuery("select * from L7.user_car WHERE username = '" + rel.getUsername() + "'" +
                                                     " and car_id = '" + rel.getCar_id() + "'");

        if (!result.next()) {
            PreparedStatement preparedStatement = MySQL.getInstance()
                    .prepareStatement("insert into L7.user_car values (default, ?, ?)");
            preparedStatement.setString(1, rel.getUsername());
            preparedStatement.setInt(2, rel.getCar_id());
            preparedStatement.executeUpdate();
            MySQL.getInstance().commit();
        }
    }
    protected void delete(UserCarRel rel) throws SQLException {
        MySQL.getInstance()
                .prepareStatement("DELETE FROM L7.user_car WHERE username = '" + rel.getUsername() + "'" +
                                                                 " and car_id = '" + rel.getCar_id() + "'")
                .executeUpdate();
        MySQL.getInstance().commit();

    }


    private UserCarRepo(){}

    private static final UserCarRepo instance = new UserCarRepo();

    public static UserCarRepo getInstance() {
        return instance;
    }
}
