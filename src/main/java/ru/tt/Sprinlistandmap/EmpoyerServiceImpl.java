package ru.tt.Sprinlistandmap;

import org.springframework.stereotype.Service;
import ru.tt.Sprinlistandmap.exceptions.EmployeeAlreadyAddException;
import ru.tt.Sprinlistandmap.exceptions.NotFoundException;
import ru.tt.Sprinlistandmap.exceptions.StrorageIsFullException;

import java.util.*;

@Service
public class EmpoyerServiceImpl implements EmployerService{
    private static final int SIZE = 5;
    private final Map<String, Employee> employees;

    public EmpoyerServiceImpl(List<Employee> employees) {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
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
        Employee employee = new Employee(firstName,lastName);
        if(employees.containsKey(employee.getFullName())){
            employees.remove(employee.getFullName());
            return employee;
        }
         throw new NotFoundException("не найден");
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        if(employees.containsKey(employee.getFullName())){
            return employees.get(employee.getFullName());
        }
        throw new NotFoundException("не найден");
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
