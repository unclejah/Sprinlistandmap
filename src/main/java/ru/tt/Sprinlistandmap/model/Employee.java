package ru.tt.Sprinlistandmap.model;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private int department;
    private double sallary;

    public Employee(String firstName, String lastName, int department, double sallary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.sallary = sallary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public int getDepartment() {
        return department;
    }

    public double getSallary() {
        return sallary;
    }

    public void setDepartment(int department) {
        if(department <1 || department>5) throw new RuntimeException("wrong department 1-5");
        this.department = department;
    }
    public String getFullName(){
        return firstName+" "+lastName;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
