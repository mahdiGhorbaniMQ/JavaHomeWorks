package com.company;

public interface Calculate {
    enum types{
        PLUS,
        MINUS
    }
    abstract float calc(float a, float b);
}
