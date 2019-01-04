package com.chrouki.accounts.controller;

import com.chrouki.accounts.model.Account;
import com.chrouki.accounts.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tarik Chrouki on 13/07/18.
 */
@RestController
public class GenController {

    @Autowired
    AccountService accountService;

    @RequestMapping("/users")
    public Iterable<Account> accouts(){
        return  accountService.findAll();
    }
}
