package ru.tt.Sprinlistandmap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.tt.Sprinlistandmap.model.Employee;
import ru.tt.Sprinlistandmap.service.DepartmentServiceImpl;
import ru.tt.Sprinlistandmap.service.EmpoyerServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    private EmpoyerServiceImpl empoyerService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;
    private List<Employee> expected = Arrays.asList(
            new Employee("Ivan", "Petrov", 2, 10001),
            new Employee("Oleg", "Krot", 2, 10002),
            new Employee("Mariya", "Kostrova", 2, 20003),
            new Employee("Nikolai", "Harlamov", 3, 10004),
            new Employee("Sergei", "Melden", 3, 10005)
    );
    @BeforeEach
    public void beforeEach (){
        when(empoyerService.findAll()).thenReturn(
                expected
        );
    }
    @Test
    public void testMaxSalary(){
        assertThat(departmentService.maxSallary(2)).isEqualTo(expected.get(2));
    }
    @Test
    public void testMinSalary(){
        assertThat(departmentService.minSallary(2)).isEqualTo(expected.get(0));
    }

}
