package loginStudents.model;

public class Student {
    private String name;
    private int age;
    private int studentNumber;
    private String password;

    public Student(){}
    public Student(String name, int age, int studentNumber, String password){
        this.name = name;
        this.age = age;
        this.studentNumber = studentNumber;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
