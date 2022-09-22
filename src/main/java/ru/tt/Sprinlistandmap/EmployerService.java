package ru.tt.Sprinlistandmap;

import java.util.List;

public interface EmployerService {
    Employee add(String firstName, String lastName);
    Employee remove(String  firstName, String lastName);
    Employee find(String  firstName, String lastName);
    List<Employee> findAll();
}
