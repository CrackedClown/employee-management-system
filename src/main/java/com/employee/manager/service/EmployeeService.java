package com.employee.manager.service;

import com.employee.manager.request.LoginRequest;
import com.employee.manager.request.RegisterEmployeeRequest;
import com.employee.manager.response.RegisterEmployeeResponse;

import java.util.List;

public interface EmployeeService {

    RegisterEmployeeResponse registerNewEmployee(RegisterEmployeeRequest request);

    Boolean validateLogin(LoginRequest request);

    List<String> getCompanies();
}
