package com.netcracker.taskOOP1.enterprise;

public class Employee {
    private final int id;
    private final String firstName;
    private final String lastName;
    private int salary;

    public Employee() {
        this(0, "Anonymous", "", 0);
    }

    public Employee(int id, String firstName, String lastName, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAnnualSalary() {
        return 12 * salary;
    }

    public int raiseSalary(int percent) {
        this.salary += this.salary * percent / 100;
        return this.salary;
    }

    public String toString() {
        return (
            "Employee = { " +
            "id = "         + id + ", " +
            "name = "       + firstName + ", " +
            "lastname = "   + lastName + ", " +
            "salary = "     + salary +
            " }"
        );
    }

    public static void main(String[] args) {
        System.out.println("--- 3. Employee class ---");

        Employee e = new Employee(1, "Igor", "Sumin", 100000);
        System.out.println(e.toString());
        System.out.println(e.getId());
        System.out.println(e.getSalary());
        System.out.println(e.raiseSalary(20));
    }
}