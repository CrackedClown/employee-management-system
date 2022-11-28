package com.employee.manager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String emailId;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "contact_number", nullable = false, length = 10)
    private String contactNumber;

    @Column(name = "marital_status", nullable = false)
    private String maritalStatus;

}
