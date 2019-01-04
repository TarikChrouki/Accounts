package com.chrouki.accounts.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @author Tarik Chrouki on 11/07/18.
 */
@Entity
@Document
@Data
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @Version
    Long version;
    @LastModifiedDate
    LocalDateTime lastModified;

    private String authority;

    private String description;


    private Authority() {
        lastModified = LocalDateTime.now();
        version = 1L;
    }

    public Authority(String authority) {
        this();
        setAuthority(authority);
    }

    public Authority(String authority, String description) {
        this(authority);
        this.description = description;
    }

}
