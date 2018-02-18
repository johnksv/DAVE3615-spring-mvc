package com.s305089.software.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "LOAN")
public class Loan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "OWNER", nullable = false)
    private User owner;

    @NotNull
    @Column(name = "AMOUNT", nullable = false)
    private Double amount;

    @NotNull
    @Column(name = "RENT", nullable = false)
    private Double rent;

    @NotNull
    @Column(name = "START_DATE", nullable = true)
    private Date start;

    @NotNull
    @Column(name = "END_DATE", nullable = true)
    private Date end;

    @NotNull
    @Column(name = "PAYBACKTIME", nullable = false)
    @Min(0)
    private Integer paybackTimeMonths;



}
