package com.nbenja.springboot.repository;

import com.nbenja.springboot.domain.Account;
import com.nbenja.springboot.domain.Customer;
import com.nbenja.springboot.domain.Type;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 *
 */
public class CustomerAccountRepositoryTest {

    private CustomerAccountRepository subject;

    @Before
    public void before() {
        subject = new CustomerAccountRepository();
    }

    @Test
    public void getAccount() throws Exception {

        Account actual = subject.getAccount(100);
        assertThat(actual.getId(), is(100));
        assertThat(actual.getType(), is(Type.CHECKING));

    }

    @Test
    public void getCustomerByAccountId() throws  Exception {
        Customer actual = subject.getCustomer(1);
        assertThat(actual.getFirstName(), is("Ryan"));
    }

    @Test
    public void getAccountByCustomerId() throws  Exception {
        Account actual = subject.getAccountByCustomerId(1);
        assertThat(actual.getId(), is(100));
        assertThat(actual.getType(), is(Type.CHECKING));
    }

    @Test
    public void getAccounts() throws Exception {
        List<Account> actual = subject.getAccounts();
        assertThat(actual.size(), is(2));
    }
}