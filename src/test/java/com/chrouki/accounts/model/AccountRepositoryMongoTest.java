package com.chrouki.accounts.model;

import com.chrouki.accounts.model.AccountRepositoryTester;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

/**
 * @author Tarik Chrouki on 11/07/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("mongodb")
public class AccountRepositoryMongoTest {

    @Autowired
    private AccountRepositoryTester accountRepositoryTester;

    @Test
    public void saveAndFind() {
        accountRepositoryTester.saveAndFind();
    }
}
