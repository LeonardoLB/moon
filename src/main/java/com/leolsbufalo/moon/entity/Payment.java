package com.leolsbufalo.moon.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String unique_id;
    private String currency;
    private int valueInCents;
    private int installments;

    @OneToMany(mappedBy = "payment", fetch = FetchType.LAZY)
    private List<PaymentItem> PaymentItems;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_card_id", referencedColumnName = "id")
    private PaymentCard costumerCard;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "costumer_id", referencedColumnName = "id")
    private Costumer costumer;


    public Payment(String unique_id, String currency, int valueInCents, int installments, List<PaymentItem> PaymentItems, PaymentCard costumerCard, Costumer costumer) {
        this.unique_id = unique_id;
        this.currency = currency;
        this.valueInCents = valueInCents;
        this.installments = installments;
        this.PaymentItems = PaymentItems;
        this.costumerCard = costumerCard;
        this.costumer = costumer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(String unique_id) {
        this.unique_id = unique_id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) { this.currency = currency; }

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

    public List<PaymentItem> getItems() {
        return PaymentItems;
    }

    public void setItems(List<PaymentItem> PaymentItems) {
        this.PaymentItems = PaymentItems;
    }

    public PaymentCard getCostumerCard() { return costumerCard; }

    public void setCostumerCard(PaymentCard costumerCard) {
        this.costumerCard = costumerCard;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public String toJson() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(this);
            return json;
        } catch (JsonProcessingException exception) {
            throw new RuntimeException("Failure to parse Payment to Json");
        }
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", currency='" + currency + '\'' +
                ", valueInCents=" + valueInCents +
                ", installments=" + installments +
                ", items=" + PaymentItems +
                ", costumerCard=" + costumerCard +
                ", costumer=" + costumer +
                '}';
    }
}
