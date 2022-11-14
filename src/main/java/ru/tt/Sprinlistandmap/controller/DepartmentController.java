package ru.tt.Sprinlistandmap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.tt.Sprinlistandmap.model.Employee;
import ru.tt.Sprinlistandmap.service.DepartmentServiceImpl;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentServiceImpl departmentService;

    public DepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(value = "/all", params = "departmentid")
    public List<Employee> allDep(@RequestParam int department){
        return  departmentService.allDepartment(department);
    }
    @GetMapping(value = "/all")
    public Map<Integer, List<Employee>> allDepNoParam(){
        return  departmentService.allDepartmentNoParam();
    }
    @GetMapping(value = "/max-sallary", params = "departmentid")
    public Employee maxSallary(@RequestParam int department){
        return departmentService.maxSallary(department);
    }
    @GetMapping(value = "/min-sallary", params = "departmentid")
    public Employee minSallary(@RequestParam int department){
        return departmentService.minSallary(department);
    }
}
