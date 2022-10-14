package ru.tt.Sprinlistandmap.service;

import org.springframework.stereotype.Service;
import ru.tt.Sprinlistandmap.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final EmployerService employeesService;

    public DepartmentServiceImpl(EmployerService employees, EmployerService employeesService) {
        this.employeesService = employeesService;

    }

    @Override
    public List<Employee> allDepartment(int department) {
//        for(Employee empl : employees.values()){
//            if(empl.getDepartment() == department){
//                System.out.println("ФИО = "+empl.getFullName()+", ЗП = "+empl.getSallary());
//
//            }
//        }
        return employeesService.findAll().stream()
                .filter(e ->e.getDepartment() == department)
                .collect(Collectors.toList());
//      .forEach(r -> System.out.println("ФИО = "+r.getValue().getFullName()+", ЗП = "+r.getValue().getSallary()))

    }

    @Override
    public Map<Integer, List<Employee>> allDepartmentNoParam() {
        return employeesService.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    @Override
    public Employee minSallary(int department) {


        return employeesService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSallary))
                .orElseThrow();
    }
    @Override
    public Employee maxSallary(int department) {

        return employeesService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSallary))
                .orElseThrow();
    }
}
