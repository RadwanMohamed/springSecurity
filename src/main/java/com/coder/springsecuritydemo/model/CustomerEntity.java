package com.coder.springsecuritydemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity(name="customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String email;

    private String pwd;
    private String role;

    @JsonIgnore
    @OneToMany(mappedBy ="customer",fetch = FetchType.EAGER)
    private Set<AuthorityEntity> authorityEntity;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<AuthorityEntity> getAuthorityEntity() {
        return authorityEntity;
    }

    public void setAuthorityEntity(Set<AuthorityEntity> authorityEntity) {
        this.authorityEntity = authorityEntity;
    }

}
