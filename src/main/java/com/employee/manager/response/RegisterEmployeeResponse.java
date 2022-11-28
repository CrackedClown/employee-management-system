package com.employee.manager.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class RegisterEmployeeResponse {

    private String username;

    private String firstName;

    private String lastName;

    private String emailId;

    private String companyName;

    private String address;

    private String contactNumber;

    private String maritalStatus;

}
