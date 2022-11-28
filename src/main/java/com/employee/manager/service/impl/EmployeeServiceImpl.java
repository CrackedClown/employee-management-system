package com.employee.manager.service.impl;

import com.employee.manager.entity.Employee;
import com.employee.manager.repository.EmployeeRepository;
import com.employee.manager.request.LoginRequest;
import com.employee.manager.request.RegisterEmployeeRequest;
import com.employee.manager.response.RegisterEmployeeResponse;
import com.employee.manager.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public RegisterEmployeeResponse registerNewEmployee(RegisterEmployeeRequest request) {
        String regexEmail = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        Pattern patternEmail = Pattern.compile(regexEmail);
        Matcher matcherEmail = patternEmail.matcher(request.getEmailId());

        String regexContactNumber = "^\\d{10}$";
        Pattern patternContactNumber = Pattern.compile(regexContactNumber);
        Matcher matcherContactNumber = patternContactNumber.matcher(request.getContactNumber());

        Employee employee = employeeRepository.findByUsername(request.getUsername());

        if(null != employee){
            return null;
        }

        employee = employeeRepository.findByEmailId(request.getEmailId());

        if(null != employee){
            return null;
        }

        if (request.getPassword().length() < 3 || request.getPassword().length() > 8) {
            return null;
        } else if (!matcherEmail.matches()) {
            return null;
        } else if (!matcherContactNumber.matches()) {
            return null;
        } else {
            Employee newEmployee = Employee.builder()
                    .username(request.getUsername())
                    .password(request.getPassword())
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .companyName(request.getCompanyName())
                    .address(request.getAddress())
                    .emailId(request.getEmailId())
                    .contactNumber(request.getContactNumber())
                    .maritalStatus(request.getMaritalStatus())
                    .build();

            newEmployee = employeeRepository.save(newEmployee);

            RegisterEmployeeResponse response = RegisterEmployeeResponse.builder()
                    .username(newEmployee.getUsername())
                    .firstName(newEmployee.getFirstName())
                    .lastName(newEmployee.getLastName())
                    .companyName(newEmployee.getCompanyName())
                    .address(newEmployee.getAddress())
                    .emailId(newEmployee.getEmailId())
                    .contactNumber(newEmployee.getContactNumber())
                    .maritalStatus(newEmployee.getMaritalStatus())
                    .build();

            return response;
        }
    }

    @Override
    public Boolean validateLogin(LoginRequest request) {
        Employee employee = employeeRepository.findByUsernameAndPassword(request.getUsername(), request.getPassword());
        return null != employee;
    }

    @Override
    public List<String> getCompanies() {
        return employeeRepository.findDistinctCompanyName();

    }
}
