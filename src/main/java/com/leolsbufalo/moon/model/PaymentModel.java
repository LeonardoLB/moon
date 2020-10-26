package com.leolsbufalo.moon.model;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

public class PaymentModel {

    @NotNull(message = "Bad Currency, must not be null")
    @Pattern(regexp = "[a-zA-Z]{3}", message = "Bad Currency")
    private String currency;
    @NotNull(message = "Bad Currency, must not be null")
    @Min(value = 1, message = "Value must be bigger than 1")
    private Integer valueInCents;
    @NotNull(message = "Bad Currency, must not be null")
    @Min(value = 1, message = "Value must be bigger than 1")
    private int installments;
    @Valid
    private List<ItemModel> items;
    @Valid
    private CostumerCardModel costumerCard;
    @Valid
    private CostumerAndressModel costumerAndress;
    @Valid
    private CostumerModel costumer;

    public PaymentModel(String currency, int valueInCents, int installments, List<ItemModel> items, CostumerCardModel costumerCard, CostumerAndressModel costumerAndress, CostumerModel costumer) {
        this.currency = currency;
        this.valueInCents = valueInCents;
        this.installments = installments;
        this.items = items;
        this.costumerCard = costumerCard;
        this.costumerAndress = costumerAndress;
        this.costumer = costumer;
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

    public List<ItemModel> getItems() {
        return items;
    }

    public void setItems(List<ItemModel> items) {
        this.items = items;
    }

    public CostumerCardModel getCostumerCard() {
        return costumerCard;
    }

    public void setCostumerCard(CostumerCardModel costumerCard) {
        this.costumerCard = costumerCard;
    }

    public CostumerAndressModel getCostumerAndress() {
        return costumerAndress;
    }

    public void setCostumerAndress(CostumerAndressModel costumerAndress) {
        this.costumerAndress = costumerAndress;
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
                ", costumerAndress=" + costumerAndress +
                ", costumers=" + costumer +
                '}';
    }
}