package com.ongrid.nexusTesting.service;

import com.ongrid.nexusTesting.model.Employee;
import com.ongrid.nexusTesting.model.Gender;
import com.ongrid.nexusTesting.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;
    private EmployeeServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new EmployeeServiceImpl(employeeRepository);
    }

    @Test
    void getAllEmployees() {
        // when
        underTest.getAllEmployees();
        // then
        verify(employeeRepository).findAll();
    }

    @Test
    void addEmployee() {
        // given
        Employee employee = new Employee("Mahesh Kumar",
                "mahesh.kumar@ongrid.in", Gender.MALE);

        // when
        underTest.addEmployee(employee);

        // then
        ArgumentCaptor<Employee> addEmployeeRequestArgumentCaptor =
                ArgumentCaptor.forClass(Employee.class);

        verify(employeeRepository).save(addEmployeeRequestArgumentCaptor.capture());
        Employee capturedEmployee = addEmployeeRequestArgumentCaptor.getValue();
        assertThat(capturedEmployee).isEqualTo(employee);
    }

    @Test
    void addEmployeeWithException() {
        // given
        Employee employee = new Employee("Mahesh Kumar",
                "mahesh.kumar@ongrid.in", Gender.MALE);

        given(employeeRepository.checkEmailExists(anyString()))
                .willReturn(true);

        // when
        // then
        assertThatThrownBy(() -> underTest.addEmployee(employee))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Email " + employee.getEmail() + " taken");

        verify(employeeRepository, never()).save(any());
    }

    @Test
    @Disabled
    void deleteEmployee() {
    }
}