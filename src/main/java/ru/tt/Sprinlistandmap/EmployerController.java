package ru.tt.Sprinlistandmap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployerController {
    private final EmpoyerServiceImpl empoyerService;

    public EmployerController(EmpoyerServiceImpl empoyerService) {
        this.empoyerService = empoyerService;
    }
    @GetMapping("/add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName){
        return empoyerService.add(firstName,lastName);
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
    public List<Employee> findall(){
        return empoyerService.findAll();
    }
}
