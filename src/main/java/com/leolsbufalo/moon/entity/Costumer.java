package com.leolsbufalo.moon.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;

@Entity
@Table(name = "costumer")
public class Costumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToOne(mappedBy = "costumer", fetch = FetchType.LAZY)
    private Payment payment;
    private String email;
    private int phoneCountryCode;
    private int phoneAreaCode;
    private int phoneNumber;
    private String birthDate;
    private String documentNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "costumer_andress_id", referencedColumnName = "id")
    private CostumerAndress costumerAndress;

    public Costumer(String name, String email, int phoneCountryCode, int phoneAreaCode, int phoneNumber, String birthDate, String documentNumber, CostumerAndress costumerAndress) {
        this.name = name;
        this.email = email;
        this.phoneCountryCode = phoneCountryCode;
        this.phoneAreaCode = phoneAreaCode;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.documentNumber = documentNumber;
        this.costumerAndress = costumerAndress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneCountryCode() {
        return phoneCountryCode;
    }

    public void setPhoneCountryCode(int phoneCountryCode) {
        this.phoneCountryCode = phoneCountryCode;
    }

    public int getPhoneAreaCode() {
        return phoneAreaCode;
    }

    public void setPhoneAreaCode(int phoneAreaCode) {
        this.phoneAreaCode = phoneAreaCode;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public CostumerAndress getCostumerAndress() {
        return costumerAndress;
    }

    public void setCostumerAndress(CostumerAndress costumerAndress) {
        this.costumerAndress = costumerAndress;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    @Override
    public String toString() {
        return "Costumer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", payment=" + payment +
                ", email='" + email + '\'' +
                ", phoneCountryCode=" + phoneCountryCode +
                ", phoneAreaCode=" + phoneAreaCode +
                ", phoneNumber=" + phoneNumber +
                ", birthDate='" + birthDate + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                '}';
    }
}
