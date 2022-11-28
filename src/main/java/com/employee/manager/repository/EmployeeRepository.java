package com.employee.manager.repository;

import com.employee.manager.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByUsernameAndPassword(String username, String password);

    Employee findByUsername(String username);

    Employee findByEmailId(String emailId);

    @Query("SELECT DISTINCT companyName FROM Employee")
    List<String> findDistinctCompanyName();

}
