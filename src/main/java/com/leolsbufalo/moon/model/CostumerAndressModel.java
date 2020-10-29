package com.leolsbufalo.moon.model;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CostumerAndressModel {
    @NotNull
    @Pattern(regexp = "[0-9A-ZÁ-Úa-zá-ú .,]{0,255}", message = "Bad Street, just use letters and numbers")
    private String street;
    @Pattern(regexp = "[0-9A-ZÁ-Úa-zá-ú .,]{0,50}", message = "Bad Street, just use letters and numbers")
    private String number;
    @NotNull
    @Pattern(regexp = "[0-9A-ZÁ-Úa-zá-ú .,]{0,255}", message = "Bad Complement, just use letters and numbers")
    private String complement;
    @NotNull
    @Pattern(regexp = "[0-9A-ZÁ-Úa-zá-ú .,]{0,255}", message = "Bad District, just use letters and numbers")
    private String district;
    @NotNull
    @Pattern(regexp = "[A-ZÁ-Úa-zá-ú .,]{0,255}", message = "Bad State, just use letters and numbers")
    private String state;
    @NotNull
    @Pattern(regexp = "[A-ZÁ-Úa-zá-ú ]{0,255}", message = "Bad Country, just use letters and numbers")
    private String country;
    @NotNull
    @Min(value = 1, message = "Value must be bigger than 0, just use numbers")
    private int zipcode;

    public CostumerAndressModel(String street, String number, String complement, String district, String state, String country, int zipcode) {
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.district = district;
        this.state = state;
        this.country = country;
        this.zipcode = zipcode;
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

    @Override
    public String toString() {
        return "CostumerAndressModel{" +
                "street='" + street + '\'' +
                ", number=" + number +
                ", complement='" + complement + '\'' +
                ", district='" + district + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zipcode=" + zipcode +
                '}';
    }
}
