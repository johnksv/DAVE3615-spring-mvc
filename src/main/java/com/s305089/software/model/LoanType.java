package com.s305089.software.model;

public enum LoanType {
    STUDENT_LOAN,
    MORTGAGE,
    AUTO_LOAN;

    @Override
    public String toString() {
        String upper = this.name().substring(0, 1);
        String lower = this.name().substring(1).toLowerCase().replace("_", " ");
        return upper + lower;
    }
}
