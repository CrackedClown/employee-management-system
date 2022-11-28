package com.employee.manager.controller;

import com.employee.manager.request.LoginRequest;
import com.employee.manager.request.RegisterEmployeeRequest;
import com.employee.manager.response.RegisterEmployeeResponse;
import com.employee.manager.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/register")
    public ResponseEntity<RegisterEmployeeResponse> register(@RequestBody RegisterEmployeeRequest request) {
        RegisterEmployeeResponse response = employeeService.registerNewEmployee(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> validateLogin(@RequestBody LoginRequest request) {
        Boolean valid = employeeService.validateLogin(request);
        return new ResponseEntity<>(valid, HttpStatus.OK);
    }

    @GetMapping("/company")
    public ResponseEntity<List<String>> getCompanies() {
        List<String> companies = employeeService.getCompanies();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

}
