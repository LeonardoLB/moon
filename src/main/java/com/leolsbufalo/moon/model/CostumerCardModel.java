package com.leolsbufalo.moon.model;


import javax.validation.constraints.*;

public class CostumerCardModel {
    @NotNull
    @Pattern(regexp = "[a-zA-Z ]{0,20}", message = "Bad Method, just use letters")
    private String method;
    @NotNull
    @Pattern(regexp = "[0-9]{14,16}", message = "Bad Card Number, just use number in string format")
    private String number;
    @NotNull
    @Digits(integer = 3, fraction = 0, message = "Value must have 3 digits")
    private int cvc;
    @NotNull
    @Pattern(regexp = "[A-ZÁ-Úa-zá-ú ]{0,255}", message = "Bad Name, just use letters")
    private String name;
    @NotNull
    @Pattern(regexp = "[0-9]{0,20}", message = "Bad Document Number, just use number in string format")
    private String documentNumber;
    @NotNull
    @Min(value = 1, message = "Value must be bigger than 0")
    @Max(value = 12, message = "Value must be equal or less than 12")
    private int expirationMonth;
    @NotNull
    @Min(value = 1930, message = "Value must be bigger than 1930")
    private int expirationYear;

    public CostumerCardModel(String method, String number, int cvc, String name, String documentNumber, int expirationMonth, int expirationYear) {
        this.method = method;
        this.number = number;
        this.cvc = cvc;
        this.name = name;
        this.documentNumber = documentNumber;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
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

    @Override
    public String toString() {
        return "CostumerCardModel{" +
                "method='" + method + '\'' +
                ", number='" + number + '\'' +
                ", cvc=" + cvc +
                ", name='" + name + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", expirationMonth=" + expirationMonth +
                ", expirationYear=" + expirationYear +
                '}';
    }
}
