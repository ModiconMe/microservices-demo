package edu.popov.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {
}
