package edu.popov.customer;

import lombok.AllArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
public class CustomerRegistrationRequest {

    @NotBlank(message = "First name should be not blank")
    private final String firstName;

    @NotBlank(message = "Last name should be not blank")
    private final String lastName;

    @NotBlank(message = "Email should be not blank")
    @Email
    private final String email;

}
