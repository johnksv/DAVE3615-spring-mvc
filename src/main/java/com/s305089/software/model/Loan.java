package com.s305089.software.model;

import org.springframework.format.annotation.DateTimeFormat;

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

    @ManyToOne()
    private User owner;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", nullable = false)
    private LoanType type;

    @NotNull
    @Column(name = "AMOUNT", nullable = false)
    private Double amount;

    //How much has been payed on this loan
    @NotNull
    @Column(name = "PAYED_AMOUNT", nullable = false)
    private Double payedAmount = 0d;

    @NotNull
    @Column(name = "RENT", nullable = false)
    private Double rent;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "START_DATE")
    private Date start;

    //When is the whole loan payed back
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "END_DATE")
    private Date end;

    @Column(name = "PAYOFF_TIME")
    @Min(0)
    private Integer payoffTimeMonths;


    public Integer getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public LoanType getType() {
        return type;
    }

    public void setType(LoanType type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getPayedAmount() {
        return payedAmount;
    }

    public void payOnLoan (Double amount) {
        this.payedAmount += amount;
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

    public Integer getPayoffTimeMonths() {
        return payoffTimeMonths;
    }

    public void setPayoffTimeMonths(Integer payoffTimeMonths) {
        this.payoffTimeMonths = payoffTimeMonths;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Loan)) return false;
        Loan loan = (Loan) o;
        return Objects.equals(id, loan.id) &&
                Objects.equals(amount, loan.amount) &&
                Objects.equals(rent, loan.rent) &&
                Objects.equals(start, loan.start) &&
                Objects.equals(end, loan.end) &&
                Objects.equals(payoffTimeMonths, loan.payoffTimeMonths);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, amount, rent, start, end, payoffTimeMonths);
    }
}
