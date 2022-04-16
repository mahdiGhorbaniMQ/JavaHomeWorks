package com.company;

public class Employee {
    private int employee_number;
    private String name;
    private String national_code;
    private String father_name;
    private String employee_position;
    private int salary;
    private int experience;

    public Employee(){}

    public Employee(
            String name,
            String national_code,
            String father_name,
            String employee_position,
            int salary,
            int experience
    ){
        this.name = name;
        this.national_code = national_code;
        this.father_name = father_name;
        this.employee_position = employee_position;
        this.salary = salary;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public int getEmployee_number() {
        return employee_number;
    }

    public Employee setEmployee_number(int employee_number) {
        this.employee_number = employee_number;
        return this;
    }

    public String getNational_code() {
        return national_code;
    }

    public Employee setNational_code(String national_code) {
        this.national_code = national_code;
        return this;
    }

    public String getFather_name() {
        return father_name;
    }

    public Employee setFather_name(String father_name) {
        this.father_name = father_name;
        return this;
    }

    public String getEmployee_position() {
        return employee_position;
    }

    public Employee setEmployee_position(String employee_position) {
        this.employee_position = employee_position;
        return this;
    }

    public int getSalary() {
        return salary;
    }

    public Employee setSalary(int salary) {
        this.salary = salary;
        return this;
    }

    public int getExperience() {
        return experience;
    }

    public Employee setExperience(int experience) {
        this.experience = experience;
        return this;
    }


    @Override
    public String toString() {
        return
                "employee_number: " + employee_number + '\n' +
                "name: " + name + '\n' +
                "national_code: " + national_code + '\n' +
                "father_name: " + father_name + '\n' +
                "employee_position: " + employee_position + '\n' +
                "salary: " + salary + '\n' +
                "experience: " + experience + '\n';

    }
}
