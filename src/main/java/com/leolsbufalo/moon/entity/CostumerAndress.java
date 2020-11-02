package com.leolsbufalo.moon.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;

@Entity
@Table(name = "costumer_andress")
public class CostumerAndress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(mappedBy = "costumerAndress", fetch = FetchType.LAZY)
    private Costumer costumer;
    private String street;
    private String number;
    private String complement;
    private String district;
    private String state;
    private String country;
    private int zipcode;

    public CostumerAndress(String street, String number, String complement, String district, String state, String country, int zipcode) {
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.district = district;
        this.state = state;
        this.country = country;
        this.zipcode = zipcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    @Override
    public String toString() {
        return "CostumerAndress{" +
                "id=" + id +
                ", payment=" + costumer +
                ", street='" + street + '\'' +
                ", number=" + number +
                ", complement='" + complement + '\'' +
                ", district='" + district + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zipcode=" + zipcode +
                '}';
    }
}
