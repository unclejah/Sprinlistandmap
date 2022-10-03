package ru.tt.Sprinlistandmap;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface EmployerService {
    Employee add(String firstName, String lastName, int department, double sallary);
    Employee remove(String  firstName, String lastName);
    Employee find(String  firstName, String lastName);
    Collection<Employee> findAll();
    List<Map.Entry<String, Employee>> allDepartment(int department);
    Employee minSallary(int department);
    Employee maxSallary(int department);
}
