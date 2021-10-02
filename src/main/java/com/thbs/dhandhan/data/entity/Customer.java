package com.thbs.dhandhan.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.thbs.dhandhan.utils.CustomerStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "customer")
@Getter
@Setter
public class Customer {

    @Id
    @JsonIgnore
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "aid", nullable = false)
    private Admin admin;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "phoneNumber", unique = true, nullable = false)
    private String phoneNumber;

    @Column(name = "customerStatus", nullable = false)
    private CustomerStatus status = CustomerStatus.PENDING;


    @Column(name = "customerId", unique = true, nullable = false)
    private String customerId;


    @Column(name = "password", unique = true, nullable = false)
    private String password;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer",cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Account> accounts;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", admin=" + admin +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", status=" + status +
                ", username='" + customerId + '\'' +
                ", password='" + password + '\'' +
                ", account=" + accounts +
                '}';
    }
}















