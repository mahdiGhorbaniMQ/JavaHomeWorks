package com.company;

public class CalcFactory {
    public static Calculate getCalc(Calculate.types type){
        if (type == Calculate.types.PLUS) {
            return new CalcPlus();
        }
        return new CalcMinus();
    }
}
