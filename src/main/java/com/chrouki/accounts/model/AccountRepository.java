package com.chrouki.accounts.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Tarik Chrouki on 11/07/18.
 */
@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, String> {

    Account findByUsername(String username);

    Optional<Account> findAccountByEmail(String email);

}
