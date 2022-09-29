package ru.tt.Sprinlistandmap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployerController {
    private final EmpoyerServiceImpl empoyerService;

    public EmployerController(EmpoyerServiceImpl empoyerService) {
        this.empoyerService = empoyerService;
    }
    @GetMapping("/add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName,
                        @RequestParam int department, @RequestParam double sallary){
        return empoyerService.add(firstName,lastName, department,  sallary);
    }
    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String lastName){
        return empoyerService.remove(firstName,lastName);
    }
    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName){
        return empoyerService.find(firstName,lastName);
    }
    @GetMapping("/findall")
    public Collection<Employee> findall(){
        return empoyerService.findAll();
    }

    @GetMapping(value = "/all", params = "departmentid")
    public void allDep(@RequestParam int department){
        empoyerService.allDepartment(department);
    }

    @GetMapping(value = "/max-sallary", params = "departmentid")
    public Employee maxSallary(@RequestParam int department){
        return empoyerService.maxSallary(department);
    }
    @GetMapping(value = "/min-sallary", params = "departmentid")
    public Employee minSallary(@RequestParam int department){
        return empoyerService.minSallary(department);
    }
}
