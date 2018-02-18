package com.s305089.software.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "LOAN")
public class Loan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User owner;

    @NotNull
    @Column(name = "AMOUNT", nullable = false)
    private Double amount;

    @NotNull
    @Column(name = "RENT", nullable = false)
    private Double rent;


    @Column(name = "START_DATE")
    private Date start;


    @Column(name = "END_DATE")
    private Date end;

    @Column(name = "PAYBACKTIME")
    @Min(0)
    private Integer paybackTimeMonths;

    public Integer getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getRent() {
        return rent;
    }

    public void setRent(Double rent) {
        this.rent = rent;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Integer getPaybackTimeMonths() {
        return paybackTimeMonths;
    }

    public void setPaybackTimeMonths(Integer paybackTimeMonths) {
        this.paybackTimeMonths = paybackTimeMonths;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Loan)) return false;
        Loan loan = (Loan) o;
        return Objects.equals(id, loan.id) &&
                Objects.equals(owner, loan.owner) &&
                Objects.equals(amount, loan.amount) &&
                Objects.equals(rent, loan.rent) &&
                Objects.equals(start, loan.start) &&
                Objects.equals(end, loan.end) &&
                Objects.equals(paybackTimeMonths, loan.paybackTimeMonths);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, owner, amount, rent, start, end, paybackTimeMonths);
    }
}
