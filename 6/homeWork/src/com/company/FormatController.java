package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormatController {
    private static FormatController formatController;

    public static FormatController getInstance() {
        if (formatController == null) formatController = new FormatController();
        return formatController;
    }

    private FormatController(){}

    public boolean checkName(String name){
        Pattern pattern = Pattern.compile("[a-zA-Z]*");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public boolean checkUsername(String username){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher matcher = pattern.matcher(username);
        return username.length()<=9 && matcher.matches();
    }

    public boolean checkPassword(String username){
        Pattern pattern = Pattern.compile(" ");
        Matcher matcher = pattern.matcher(username);
        return username.length()>8 && !matcher.find();
    }

    public boolean checkAge(int age){
        return age > 0;
    }
}
