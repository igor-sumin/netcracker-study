package com.netcracker.chapters.third;

public class Employee implements Measurable {
    private final int id;
    private String email;
    private double salary;
    private Gender gender;

    public Employee() {
        this(0, "", 0., Gender.UNKNOWN);
    }

    public Employee(int id, String email, double salary, String gender) {
        this(id, email, salary, Gender.setGender(gender));
    }

    public Employee(int id, String email, double salary, Gender gender) {
        this.id     = id;
        this.email  = email;
        this.salary = salary;
        this.gender = gender;
    }

    public int getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public Gender getGender() {
        return this.gender;
    }

    @Override
    public double getMeasure() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = Gender.setGender(gender);
    }

    @Override
    public String toString() {
        return (
                "Employee = ( " +
                        "id = "     + id + ", " +
                        "email = "  + email + ", " +
                        "salary = "  + salary + ", " +
                        "gender = " + gender.nameLowerCase() +
                " )"
        );
    }

    public static double getAverageSalary(Measurable[] people) {
        double avg = 0.;
        for (Measurable human : people) {
            avg += human.getMeasure();
        }

        return avg / (double) people.length;
    }

    public static double getAverageSalary(Employee... employees) {
        double avg = 0.;
        for (Employee employee : employees) {
            avg += employee.getMeasure();
        }

        return avg / (double) employees.length;
    }


    public static Measurable largest(Measurable[] people) {
        double maxSalary = Double.MIN_VALUE;
        Measurable res = people[0];
        for (Measurable human : people) {
            if (maxSalary < human.getMeasure()) {
                maxSalary = human.getMeasure();
                res = human;
            }
        }

        return res;
    }

    public static Measurable largest(Employee... employees) {
        double maxSalary = Double.MIN_VALUE;
        Measurable res = employees[0];
        for (Measurable human : employees) {
            if (maxSalary < human.getMeasure()) {
                maxSalary = human.getMeasure();
                res = human;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        Employee[] employees = new Employee[] {
                new Employee(1, "author1@mail.ru", 100., "male"),
                new Employee(2, "author2@mail.ru", 200., "female"),
                new Employee(3, "author3@mail.ru", 500., "male")
        };

        System.out.println("avg = " + Employee.getAverageSalary(employees));
        System.out.println("Employee №0: " + employees[0].toString());

        Measurable[] people = new Measurable[] {
                new Employee(1, "author1@mail.ru", 100., "male"),
                new Employee(2, "author2@mail.ru", 200., "female"),
                new Employee(3, "author3@mail.ru", 500., "female")
        };

        System.out.println("largest = " + Employee.largest(people).toString());
    }
}