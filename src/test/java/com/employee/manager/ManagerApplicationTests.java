package com.employee.manager;

import com.employee.manager.request.LoginRequest;
import com.employee.manager.request.RegisterEmployeeRequest;
import com.employee.manager.response.RegisterEmployeeResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@SpringBootTest
@RequiredArgsConstructor
@Slf4j
class ManagerApplicationTests {

    @Test
    void validRegistration() {
        String registrationURL = "http://localhost:8080/register";
        RestTemplate restTemplate = new RestTemplate();

        UUID generatedString = UUID.randomUUID();
        RegisterEmployeeRequest request = RegisterEmployeeRequest.builder()
                .username(generatedString.toString().substring(0, 7))
                .password(generatedString.toString().substring(0, 7))
                .firstName(generatedString.toString().substring(0, 4))
                .lastName(generatedString.toString().substring(0, 4))
                .emailId(generatedString.toString().substring(0, 7) + "@gmail.com")
                .contactNumber("9998887770")
                .maritalStatus("unmarried")
                .address(generatedString.toString().substring(0, 10))
                .companyName(generatedString.toString().substring(0, 4))
                .build();
        log.info("Valid Registration Request: " + request);
        RegisterEmployeeResponse response = restTemplate.postForObject(registrationURL, request, RegisterEmployeeResponse.class);
        log.info("Valid Registration Response: " + response);
        Assert.assertNotNull(response);
    }



    @Test
    void invalidPasswordRegistration() {
        String registrationURL = "http://localhost:8080/register";

        RestTemplate restTemplate = new RestTemplate();

        UUID generatedString = UUID.randomUUID();
        RegisterEmployeeRequest request = RegisterEmployeeRequest.builder()
                .username(generatedString.toString().substring(0, 7))
                .password(generatedString.toString().substring(0, 1))
                .firstName(generatedString.toString().substring(0, 4))
                .lastName(generatedString.toString().substring(0, 4))
                .emailId(generatedString.toString().substring(0, 7) + "@gmail.com")
                .contactNumber("9999999999")
                .maritalStatus("unmarried")
                .address(generatedString.toString().substring(0, 10))
                .companyName(generatedString.toString().substring(0, 3))
                .build();

        log.info("Invalid Registration Request (Invalid Password): " + request);
        RegisterEmployeeResponse response = restTemplate.postForObject(registrationURL, request, RegisterEmployeeResponse.class);
        log.info("Invalid Registration Response (Invalid Password): " + response);
        Assert.assertNull(response);
    }

    @Test
    void invalidEmailRegistration() {
        String registrationURL = "http://localhost:8080/register";

        RestTemplate restTemplate = new RestTemplate();

        UUID generatedString = UUID.randomUUID();
        RegisterEmployeeRequest request = RegisterEmployeeRequest.builder()
                .username(generatedString.toString().substring(0, 7))
                .password(generatedString.toString().substring(0, 5))
                .firstName(generatedString.toString().substring(0, 4))
                .lastName(generatedString.toString().substring(0, 4))
                .emailId(generatedString.toString().substring(0, 7))
                .contactNumber("9999999999")
                .maritalStatus("unmarried")
                .address(generatedString.toString().substring(0, 10))
                .companyName(generatedString.toString().substring(0, 3))
                .build();

        log.info("Invalid Registration Request (Invalid Email): " + request);
        RegisterEmployeeResponse response = restTemplate.postForObject(registrationURL, request, RegisterEmployeeResponse.class);
        log.info("Invalid Registration Response (Invalid Email): " + response);
        Assert.assertNull(response);
    }

    @Test
    void invalidContactNumberRegistration() {
        String registrationURL = "http://localhost:8080/register";

        RestTemplate restTemplate = new RestTemplate();

        UUID generatedString = UUID.randomUUID();
        RegisterEmployeeRequest request = RegisterEmployeeRequest.builder()
                .username(generatedString.toString().substring(0, 7))
                .password(generatedString.toString().substring(0, 5))
                .firstName(generatedString.toString().substring(0, 4))
                .lastName(generatedString.toString().substring(0, 4))
                .emailId(generatedString.toString().substring(0, 7))
                .contactNumber("99999999999")
                .maritalStatus("unmarried")
                .address(generatedString.toString().substring(0, 10))
                .companyName(generatedString.toString().substring(0, 3))
                .build();

        log.info("Invalid Registration Request (Invalid ContactNumber): " + request);
        RegisterEmployeeResponse response = restTemplate.postForObject(registrationURL, request, RegisterEmployeeResponse.class);
        log.info("Invalid Registration Response (Invalid ContactNumber): " + response);
        Assert.assertNull(response);
    }

    @Test
    void invalidRegistrationUsernameAlreadyExists() {
        String registrationURL = "http://localhost:8080/register";
        RestTemplate restTemplate = new RestTemplate();

        UUID generatedString = UUID.randomUUID();
        RegisterEmployeeRequest request = RegisterEmployeeRequest.builder()
                .username("abc")
                .password(generatedString.toString().substring(0, 7))
                .firstName(generatedString.toString().substring(0, 4))
                .lastName(generatedString.toString().substring(0, 4))
                .emailId(generatedString.toString().substring(0, 7) + "@gmail.com")
                .contactNumber("9998887770")
                .maritalStatus("unmarried")
                .address(generatedString.toString().substring(0, 10))
                .companyName(generatedString.toString().substring(0, 4))
                .build();
        log.info("Invalid Registration Request (Username already exists): " + request);
        RegisterEmployeeResponse response = restTemplate.postForObject(registrationURL, request, RegisterEmployeeResponse.class);
        log.info("Invalid Registration Response (Username already exists): " + response);
        Assert.assertNull(response);
    }

    @Test
    void invalidRegistrationEmailIdAlreadyExists() {
        String registrationURL = "http://localhost:8080/register";
        RestTemplate restTemplate = new RestTemplate();

        UUID generatedString = UUID.randomUUID();
        RegisterEmployeeRequest request = RegisterEmployeeRequest.builder()
                .username(generatedString.toString().substring(0, 7))
                .password(generatedString.toString().substring(0, 7))
                .firstName(generatedString.toString().substring(0, 4))
                .lastName(generatedString.toString().substring(0, 4))
                .emailId("abc@gmail.com")
                .contactNumber("9998887770")
                .maritalStatus("unmarried")
                .address(generatedString.toString().substring(0, 10))
                .companyName(generatedString.toString().substring(0, 4))
                .build();
        log.info("Invalid Registration Request (EmailId already exists): " + request);
        RegisterEmployeeResponse response = restTemplate.postForObject(registrationURL, request, RegisterEmployeeResponse.class);
        log.info("Invalid Registration Response (EmailId already exists): " + response);
        Assert.assertNull(response);
    }

    @Test
    void validLogin() {
        String loginURL = "http://localhost:8080/login";

        RestTemplate restTemplate = new RestTemplate();

        LoginRequest request = new LoginRequest();
        request.setUsername("abc");
        request.setPassword("abc");

        log.info("Valid Login Request: " + request);
        Boolean response = restTemplate.postForObject(loginURL, request, Boolean.class);
        log.info("Valid Login Response: " + response);
        Assert.assertTrue(response);
    }

    @Test
    void invalidLogin() {
        String loginURL = "http://localhost:8080/login";

        RestTemplate restTemplate = new RestTemplate();

        LoginRequest request = new LoginRequest();
        request.setUsername(UUID.randomUUID().toString());
        request.setPassword(UUID.randomUUID().toString());

        log.info("Invalid Login Request: " + request);
        Boolean response = restTemplate.postForObject(loginURL, request, Boolean.class);
        log.info("Invalid Login Response: " + response);
        Assert.assertFalse(response);
    }

}
