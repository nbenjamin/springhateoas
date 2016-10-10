package com.nbenja.springboot.api;

import com.nbenja.springboot.app.SpringHateoasApplication;
import com.nbenja.springboot.domain.Account;
import com.nbenja.springboot.domain.Type;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringHateoasApplication.class)
public class AccountControllerTest {

    @Autowired
    private AccountController subject;

    @Test
    public void getAccount() {
        Resource<Account> resource = subject.getAccount(100);
        assertThat(resource.getContent().getType(), is(Type.CHECKING));
    }


}