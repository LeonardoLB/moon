package com.leolsbufalo.moon.model;


import javax.validation.constraints.*;

public class CostumerModel {
    @NotNull
    @Pattern(regexp = "[A-ZÁ-Úa-zá-ú ]{0,255}", message = "Bad Name, we don't accept special characters")
    private String name;
    @NotNull
    @Email(message = "Bad Email")
    private String email;
    @NotNull
    @Digits(integer = 5, fraction = 0)
    private int phoneCountryCode;
    @NotNull
    @Digits(integer = 3, fraction = 0)
    private int phoneAreaCode;
    @NotNull
    @Min(value = 1, message = "Bad Phone Number, must be bigger than 0")
    private int phoneNumber;
    @NotNull
    @Pattern(regexp = "(0?[1-9]|1[0-2])/([0-2]?[1-9]|[1-3][01])/\\d{4}", message = "Bad Birth Date pattern dd/MM/yyyy")
    private String birthDate;
    @NotNull
    @Pattern(regexp = "[0-9]{0,20}", message = "Bad Document Number, just use number in string format")
    private String documentNumber;

    public CostumerModel(String name, String email, int phoneCountryCode, int phoneAreaCode, int phoneNumber, String birthDate, String documentNumber) {
        this.name = name;
        this.email = email;
        this.phoneCountryCode = phoneCountryCode;
        this.phoneAreaCode = phoneAreaCode;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.documentNumber = documentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "CostumerModel{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneCountryCode=" + phoneCountryCode +
                ", phoneAreaCode=" + phoneAreaCode +
                ", phoneNumber=" + phoneNumber +
                ", birthDate='" + birthDate + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                '}';
    }
}
