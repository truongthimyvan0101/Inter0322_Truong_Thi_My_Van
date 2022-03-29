package models;

public class Employee extends Person{
    private String level;
    private String position;
    private double salary;

    public Employee(int id, String name, int age, String gender, String idCard, String email, String level, String position, int salary) {
    }

    public Employee(String level, String position, double salary) {
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public Employee(String id, String name, String age, String sex, String idCard, String email, String address, String level, String position, double salary) {
        super(id, name, age, sex, idCard, email, address);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "level='" + level + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                "} " + super.toString();
    }
}
