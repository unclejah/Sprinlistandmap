package ru.tt.Sprinlistandmap;

import org.springframework.stereotype.Service;
import ru.tt.Sprinlistandmap.exception.EmployeeAlreadyAddException;
import ru.tt.Sprinlistandmap.exception.NotFoundException;
import ru.tt.Sprinlistandmap.exception.StrorageIsFullException;
import ru.tt.Sprinlistandmap.exceptions.EmployeeAlreadyAddException;
import ru.tt.Sprinlistandmap.exceptions.NotFoundException;
import ru.tt.Sprinlistandmap.exceptions.StrorageIsFullException;

import java.util.Collections;
import java.util.List;

@Service
public class EmpoyerServiceImpl implements EmployerService{
    private static final int SIZE = 5;
    private final List<Employee> employees;

    public EmpoyerServiceImpl(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        if(employees.contains(employee)){
            throw new EmployeeAlreadyAddException("Сотрудник уже есть");
        }
        if(employees.size()>= SIZE){
            throw new StrorageIsFullException("Нет мест");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        if(employees.contains(employee)){
            employees.remove(employee);
            return employee;
        }
         throw new NotFoundException("не найден");
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        if(employees.contains(employee)){
            return employee;
        }
        throw new NotFoundException("не найден");
    }

    @Override
    public List<Employee> findAll() {
        return Collections.unmodifiableList(employees);
    }
}
