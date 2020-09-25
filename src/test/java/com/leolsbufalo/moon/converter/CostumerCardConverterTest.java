package com.leolsbufalo.moon.converter;

import com.leolsbufalo.moon.entity.CostumerCard;
import com.leolsbufalo.moon.model.CostumerCardModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CostumerCardConverterTest {

    @Test
    public void convertCostumerToEntityTest(){

        CostumerCardModel costumerCardModel = costumerCardModelMock();

        CostumerCard costumerCardConverted = new CostumerCardConverter().convertFromDto(costumerCardModelMock());

        assertEquals(costumerCardConverted.getMethod(), costumerCardModel.getMethod(), "method must be equal");
        assertEquals(costumerCardConverted.getNumber(), costumerCardModel.getNumber(), "number must be equal");
        assertEquals(costumerCardConverted.getCvc(), costumerCardModel.getCvc(), "cvc must be equal");
        assertEquals(costumerCardConverted.getName(), costumerCardModel.getName(), "name must be equal");
        assertEquals(costumerCardConverted.getDocumentNumber(), costumerCardModel.getDocumentNumber(), "document number must be equal");
        assertEquals(costumerCardConverted.getExpirationMonth(), costumerCardModel.getExpirationMonth(), "Expiration Month must be equal");
        assertEquals(costumerCardConverted.getExpirationYear(), costumerCardModel.getExpirationYear(), "Expiration year must be equal");

    }

    @Test
    public void converterCostumerToModelTest(){

        CostumerCard costumerCard = costumerCardEntityMock();

        CostumerCardModel costumerCardModelConverted = new CostumerCardConverter().convertFromEntity(costumerCardEntityMock());

        assertEquals(costumerCardModelConverted.getMethod(), costumerCard.getMethod(), "method must be equal");
        assertEquals(costumerCardModelConverted.getNumber(), costumerCard.getNumber(), "number must be equal");
        assertEquals(costumerCardModelConverted.getCvc(), costumerCard.getCvc(), "cvc must be equal");
        assertEquals(costumerCardModelConverted.getName(), costumerCard.getName(), "name must be equal");
        assertEquals(costumerCardModelConverted.getDocumentNumber(), costumerCard.getDocumentNumber(), "document number must be equal");
        assertEquals(costumerCardModelConverted.getExpirationMonth(), costumerCard.getExpirationMonth(), "Expiration Month must be equal");
        assertEquals(costumerCardModelConverted.getExpirationYear(), costumerCard.getExpirationYear(), "Expiration year must be equal");

    }


    public CostumerCard costumerCardEntityMock() {
        return new CostumerCard(
                "credit card",
                "909909909909909",
                000,
                "Michelangelo di Lodovico Buonarroti Simoni",
                "06200450005",
                10,
                2030);
    }

    public CostumerCardModel costumerCardModelMock() {
        return new CostumerCardModel(
                "credit card",
                "909909909909909",
                000,
                "Michelangelo di Lodovico Buonarroti Simoni",
                "06200450005",
                10,
                2030);
    }
}


