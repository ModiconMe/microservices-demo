package edu.popov.customer;

import edu.popov.amqp.RabbitMQMessageProducer;
import edu.popov.clients.fraud.FraudCheckResponse;
import edu.popov.clients.fraud.FraudClient;
import edu.popov.clients.notification.NotificationClient;
import edu.popov.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public record CustomerService(
        CustomerRepository customerRepository,
//        RestTemplate restTemplate,
        FraudClient fraudClient,
        NotificationClient notificationClient,
        RabbitMQMessageProducer rabbitMQMessageProducer
) {

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // todo: check if email is valid
        // todo: check if email not taken
        // todo: check if fraudster
        customerRepository.saveAndFlush(customer);
//        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
//                "http://FRAUD/api/v1/fraud-check/{customerId}",
//                FraudCheckResponse.class,
//                customer.getId()
//        );

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw  new IllegalStateException("fraudster");
        }

        NotificationRequest notificationRequest = NotificationRequest.builder()
                .customerId(customer.getId())
                .text(format("Hi %s, congratulations, you are register", customer.getFirstName()))
                .email(customer.getEmail())
                .build();
        rabbitMQMessageProducer.publish(notificationRequest, "internal.queue", "internal.notification.routing-keys");

    }

}
