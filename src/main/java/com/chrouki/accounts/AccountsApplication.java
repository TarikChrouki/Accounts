package com.chrouki.accounts;

import com.chrouki.accounts.model.Account;
import com.chrouki.accounts.model.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class})
public class AccountsApplication {

	@Autowired
	private AccountRepository accountRepository;

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

	@Bean
	@Profile({"jpa", "mongodb"})
	public CommandLineRunner onApplicationStart() {
		return args -> {
			System.out.println("--------------------------------------------");
			accountRepository.deleteAll();
			accountRepository.save(new Account("toto@yopmail.com", "toto","test",null, "toto2018"));

			System.out.println(accountRepository.count() + " people found:");
			accountRepository.findAll().forEach(account -> System.out.println(account.getfullName()));
			System.out.println("--------------------------------------------");
		};
	}
}
