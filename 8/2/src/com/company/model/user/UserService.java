package com.company.model.user;

import com.company.service.MySQL;

import java.sql.SQLException;

public class UserService {
    private UserService(){};
    private final static UserService instance = new UserService();
    public static UserService getInstance() {
        return instance;
    }

    public void boy(UserEnt user,int dept, int net_value) throws SQLException {
        user.setDept(user.getDept()+dept);
        user.setNet_value(user.getNet_value()+net_value);
        UserRepo.getInstance().save(user);
        MySQL.getInstance().commit();
    }

}
