package com.company.model.UserCar;

public class UserCarRel {
    private String username;
    private int car_id;

    public UserCarRel(){}
    public UserCarRel(String username, int car_id) {
        this.username = username;
        this.car_id = car_id;
    }

    public String getUsername() {
        return username;
    }

    public UserCarRel setUsername(String username) {
        this.username = username;
        return this;
    }

    public int getCar_id() {
        return car_id;
    }

    public UserCarRel setCar_id(int car_id) {
        this.car_id = car_id;
        return this;
    }
}
