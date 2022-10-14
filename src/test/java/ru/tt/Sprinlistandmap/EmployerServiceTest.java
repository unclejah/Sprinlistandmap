package ru.tt.Sprinlistandmap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.tt.Sprinlistandmap.exceptions.BadRequest;
import ru.tt.Sprinlistandmap.exceptions.EmployeeAlreadyAddException;
import ru.tt.Sprinlistandmap.model.Employee;
import ru.tt.Sprinlistandmap.service.EmpoyerServiceImpl;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class EmployerServiceTest {
    private final EmpoyerServiceImpl empoyerService = new EmpoyerServiceImpl();
    @AfterEach
    public void afterEach(){
        empoyerService.findAll().forEach(emp -> empoyerService.remove(emp.getFirstName(),emp.getLastName()));
    }
    @Test
    public void addTestP(){
        addOne();
    }

    private Employee addOne(){
        Employee expected = new Employee("Fa","Fs", 1, 10);
        assertThat(empoyerService.findAll()).isEmpty();
        empoyerService.add(expected.getFirstName(), expected.getLastName(), expected.getDepartment(),expected.getSallary());
        assertThat(empoyerService.findAll())
                .isNotEmpty()
                .hasSize(1)
                .contains(expected);
        assertThat(empoyerService.find(expected.getFirstName(),expected.getLastName())).isEqualTo(expected);
        return expected;
    }

    @ParameterizedTest
    @MethodSource("addTestNParams")
    public void addTestN(String firstName, String lastName, Class<Throwable> expectedError){
        assertThatExceptionOfType(expectedError)
                .isThrownBy(() -> empoyerService.add(firstName,lastName, 1, 10));
    }
    @Test
    public void addTestN2() {
        Employee employee = addOne();
        assertThatExceptionOfType(EmployeeAlreadyAddException.class)
                .isThrownBy(()->empoyerService.add(employee.getFirstName(), employee.getLastName(), employee.getDepartment(),employee.getSallary()));

    }



    public static Stream<Arguments> addTestNParams(){
        return Stream.of(
                Arguments.of("F1","Fs", BadRequest.class),
                Arguments.of("Fa","F1", BadRequest.class)
        );
    }
}
