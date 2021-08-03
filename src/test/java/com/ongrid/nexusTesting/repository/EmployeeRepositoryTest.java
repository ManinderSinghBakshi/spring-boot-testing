package com.ongrid.nexusTesting.repository;

import com.ongrid.nexusTesting.model.Employee;
import com.ongrid.nexusTesting.model.Gender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository underTest;

    @Test
    void checkEmailExists() {
        // Given
        String email = "aman.sharma@ongrid.in";
        Employee employee = new Employee("Aman Sharma", email, Gender.MALE);
        underTest.save(employee);

        // When
        boolean exists = underTest.checkEmailExists(email);

        // Then
        assertThat(exists).isFalse();
    }

    @Test
    void checkFindByName(){
        // given
        Employee employee = new Employee("Maninder", "maninder@gmail.com", Gender.MALE);

        // when
        underTest.save(employee);

        // then
        assertThat(underTest.findByName("Maninder")).isNotNull();
    }
}