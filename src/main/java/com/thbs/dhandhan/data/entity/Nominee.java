package com.thbs.dhandhan.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "nominee")
@Getter
@Setter
public class Nominee {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone",  nullable = false)
    private  String phone;

    @Column(name = "govt_id",  nullable = false)
    private String gov_tid;

    @Column(name = "gov_type", nullable = false)
    private String gov_type;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "nominee")
    private Account account;


}


