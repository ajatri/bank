package com.thbs.dhandhan.data.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "Saving_acc")
@Getter
@Setter
public class SavingAccount extends Account {

    @Column(name = "s_balance", nullable = false)
    private Float s_balance;

    @Column(name = "rate", unique = true, nullable = false)
    private Float rate;

    @Column(name = "fine", unique = true, nullable = false)
    private Float fine;
}


