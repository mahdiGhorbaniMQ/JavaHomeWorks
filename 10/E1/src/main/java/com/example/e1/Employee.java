package com.example.e1;

public class Employee {
    private String name;
    private String salary;
    private String experience;
    private String staff;
    private String jobTitle;

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }


    public String getSalary() {
        return salary;
    }

    public Employee setSalary(String salary) {
        this.salary = salary;
        return this;
    }

    public String getExperience() {
        return experience;
    }

    public Employee setExperience(String experience) {
        this.experience = experience;
        return this;
    }

    public String getStaff() {
        return staff;
    }

    public Employee setStaff(String staff) {
        this.staff = staff;
        return this;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public Employee setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public Employee(String name, String salary, String experience, String staff, String jobTitle) {
        this.name = name;
        this.salary = salary;
        this.experience = experience;
        this.staff = staff;
        this.jobTitle = jobTitle;
    }
    public Employee(){}

    @Override
    public String toString() {
        return  "name: "+ name + ", " +
                "salary: "+ salary + ", " +
                "experience: "+ experience + ", " +
                "staff: "+ staff + ", " +
                "jobTitle: "+ jobTitle;
    }
}
