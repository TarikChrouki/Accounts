package com.chrouki.accounts.service;

import com.chrouki.accounts.model.Account;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @author Tarik Chrouki on 12/07/18.
 */
public interface AccountService {

    Account findAccountByUsername(String accountname);

//    Account findByRegistrationConfirmationToken(String confirmationToken);

    List<Account> getAccountList(int page, int size, Sort.Direction sort);

    void delete(String id);

    Account save(Account account);

    Account findById(String accountId);

    Iterable<Account> findAll();

    void signup(Account account);
}
