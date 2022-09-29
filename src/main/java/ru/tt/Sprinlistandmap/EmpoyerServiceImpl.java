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
    public Employee add(String firstName, String lastName, int department, double sallary) {
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
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
    @Override
    public void allDepartment(int department) {
        for(Employee empl : employees.values()){
            if(empl.getDepartment() == department){
                System.out.println("ФИО = "+empl.getFullName()+", ЗП = "+empl.getSallary());

            }
        }
    }
    @Override
    public Employee minSallary(int department) {
        double minSallary = Double.MAX_VALUE;
        String key = null;
        for(Map.Entry<String, Employee> entry :employees.entrySet()){
            Employee employee = entry.getValue();
            if(employee.getDepartment() == department && employee.getSallary() < minSallary){
                minSallary = employee.getSallary();
                key = entry.getKey();
            }
        }
        if(key != null){
            return employees.get(key);
        }else {
            return null;
        }
    }
    @Override
    public Employee maxSallary(int department) {
        double maxSallary = Double.MIN_VALUE;
        String key = null;
        for(Map.Entry<String, Employee> entry :employees.entrySet()){
            Employee employee = entry.getValue();
            if(employee.getDepartment() == department && employee.getSallary() > maxSallary){
                maxSallary = employee.getSallary();
                key = entry.getKey();
            }
        }
        if(key != null){
            return employees.get(key);
        }else {
            return null;
        }
    }
}
