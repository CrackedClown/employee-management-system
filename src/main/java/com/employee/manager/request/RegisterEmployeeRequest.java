package com.employee.manager.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterEmployeeRequest {

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String emailId;

    private String companyName;

    private String address;

    private String contactNumber;

    private String maritalStatus;

}
