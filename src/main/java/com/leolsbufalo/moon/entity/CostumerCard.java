package com.leolsbufalo.moon.entity;

import javax.persistence.*;

@Entity
@Table(name = "costumer_card")
public class CostumerCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(mappedBy = "costumerCard", fetch = FetchType.LAZY)
    private Payment payment;
    private String method;
    private String number;
    private int cvc;
    private String name;
    private String documentNumber;
    private int expirationMonth;
    private int expirationYear;

    public CostumerCard(String method, String number, int cvc, String name, String documentNumber, int expirationMonth, int expirationYear) {
        this.method = method;
        this.number = number;
        this.cvc = cvc;
        this.name = name;
        this.documentNumber = documentNumber;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public int getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(int expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public int getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }
}