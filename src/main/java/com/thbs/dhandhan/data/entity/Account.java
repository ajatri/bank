package com.thbs.dhandhan.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "account")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Account {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "number", unique = true, nullable = false)
    String number;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cid", nullable = false)
    private Customer customer;

    @Column(name = "balance", nullable = false)
    private Float balance = 0f;
    @Column(name = "o_date", nullable = false)
    private Date o_date;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private List<Transaction> transaction;

    @OneToOne(fetch = FetchType.EAGER,cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
    @JoinColumn(name = "nid")
    private Nominee nominee;

    public Account() {

    }
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", customer=" + customer +
                ", balance=" + balance +
                ", o_date=" + o_date +
                ", nominee=" + nominee +
                '}';
    }
}


