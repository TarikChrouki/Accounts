package com.chrouki.accounts.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Optional;

/**
 * @author Tarik Chrouki on 11/07/18.
 */
@Component
public class AccountRepositoryTester {

    @Autowired
    private  AccountRepository accountRepository;

    public void saveAndFind(){
        System.out.println(accountRepository.count());
        Account admin = accountRepository.save(new Account("toto@yopmail.com", null,null,null, "toto2018"));
        Optional<Account> optional = accountRepository.findById(admin.getId());
        Account adminFound = optional.isPresent() ? optional.get() : null ;
        Assert.isTrue(admin.equals(adminFound), "the object was not equals");
    }
}
