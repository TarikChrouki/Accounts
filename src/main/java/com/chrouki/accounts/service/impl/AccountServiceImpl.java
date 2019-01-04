package com.chrouki.accounts.service.impl;

import com.chrouki.accounts.model.Account;
import com.chrouki.accounts.model.AccountRepository;
import com.chrouki.accounts.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author Tarik Chrouki on 12/07/18.
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findAccountByUsername(String accountname) {
        return accountRepository.findByUsername(accountname);
    }

    @Override
    public List<Account> getAccountList(int page, int size, Sort.Direction sort) {
        return accountRepository.findAll(PageRequest.of(page, size, sort, "username")).getContent();
    }

    @Override
    public void delete(String id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account findById(String accountId) {
        return accountRepository.findById(accountId).get();
    }

    @Override
    public Iterable<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    @Transactional
    public void signup(@Valid Account account) {
        initUser(account);
        save(account);

    }

    /**
     * Initializes the user based on the input data,
     * e.g. encrypts the password
     */
    protected void initUser(Account account) {

        account.setUnencryptedPassword(account.getPassword());

    }


    /**
     * Makes a user unverified
     */
    protected void makeUnverified(Account account) {

        account.setVerified(false);
        // send a verification mail to the user
    }

    public Account fetchAccountByEmail(@Valid @Email @NotBlank String email){
        return accountRepository.findAccountByEmail(email).orElse(null);
    }
}
