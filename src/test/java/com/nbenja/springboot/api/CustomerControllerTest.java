package com.nbenja.springboot.api;

import com.nbenja.springboot.app.SpringHateoasApplication;
import com.nbenja.springboot.domain.Customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.Resource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.core.Is.is;


@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = SpringHateoasApplication.class)
public class CustomerControllerTest {

    @Autowired
    private CustomerController subject;

    @Test
    public void getCustomer() {
        Resource<Customer> resource = subject.getCustomer(1);
        assertThat(resource.getContent().getFirstName(), is("Ryan"));
        assertThat(resource.getLink("accounts").getHref(), is(endsWith("/demo/accounts?customerId=1")));
        assertThat(resource.getLink("customer").getHref(), is(endsWith("/demo/customers/1")));
    }


}