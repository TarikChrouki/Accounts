package com.chrouki.accounts.model;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * @author Tarik Chrouki on 11/07/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles("jpa")
public class AccountRepositoryJpaTest {

    @Autowired
    private AccountRepositoryTester accountRepositoryTester;

    @Autowired
    private EntityManager entityManager;

    @After
    public void flush() {
        // Mandatory to make sure all SQL queries are executed in database.
        // Otherwise, queries are potentially cached and @Transactional may clear cache
        // at the end of the test.
        entityManager.flush();
    }

    @Test
    public void saveAndFind() {
        accountRepositoryTester.saveAndFind();
    }
}
