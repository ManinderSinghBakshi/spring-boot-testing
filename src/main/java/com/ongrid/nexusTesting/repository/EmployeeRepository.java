package com.ongrid.nexusTesting.repository;

import com.ongrid.nexusTesting.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT\n" +
            "    CASE \n" +
            "        WHEN COUNT(email) > 0 THEN TRUE\n" +
            "        ELSE FALSE\n" +
            "    END\n" +
            "FROM\n" +
            "    Employee \n" +
            "WHERE\n" +
            "    email = ?1")
    Boolean checkEmailExists(String email);
}
