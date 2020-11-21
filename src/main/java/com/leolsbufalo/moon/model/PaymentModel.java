package com.leolsbufalo.moon.model;

import com.leolsbufalo.moon.util.UniqueGenerator;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

public class PaymentModel {

    private String unique_id = new UniqueGenerator().uniqueIdGenerator();
    @NotNull(message = "Bad Currency, must not be null")
    @Pattern(regexp = "[a-zA-Z]{3}", message = "Bad Currency")
    private String currency;
    @NotNull(message = "Bad Value, must not be null")
    @Min(value = 1, message = "Value must be bigger than 0")
    private Integer valueInCents;
    @NotNull(message = "Bad Installments, must not be null")
    @Min(value = 1, message = "Value must be bigger than 0")
    private int installments;
    @Valid
    private List<PaymentItemModel> items;
    @Valid
    private PaymentCardModel costumerCard;
    @Valid
    private CostumerModel costumer;

    public PaymentModel(String currency, int valueInCents, int installments, List<PaymentItemModel> items, PaymentCardModel costumerCard, CostumerModel costumer) {
        this.currency = currency;
        this.valueInCents = valueInCents;
        this.installments = installments;
        this.items = items;
        this.costumerCard = costumerCard;
        this.costumer = costumer;
    }

    public String getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(String unique_id) {
        this.unique_id = unique_id;
    }

    public void setValueInCents(Integer valueInCents) {
        this.valueInCents = valueInCents;
    }

    public String getCurrency() { return currency; }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getValueInCents() {
        return valueInCents;
    }

    public void setValueInCents(int valueInCents) {
        this.valueInCents = valueInCents;
    }

    public int getInstallments() {
        return installments;
    }

    public void setInstallments(int installments) {
        this.installments = installments;
    }

    public List<PaymentItemModel> getItems() {
        return items;
    }

    public void setItems(List<PaymentItemModel> items) {
        this.items = items;
    }

    public PaymentCardModel getCostumerCard() {
        return costumerCard;
    }

    public void setCostumerCard(PaymentCardModel costumerCard) {
        this.costumerCard = costumerCard;
    }

    public CostumerModel getCostumer() {
        return costumer;
    }

    public void setCostumer(CostumerModel costumer) {
        this.costumer = costumer;
    }

    @Override
    public String toString() {
        return "PaymentModel{" +
                "currency='" + currency + '\'' +
                ", valueInCents=" + valueInCents +
                ", installments=" + installments +
                ", items=" + items +
                ", costumerCard=" + costumerCard +
                ", costumers=" + costumer +
                '}';
    }
}