package com.nbenja.springboot.api;

import com.nbenja.springboot.domain.Account;
import com.nbenja.springboot.repository.CustomerAccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("demo")
public class AccountController {

    @Autowired
    private CustomerAccountRepository customerAccountRepository;

    @RequestMapping( value = "/accounts/{id}",  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Resource<Account> getAccount(@PathVariable("id") int id) {
        return getAccountResource(customerAccountRepository.getAccount(id));
    }

    @RequestMapping( value = "/accounts",  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection<Resource<Account>> getAccounts(@RequestParam(value = "customerId", required = false) Integer customerId) {
        List<Resource<Account>> resources = new ArrayList<Resource<Account>>();
        if(customerId != null ) {
            resources.add(getAccountResource(customerAccountRepository.getAccountByCustomerId(customerId)));

        } else {
            customerAccountRepository.getAccounts().stream().map(a -> getAccountResource(a)).collect(Collectors.toCollection(() -> resources));
        }
        return resources;
    }

    private Resource<Account> getAccountResource(Account account) {
        Resource<Account> resource = new Resource<Account>(account);
        resource.add(linkTo(methodOn(AccountController.class).getAccount(account.getId())).withRel("accounts"));
        resource.add(linkTo(methodOn(CustomerController.class).getCustomer(account.getCustomer().getId())).withRel("customer"));
        return resource;
    }

}
