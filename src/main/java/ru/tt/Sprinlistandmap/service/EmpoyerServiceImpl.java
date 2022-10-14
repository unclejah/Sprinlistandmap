package ru.tt.Sprinlistandmap.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ru.tt.Sprinlistandmap.exceptions.BadRequest;
import ru.tt.Sprinlistandmap.exceptions.EmployeeAlreadyAddException;
import ru.tt.Sprinlistandmap.exceptions.NotFoundException;
import ru.tt.Sprinlistandmap.exceptions.StrorageIsFullException;
import ru.tt.Sprinlistandmap.model.Employee;
import ru.tt.Sprinlistandmap.service.EmployerService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmpoyerServiceImpl implements EmployerService {
    private static final int SIZE = 5;
    private final Map<String, Employee> employees;

    public EmpoyerServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName, int department, double sallary) {

        if(!StringUtils.isAlpha(firstName)||!StringUtils.isAlpha(lastName)){
            throw new BadRequest("Bad very bad");
        }
        firstName = StringUtils.capitalize(firstName.toLowerCase());
        lastName = StringUtils.capitalize(lastName.toLowerCase());

        Employee employee = new Employee(firstName,lastName, department, sallary);
        if(employees.containsKey(employee.getFullName())){
            throw new EmployeeAlreadyAddException("Сотрудник уже есть");
        }
        if(employees.size()>= SIZE){
            throw new StrorageIsFullException("Нет мест");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
//        Employee employee = new Employee(firstName,lastName);
        String fullName = firstName+" "+lastName;
        if(employees.containsKey(fullName)){
            employees.remove(fullName);
            return employees.get(fullName);
        }
         throw new NotFoundException("не найден");
    }

    @Override
    public Employee find(String firstName, String lastName) {
//        Employee employee = new Employee(firstName,lastName);
        String fullName = firstName+" "+lastName;
        if(employees.containsKey(fullName)){
            return employees.get(fullName);
        }
        throw new NotFoundException("не найден");
    }

    @Override
    public List<Employee> findAll() {
        return
                new ArrayList<>(employees.values());
    }

}
