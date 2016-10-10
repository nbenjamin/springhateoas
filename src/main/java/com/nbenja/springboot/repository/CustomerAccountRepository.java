package com.nbenja.springboot.repository;

import com.nbenja.springboot.domain.Account;
import com.nbenja.springboot.domain.Customer;
import com.nbenja.springboot.domain.Type;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by czu548 on 10/9/16.
 */
@Repository
public class CustomerAccountRepository {

    private List<Account> accounts = new ArrayList<>();

    public CustomerAccountRepository() {
        Account account1 = new Account(100, "289101", "987399399", Type.CHECKING );
        Account account2 = new Account(200, "289102", "987399300", Type.SAVING );
        account1.setCustomer(new Customer(1, "Ryan", "Adam"));
        account2.setCustomer(new Customer(3, "Mike", "Ben"));
        accounts.add(account1);
        accounts.add(account2);

    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Account getAccount(int accountId) {
        return accounts.stream().filter( a -> accountId == a.getId()).findFirst().get();
    }

    public Account getAccountByCustomerId(int customerId) {
        return accounts.stream().filter( a -> customerId == a.getCustomer().getId()).findFirst().get();
    }

    public Customer getCustomer(int customerId) {
        return accounts.stream().filter( a -> customerId == a.getCustomer().getId())
                .map(a -> a.getCustomer()).collect(Collectors.toList()).get(0);
    }
}
