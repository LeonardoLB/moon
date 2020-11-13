package com.leolsbufalo.moon.converter;

import com.leolsbufalo.moon.entity.PaymentCard;
import com.leolsbufalo.moon.model.PaymentCardModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CostumerCardConverterTest {

    @Test
    public void convertCostumerToEntityTest(){

        PaymentCardModel paymentCardModel = costumerCardModelMock();

        PaymentCard costumerCardConverted = new PaymentCardConverter().convertFromDto(costumerCardModelMock());

        assertEquals(costumerCardConverted.getMethod(), paymentCardModel.getMethod(), "method must be equal");
        assertEquals(costumerCardConverted.getNumber(), paymentCardModel.getNumber(), "number must be equal");
        assertEquals(costumerCardConverted.getCvc(), paymentCardModel.getCvc(), "cvc must be equal");
        assertEquals(costumerCardConverted.getName(), paymentCardModel.getName(), "name must be equal");
        assertEquals(costumerCardConverted.getDocumentNumber(), paymentCardModel.getDocumentNumber(), "document number must be equal");
        assertEquals(costumerCardConverted.getExpirationMonth(), paymentCardModel.getExpirationMonth(), "Expiration Month must be equal");
        assertEquals(costumerCardConverted.getExpirationYear(), paymentCardModel.getExpirationYear(), "Expiration year must be equal");

    }

    @Test
    public void converterCostumerToModelTest(){

        PaymentCard costumerCard = costumerCardEntityMock();

        PaymentCardModel paymentCardModelConverted = new PaymentCardConverter().convertFromEntity(costumerCardEntityMock());

        assertEquals(paymentCardModelConverted.getMethod(), costumerCard.getMethod(), "method must be equal");
        assertEquals(paymentCardModelConverted.getNumber(), costumerCard.getNumber(), "number must be equal");
        assertEquals(paymentCardModelConverted.getCvc(), costumerCard.getCvc(), "cvc must be equal");
        assertEquals(paymentCardModelConverted.getName(), costumerCard.getName(), "name must be equal");
        assertEquals(paymentCardModelConverted.getDocumentNumber(), costumerCard.getDocumentNumber(), "document number must be equal");
        assertEquals(paymentCardModelConverted.getExpirationMonth(), costumerCard.getExpirationMonth(), "Expiration Month must be equal");
        assertEquals(paymentCardModelConverted.getExpirationYear(), costumerCard.getExpirationYear(), "Expiration year must be equal");

    }


    public PaymentCard costumerCardEntityMock() {
        return new PaymentCard(
                "credit card",
                "909909909909909",
                000,
                "Michelangelo di Lodovico Buonarroti Simoni",
                "06200450005",
                10,
                2030);
    }

    public PaymentCardModel costumerCardModelMock() {
        return new PaymentCardModel(
                "credit card",
                "909909909909909",
                000,
                "Michelangelo di Lodovico Buonarroti Simoni",
                "06200450005",
                10,
                2030);
    }
}


