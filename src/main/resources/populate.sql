INSERT INTO APP_USER (id, EMAIL, FIRST_NAME, LAST_NAME, PASSWORD, USERNAME, SSN)
VALUES (default, 'ola@norge.no', 'Ola', 'Nordmann', '$2a$10$zce/ADp4BxSNlxXd1jFWeuYJAFdAf8Hv72DnjD8FlLJFVn3tN09oG', 'user', '050390-11937');
/*Password = hello */

INSERT INTO LOAN (id, AMOUNT, END_DATE, owner_id, PAYED_AMOUNT, PAYOFF_TIME, RENT, START_DATE, TYPE)
VALUES (default, 190500.0, NULL, NULL, 0.0, 96, 5.4, NULL, 'STUDENT_LOAN');

INSERT INTO LOAN (id, AMOUNT, END_DATE, owner_id, PAYED_AMOUNT, PAYOFF_TIME, RENT, START_DATE, TYPE)
VALUES (default, 1670000.0, NULL, NULL, 0.0, 360, 8.4, NULL, 'MORTGAGE');