package com.thbs.dhandhan.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thbs.dhandhan.utils.TransactionStatus;
import com.thbs.dhandhan.utils.TransactionType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "transaction")
@Getter
@Setter
public class Transaction {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    @Column(name = "transactionsType", nullable = false)
    private TransactionType transactionsType;

    @Column(name = "transactionsStatus", nullable = false)
    private TransactionStatus transactionsStatus = TransactionStatus.WAITING;


    @Column(name = "transactionsRemarks", nullable = false)
    private String transactionsRemarks = "Thank you fro choosing the application";

    @Column(name = "transactionsDate", nullable = false)
    private Date transactionsDate;

    @Column(name = "toAccount")
    private String toAccount;

    @Column(name = "amount", nullable = false)
    private Float amount;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "acid", nullable = false)
    private Account account;

}



