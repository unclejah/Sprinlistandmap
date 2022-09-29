package ru.tt.Sprinlistandmap;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public interface EmployerService {
    Employee add(String firstName, String lastName, int department, double sallary);
    Employee remove(String  firstName, String lastName);
    Employee find(String  firstName, String lastName);
    Collection<Employee> findAll();
    void allDepartment(int department);
    Employee minSallary(int department);
    Employee maxSallary(int department);
}
