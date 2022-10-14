package ru.tt.Sprinlistandmap.service;

import ru.tt.Sprinlistandmap.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    List<Employee> allDepartment(int department);
    Map<Integer, List<Employee>> allDepartmentNoParam();
    Employee minSallary(int department);
    Employee maxSallary(int department);
}
