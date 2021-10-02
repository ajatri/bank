package com.thbs.dhandhan.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "termed_account")
@Getter
@Setter
public class TermedAccount extends Account {

    @Column(name = "amount", nullable = false)
    private Float amount;

    @Column(name = "rate",  nullable = false)
    private Float rate = 0.5f;

    @Column(name = "penalty", nullable = false)
    private Float penalty;


    @Column(name = "months",  nullable = false)
    private Integer months;
}


