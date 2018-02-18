package com.s305089.software.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "OWNER", nullable = false)
    private User owner;

    @NotNull
    @Column(name = "AMOUNT", nullable = false)
    private Double amount;


}
