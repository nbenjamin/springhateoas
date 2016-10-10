package com.nbenja.springboot.api;

import com.nbenja.springboot.domain.Customer;
import com.nbenja.springboot.repository.CustomerAccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController
@RequestMapping("demo")
@ExposesResourceFor(Customer.class)
public class CustomerController {

    @Autowired
    private CustomerAccountRepository customerAccountRepository;


    @RequestMapping( value = "/customers/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Resource<Customer> getCustomer(@PathVariable("id") int id) {
        return getCustomerResource(customerAccountRepository.getCustomer(id));
    }


    private Resource<Customer> getCustomerResource(Customer customer) {
        Resource<Customer> resource = new Resource<Customer>(customer);
        resource.add(linkTo(methodOn(CustomerController.class).getCustomer(customer.getId())).withRel("customer"));
        resource.add(linkTo(methodOn(AccountController.class).getAccounts(customer.getId())).withRel("accounts"));
        return resource;
    }

}
