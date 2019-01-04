package com.chrouki.accounts.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author Tarik Chrouki on 11/07/18.
 */
@Entity
@Document
@Data
public class Account implements UserDetails {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @Version
    Long version = 1L;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

    // ~ Instance fields
    // ================================================================================================
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String password;
    private String username;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "authorities", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "authorities")
    private Set<Authority> authorities;
    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;
    private boolean verified = true;

    public Account() {
    }

    public Account(String email, String firstName, String lastName, LocalDate birthday, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.password = password;
    }

    public String getfullName() {
        return firstName + " " + lastName;
    }

    @Transient
    public void setUnencryptedPassword(String password) {
        setPassword(new BCryptPasswordEncoder(12, new SecureRandom()).encode(password));
    }
}
