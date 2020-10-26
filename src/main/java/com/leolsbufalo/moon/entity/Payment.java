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
    private String currency;
    private int valueInCents;
    private int installments;

    @OneToMany(mappedBy = "payment", fetch = FetchType.LAZY)
    private List<Item> items;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "costumer_card_id", referencedColumnName = "id")
    private CostumerCard costumerCard;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "costumer_andress_id", referencedColumnName = "id")
    private CostumerAndress costumerAndress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "costumer_id", referencedColumnName = "id")
    private Costumer costumer;


    public Payment(String currency, int valueInCents, int installments, List<Item> items, CostumerCard costumerCard, CostumerAndress costumerAndress, Costumer costumer) {
        this.currency = currency;
        this.valueInCents = valueInCents;
        this.installments = installments;
        this.items = items;
        this.costumerCard = costumerCard;
        this.costumerAndress = costumerAndress;
        this.costumer = costumer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public CostumerCard getCostumerCard() { return costumerCard; }

    public void setCostumerCard(CostumerCard costumerCard) {
        this.costumerCard = costumerCard;
    }

    public CostumerAndress getCostumerAndress() {
        return costumerAndress;
    }

    public void setCostumerAndress(CostumerAndress costumerAndress) {
        this.costumerAndress = costumerAndress;
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
                ", items=" + items +
                ", costumerCard=" + costumerCard +
                ", costumerAndress=" + costumerAndress +
                ", costumer=" + costumer +
                '}';
    }
}
