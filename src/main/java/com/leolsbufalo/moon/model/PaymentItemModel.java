package com.leolsbufalo.moon.model;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class PaymentItemModel {
    @NotNull(message = "Bad Currency, must not be null")
    @Pattern(regexp = "[A-Za-z ]{0,255}", message = "Bad Description, just use letters")
    private String description;
    @NotNull(message = "Bad Currency, must not be null")
    @Min(value = 1, message = "Value must be bigger than 0")
    private int quantity;
    @NotNull(message = "Bad Currency, must not be null")
    @Min(value = 1, message = "Value must be bigger than 0")
    private int priceInCents;

    public PaymentItemModel(String description, int quantity, int priceInCents) {
        this.description = description;
        this.quantity = quantity;
        this.priceInCents = priceInCents;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPriceInCents() {
        return priceInCents;
    }

    public void setPriceInCents(int priceInCents) {
        this.priceInCents = priceInCents;
    }

    @Override
    public String toString() {
        return "PaymentItemModel{" +
                "description='" + description + '\'' +
                ", quantity=" + quantity +
                ", priceInCents=" + priceInCents +
                '}';
    }
}
